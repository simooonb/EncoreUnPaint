package client.controller;

import client.model.*;
import client.view.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingContainerController implements DrawingListener {
    private DrawingContainerView drawingContainerView;
    private Point startingPoint = null, endingPoint = null, clickingPoint = null;

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
            drawingContainerView.addView(drawingComponentView);
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

                @Override
                public void onSelected() {

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
            String currentStatus = drawingContainerView.getCurrentStatus();
            if(currentStatus.equals("none"))
                return;

            switch (currentStatus) {
                case "line":
                case "rectangle":
                case "oval":
                    // when the user click, we memorize the starting coordonates
                    startingPoint = me.getPoint();
                    break;
                case "fill":  // fill or selection
                    drawingContainerView.getDrawingComponentViewList().stream().filter(component -> component instanceof RectangleComponentView && component.getBounds().contains(me.getPoint())).forEach(component -> {
                        component.getDrawingComponent().fireColorChanged();
                    });
                    break;
                case "selection":
                    clickingPoint = me.getPoint();
                    DrawingComponentView drawingComponentView = drawingContainerView.clickingPointInContainerView(clickingPoint);
                    if (drawingComponentView != null) {
                        System.out.println("clicked on component");
                        drawingComponentView.getDrawingComponent().setSelected(true);
                    }
                    break;
            }

        }

        @Override
        public void mouseReleased(MouseEvent me){
            endingPoint = me.getPoint();
            switch (drawingContainerView.getCurrentStatus()) {
                case "selection": {

                    break;
                }

                case "fill": {

                    break;
                }

                case "line": {
                    int width = endingPoint.x - startingPoint.x;
                    int height = endingPoint.y - startingPoint.y;

                    if(width < 0 ){
                        int tmp = startingPoint.x;
                        startingPoint.x = endingPoint.x;
                        endingPoint.x = tmp;
                    }

                    if(height < 0){
                        int tmp = startingPoint.y;
                        startingPoint.y = endingPoint.y;
                        endingPoint.y = tmp;
                    }
                    drawingContainerView.getDrawing().addDrawingComponent(new LineComponent(startingPoint,endingPoint,drawingContainerView.getCurrentColorBackground(),drawingContainerView.getCurrentColorForeground()));
                    break;
                }

                case "rectangle": {
                    Dimension dimRectangle = new Dimension(endingPoint.x - startingPoint.x, endingPoint.y - startingPoint.y);
                    drawingContainerView.getDrawing().addDrawingComponent(new RectangleComponent(new Rectangle(startingPoint,dimRectangle),drawingContainerView.getCurrentColorBackground(),drawingContainerView.getCurrentColorForeground()));
                    break;
                }

                case "oval": {
                    Dimension dimOval = new Dimension(endingPoint.x - startingPoint.x, endingPoint.y - startingPoint.y);
                    drawingContainerView.getDrawing().addDrawingComponent(new OvalComponent(new Rectangle(startingPoint,dimOval),drawingContainerView.getCurrentColorBackground(),drawingContainerView.getCurrentColorForeground()));
                    break;
                }

                default : {
                }
            }
        }
    }
}
