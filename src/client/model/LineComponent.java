package client.model;

import java.awt.*;

public class LineComponent extends DrawingComponent {
    private Point first, second;

    public LineComponent(Point first, Point second,Color backgroundColor, Color foregroundColor) {
        super(first,new Dimension(Math.abs(second.x - first.x), Math.abs(second.y - first.y)),backgroundColor,foregroundColor);
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
