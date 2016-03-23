package client.model;

import java.awt.*;

public class LineComponent extends DrawingComponent {
    private Point first, second;

    public LineComponent(Point first, Point second) {
        super(first,new Dimension(second.x - first.x, second.y - first.y),Color.black); // currently black by default, TODO : get the current color chooser
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
