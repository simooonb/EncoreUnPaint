package client.model;

import java.awt.*;

public class LineComponent extends DrawingComponent {
    private Point first, second;

    public LineComponent(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    public Point getFirstPoint() {
        return first;
    }

    public Point getSecondPoint() {
        return second;
    }
}
