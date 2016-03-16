package client.view;

import client.model.DrawingComponent;

import javax.swing.*;
import java.awt.*;

abstract public class DrawingComponentView extends JComponent {
    private DrawingComponent drawingComponent;
    private Point anchorPoint;

    public DrawingComponent getDrawingComponent() {
        return drawingComponent;
    }

    public void setDrawingComponent(DrawingComponent drawingComponent) {
        this.drawingComponent = drawingComponent;
    }

    public Point getAnchorPoint() {
        return anchorPoint;
    }

    public void setAnchorPoint(Point anchorPoint) {
        this.anchorPoint = anchorPoint;
    }
}
