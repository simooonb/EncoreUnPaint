package client.view;

import client.model.DrawingComponent;
import client.model.LineComponent;
import client.model.OvalComponent;
import client.model.RectangleComponent;

import javax.swing.*;
import java.awt.*;

abstract public class DrawingComponentView extends JComponent {
    private DrawingComponent drawingComponent;
    private Point anchorPoint;

    public void update() {
        updateLocation();
    }

    private void updateLocation() {
        if (drawingComponent instanceof LineComponent) {
            setLocation((((LineComponent) drawingComponent).getFirstPoint().x + ((LineComponent) drawingComponent).getSecondPoint().x) / 2,
                        (((LineComponent) drawingComponent).getFirstPoint().y + ((LineComponent) drawingComponent).getSecondPoint().y) / 2);
        } else if (drawingComponent instanceof RectangleComponent) {
            setLocation(((RectangleComponent) drawingComponent).getBoundingBox().getLocation());
        } else if (drawingComponent instanceof OvalComponent) {
            setLocation(((OvalComponent) drawingComponent).getBoundingBox().getLocation());
        }
    }

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
