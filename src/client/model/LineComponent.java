package client.model;

import java.awt.*;

public class LineComponent extends DrawingComponent {
    private Point first, second;

    public LineComponent(Point first, Point second, Color backgroundColor, Color foregroundColor) {
        super(first,new Dimension(second.x - first.x, second.y - first.y),backgroundColor,foregroundColor);
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
