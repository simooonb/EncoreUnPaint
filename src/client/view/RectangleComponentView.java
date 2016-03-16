package client.view;

import client.model.RectangleComponent;

public class RectangleComponentView extends DrawingComponentView {
    private RectangleComponent rectangle;

    public RectangleComponentView() {

    }

    public RectangleComponent getRectangle() {
        return rectangle;
    }

    public void setRectangle(RectangleComponent rectangle) {
        this.rectangle = rectangle;
    }
}
