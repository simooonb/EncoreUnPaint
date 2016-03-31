package client.model.drawing;

import client.model.action.ActionStack;
import client.model.drawingComponents.DrawingComponent;
import client.model.drawingComponents.DrawingComponentListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private List<DrawingComponent> drawingComponents = new ArrayList<>();
    private List<DrawingListener> drawingListeners = new ArrayList<>();
    private ActionStack actionStack = new ActionStack();
    private String currentStatus = "none";
    private Color foregroundColor = Color.black;
    private Color backgroundColor = Color.black;
    private DrawingComponent currentComponentSelected = null;

    public Drawing() {

    }

    public DrawingComponent getDrawingComponent(int id) {
        return id >= 0 && id < drawingComponents.size() ? drawingComponents.get(id) : null;
    }

    public void addDrawingComponent(DrawingComponent drawingComponent) {
        drawingComponents.add(drawingComponent);
        drawingComponent.setDrawing(this);
        fireDrawingComponentAdded(drawingComponent);
        drawingComponent.addDrawingComponentListener(new DrawingComponentListener() {
            @Override
            public void onMoved() {

            }

            @Override
            public void onRemoved() {
                drawingComponents.remove(drawingComponent);
            }

            @Override
            public void onColorChanged() {

            }

            @Override
            public void onSelected(){}

            @Override
            public void onUnselected(){}
        });
    }

    public void addDrawingListener(DrawingListener drawingListener) {
        drawingListeners.add(drawingListener);
    }

    public void removeDrawingListener(DrawingListener drawingListener) {
        drawingListeners.remove(drawingListener);
    }

    private void fireDrawingComponentAdded(DrawingComponent drawingComponent) {
        for (DrawingListener listener : drawingListeners) {
            listener.onDrawingComponentAdded(drawingComponent);
        }
    }

    public void fireDrawingComponentRemoved(DrawingComponent drawingComponent) {
        for (DrawingListener listener : drawingListeners) {
            listener.onDrawingComponentRemoved(drawingComponent);
        }
    }

    public List<DrawingComponent> getDrawingComponents() {
        return drawingComponents;
    }


    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        if(currentComponentSelected != null){
            currentComponentSelected.setForegroundColor(foregroundColor);
            currentComponentSelected.fireColorChanged();
        }
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        if(currentComponentSelected != null){
            currentComponentSelected.setBackgroundColor(backgroundColor);
            currentComponentSelected.fireColorChanged();
        }
    }



    public ActionStack getActionStack() {
        return actionStack;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public DrawingComponent getCurrentComponentSelected() {
        return currentComponentSelected;
    }

    public void setCurrentComponentSelected(DrawingComponent currentComponentSelected) {
        this.currentComponentSelected = currentComponentSelected;
    }
}
