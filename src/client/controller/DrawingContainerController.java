package client.controller;

import client.model.*;
import client.view.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingContainerController implements DrawingListener {
    private DrawingContainerView drawingContainerView;
    private Point startingPoint = null;
    private Point endingPoint = null;

    public DrawingContainerController(DrawingContainerView drawingContainerView) {
        this.drawingContainerView = drawingContainerView;

        drawingContainerView.addMouseListener(new DrawingContainerListener());
        drawingContainerView.getDrawing().addDrawingListener(this);

        updateView();
    }

    private void updateView() {
        if (drawingContainerView.getDrawingComponentViewList().size() != drawingContainerView.getDrawing().getDrawingComponents().size()) {
            refreshViews();
        }

        drawingContainerView.update();
    }

    private void refreshViews() {
        drawingContainerView.getDrawingComponentViewList().clear();

        for (DrawingComponent component : drawingContainerView.getDrawing().getDrawingComponents()) {
            DrawingComponentView drawingComponentView;

            if (component instanceof LineComponent) {
                drawingComponentView = new LineComponentView((LineComponent) component);
                new LineComponentController((LineComponentView) drawingComponentView);
            } else if (component instanceof OvalComponent) {
                drawingComponentView = new OvalComponentView((OvalComponent) component);
                new OvalComponentController((OvalComponentView) drawingComponentView);
            } else if (component instanceof RectangleComponent) {
                drawingComponentView = new RectangleComponentView((RectangleComponent) component);
                new RectangleComponentController((RectangleComponentView) drawingComponentView);
            } else {
                return;
            }

            drawingContainerView.add(drawingComponentView);
            drawingComponentView.getDrawingComponent().addDrawingComponentListener(new DrawingComponentListener() {
                @Override
                public void onMoved() {

                }

                @Override
                public void onRemoved() {
                    updateView();
                }

                @Override
                public void onColorChanged() {
                    updateView();
                }
            });
        }
    }

    @Override
    public void onDrawingComponentAdded(DrawingComponent drawingComponent) {
        updateView();
    }

    @Override
    public void onDrawingComponentRemoved(DrawingComponent drawingComponent) {
        updateView();
    }

    class DrawingContainerListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent me) {
            System.out.println("mouse pressed");
            String currentStatus = drawingContainerView.getCurrentStatus();
            if(currentStatus.equals("none"))
                return;
            if (currentStatus.equals("line") || currentStatus.equals("rectangle") || currentStatus.equals("oval"))  {
                // when the user click, we memorize the starting coordonates
                startingPoint = me.getPoint();
            }
            else { // fill or selection

            }

        }

        @Override
        public void mouseReleased(MouseEvent me){
            System.out.println("mouse released");
            endingPoint = me.getPoint();
            switch (drawingContainerView.getCurrentStatus()) {
                case "selection": {

                    break;
                }

                case "fill": {

                    break;
                }

                case "line": {
                        drawingContainerView.getDrawing().addDrawingComponent(new LineComponent(startingPoint,endingPoint));
                    break;
                }

                case "rectangle": {
                        Dimension dimRectangle = new Dimension(endingPoint.x - startingPoint.x, endingPoint.y - startingPoint.y);
                        drawingContainerView.getDrawing().addDrawingComponent(new RectangleComponent(new Rectangle(startingPoint,dimRectangle)));
                    break;
                }

                case "oval": {
                    Dimension dimOval = new Dimension(endingPoint.x - startingPoint.x, endingPoint.y - startingPoint.y);
                    drawingContainerView.getDrawing().addDrawingComponent(new OvalComponent(new Rectangle(startingPoint,dimOval)));
                    break;
                }

                default : {
                    return;
                }
            }
        }
    }
}
