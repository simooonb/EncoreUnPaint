package client.model;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private List<DrawingComponent> drawingComponents = new ArrayList<>();
    private List<DrawingListener> drawingListeners = new ArrayList<>();

    public Drawing() {

    }

    public List<DrawingComponent> getDrawingComponents() {
        return drawingComponents;
    }

    public DrawingComponent getDrawingComponent(int id) {
        return id >= 0 && id < drawingComponents.size() ? drawingComponents.get(id) : null;
    }

    public void addDrawingComponent(DrawingComponent drawingComponent) {
        System.out.println("add : "+drawingComponent);
        drawingComponents.add(drawingComponent);
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
        });
    }

    public void addDrawingListener(DrawingListener drawingListener) {
        drawingListeners.add(drawingListener);
    }

    public void removeDrawingListener(DrawingListener drawingListener) {
        drawingListeners.remove(drawingListener);
    }

    public void fireDrawingComponentAdded(DrawingComponent drawingComponent) {
        for (DrawingListener listener : drawingListeners) {
            listener.onDrawingComponentAdded(drawingComponent);
        }
    }

    public void fireDrawingComponentRemoved(DrawingComponent drawingComponent) {
        for (DrawingListener listener : drawingListeners) {
            listener.onDrawingComponentRemoved(drawingComponent);
        }
    }
}
