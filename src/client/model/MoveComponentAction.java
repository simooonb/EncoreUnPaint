package client.model;

import client.view.DrawingComponentView;

import java.awt.*;

public class MoveComponentAction implements Action {
    private DrawingComponentView drawingComponentView;
    private Point previousPosition, newPosition;

    public MoveComponentAction(DrawingComponentView slideComponentView, Point newPosition) {
        this.drawingComponentView = slideComponentView;
        this.newPosition = newPosition;
        this.previousPosition = null;
    }

    @Override
    public void invoke() {
        previousPosition = drawingComponentView.getDrawingComponent().getPosition();
        drawingComponentView.getDrawingComponent().setPosition(newPosition);
        drawingComponentView.update();
    }

    @Override
    public void undo() {
        drawingComponentView.getDrawingComponent().setPosition(previousPosition);
        previousPosition = null;
        drawingComponentView.update();
    }
}

