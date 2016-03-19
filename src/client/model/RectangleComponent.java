package client.model;

import java.awt.*;

public class RectangleComponent extends DrawingComponent {
    private Rectangle boundingBox;

    public RectangleComponent(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
}
