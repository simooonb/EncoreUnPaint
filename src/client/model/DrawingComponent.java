package client.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

abstract public class DrawingComponent {
    private Color backgroundColor;
    private Color foregroundColor;
    private List<DrawingComponentListener> drawingComponentListeners = new ArrayList<>();
    private Point position = new Point(0,0);
    private Dimension size = new Dimension(50,50);
    private Drawing drawing;
    private boolean isSelected = false;

    public DrawingComponent(Point point,Dimension size,Color backgroundColor, Color foregroundColor){
        this.size = size;
        this.position = point;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    public DrawingComponent(Dimension size,Color backgroundColor, Color foregroundColor){
        this(new Point(0,0),size,backgroundColor,foregroundColor);
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

    public void fireSelected() {
        for (DrawingComponentListener listener : drawingComponentListeners){
            listener.onSelected();
        }
    }

    public void fireUnselected() {
        for (DrawingComponentListener listener : drawingComponentListeners){
            listener.onUnselected();
        }
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void remove() {
        fireRemoved();
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        if (this.position == position)
            return;

        this.position = position;
        fireMoved();
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

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        fireColorChanged();
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        fireColorChanged();
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }
}