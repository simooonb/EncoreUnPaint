package client.model;

import java.awt.*;

public class RectangleComponent extends DrawingComponent {
    private Rectangle boundingBox;

    public RectangleComponent(Rectangle boundingBox) {
        super(new Point(boundingBox.x,boundingBox.y),new Dimension(boundingBox.width,boundingBox.height),Color.black);
        this.boundingBox = boundingBox;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
}
