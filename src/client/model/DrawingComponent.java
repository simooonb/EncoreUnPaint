package client.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

abstract public class DrawingComponent {
    private Color backgroundColor;
    private Color foreGroundColor;
    private List<DrawingComponentListener> drawingComponentListeners = new ArrayList<>();
    private Point position = new Point(0,0);
    private Dimension size = new Dimension(50,50);

    public DrawingComponent(Point position,Dimension size,Color backgroundColor, Color foreGroundColor){
       this.position = position;
        this.size = size;
        this.backgroundColor = backgroundColor;
        this.foreGroundColor = foreGroundColor;
    }

    public void addDrawingComponentListener(DrawingComponentListener listener) {
        drawingComponentListeners.add(listener);
    }

    public void removeDrawingComponentListener(DrawingComponentListener listener) {
        drawingComponentListeners.remove(listener);
    }

    public void fireMoved() {
        for (DrawingComponentListener listener : drawingComponentListeners) {
            listener.onMoved();
        }
    }

    public void fireRemoved() {
        for (DrawingComponentListener listener : drawingComponentListeners) {
            listener.onRemoved();
        }
    }

    public void fireColorChanged() {
        for (DrawingComponentListener listener : drawingComponentListeners) {
            listener.onColorChanged();
        }
    }

    public void remove() {
        fireRemoved();
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getForeGroundColor() {
        return foreGroundColor;
    }
}
