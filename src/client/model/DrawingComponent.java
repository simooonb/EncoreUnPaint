package client.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

abstract public class DrawingComponent {
    private Color color;
    private List<DrawingComponentListener> drawingComponentListeners = new ArrayList<>();

    public DrawingComponent(Color color){
        setColor(color);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        fireColorChanged();
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
}
