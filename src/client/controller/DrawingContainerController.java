package client.controller;

import client.model.LineComponent;
import client.model.OvalComponent;
import client.model.RectangleComponent;
import client.view.DrawingContainerView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingContainerController {
    private DrawingContainerView drawingContainerView;
    private Point startingPoint = null;
    private Point endingPoint = null;

    public DrawingContainerController(DrawingContainerView drawingContainerView) {
        this.drawingContainerView = drawingContainerView;

        drawingContainerView.addMouseListener(new DrawingContainerListener());

        updateView();
    }

    private void updateView() {
        drawingContainerView.update();
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
