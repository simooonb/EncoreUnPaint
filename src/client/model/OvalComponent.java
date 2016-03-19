package client.model;

import java.awt.*;

public class OvalComponent extends DrawingComponent {
    private Rectangle boundingBox;

    public OvalComponent(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
}
