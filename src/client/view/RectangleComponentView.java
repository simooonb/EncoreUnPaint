package client.view;

import client.model.RectangleComponent;

public class RectangleComponentView extends DrawingComponentView {
    private RectangleComponent rectangle;

    public RectangleComponentView(RectangleComponent rectangle) {
        super(rectangle);
        this.rectangle = rectangle;
        setOpaque(false);
        update();
    }

    @Override
    public void update() {
        super.update();
    }

    public RectangleComponent getRectangle() {
        return rectangle;
    }

    public void setRectangle(RectangleComponent rectangle) {
        this.rectangle = rectangle;
    }
}
