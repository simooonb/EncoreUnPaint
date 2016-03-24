package client.controller;

import client.model.*;
import client.view.*;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingContainerController implements DrawingListener {
    private DrawingContainerView drawingContainerView;
    private Point startingPoint = null, endingPoint = null, clickingPoint = null;
    private DrawingComponent currentDrawingComponentSelected = null;

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
                public void onSelected() { }

                @Override
                public void onUnselected(){}
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
            if(currentDrawingComponentSelected != null) {
                currentDrawingComponentSelected.fireUnselected();
                currentDrawingComponentSelected = null;
            }
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
                    /*drawingContainerView.getDrawingComponentViewList().stream().filter(component -> component instanceof RectangleComponentView && component.getBounds().contains(me.getPoint())).forEach(component -> {
                        component.getDrawingComponent().fireColorChanged();
                    });*/
                    break;
                case "selection":
                    clickingPoint = me.getPoint();
                    DrawingComponentView drawingComponentViewSelected = drawingContainerView.clickingPointInContainerView(clickingPoint);
                    if (drawingComponentViewSelected != null) {
                        System.out.println("clicked on component");
                        currentDrawingComponentSelected = drawingComponentViewSelected.getDrawingComponent();
                        currentDrawingComponentSelected.fireSelected();
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
                    LineComponent newLineComponent = new LineComponent(startingPoint,endingPoint,drawingContainerView.getCurrentColorBackground(),drawingContainerView.getCurrentColorForeground());
                    newLineComponent.setSelected(true);
                    currentDrawingComponentSelected = newLineComponent;
                    drawingContainerView.getDrawing().addDrawingComponent(newLineComponent);
                    break;
                }

                case "rectangle": {
                    Dimension dimRectangle = new Dimension(endingPoint.x - startingPoint.x, endingPoint.y - startingPoint.y);
                    RectangleComponent newRectangleComponent = new RectangleComponent(new Rectangle(startingPoint,dimRectangle),drawingContainerView.getCurrentColorBackground(),drawingContainerView.getCurrentColorForeground());
                    newRectangleComponent.setSelected(true);
                    currentDrawingComponentSelected = newRectangleComponent;
                    drawingContainerView.getDrawing().addDrawingComponent(newRectangleComponent);
                    break;
                }

                case "oval": {
                    Dimension dimOval = new Dimension(endingPoint.x - startingPoint.x, endingPoint.y - startingPoint.y);
                    OvalComponent newOvalComponent = new OvalComponent(new Rectangle(startingPoint,dimOval),drawingContainerView.getCurrentColorBackground(),drawingContainerView.getCurrentColorForeground());
                    newOvalComponent.setSelected(true);
                    currentDrawingComponentSelected = newOvalComponent;
                    drawingContainerView.getDrawing().addDrawingComponent(newOvalComponent);
                    break;
                }

                default : {
                }
            }
        }
    }
}
