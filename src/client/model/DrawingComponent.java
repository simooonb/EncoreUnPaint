package client.model;

import java.awt.*;

abstract public class DrawingComponent {
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
