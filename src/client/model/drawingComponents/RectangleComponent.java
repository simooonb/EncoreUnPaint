package client.model.drawingComponents;

import java.awt.*;

public class RectangleComponent extends DrawingComponent {
    private Rectangle boundingBox;

    public RectangleComponent(Rectangle boundingBox,Color backgroundColor, Color foregroundColor) {
        super(new Point(boundingBox.x,boundingBox.y),new Dimension(boundingBox.width,boundingBox.height),backgroundColor, foregroundColor);
        this.boundingBox = boundingBox;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
}
