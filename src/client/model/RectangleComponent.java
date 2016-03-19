package client.model;

import java.awt.*;

public class RectangleComponent extends DrawingComponent {
    private Rectangle boundingBox;

    public RectangleComponent(Rectangle boundingBox) {
        super(Color.black);
        this.boundingBox = boundingBox;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
}
