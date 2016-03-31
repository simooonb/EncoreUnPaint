package client.model.drawing;

import client.model.drawingComponents.DrawingComponent;

public interface DrawingListener {
    void onDrawingComponentAdded(DrawingComponent drawingComponent);
    void onDrawingComponentRemoved(DrawingComponent drawingComponent);
}
