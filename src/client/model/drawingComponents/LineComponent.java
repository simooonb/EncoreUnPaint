package client.model.drawingComponents;

import java.awt.*;

public class LineComponent extends DrawingComponent {
    private Point first, second;
    private boolean invertHeight = false, invertWidth = false;

    public LineComponent(Point first, Point second, Color backgroundColor, Color foregroundColor) {
        this(first, second, false, false, backgroundColor, foregroundColor);
    }

    public LineComponent(Point first, Point second, boolean invertWidth, boolean invertHeight, Color backgroundColor, Color foregroundColor) {
        super(new Dimension(Math.abs(second.x - first.x), Math.abs(second.y - first.y)),backgroundColor,foregroundColor);
        this.first = first;
        this.second = second;
        this.invertHeight = invertHeight;
        this.invertWidth = invertWidth;
        if(invertHeight && invertWidth)
        {
            setPosition(second);
        }
        else if(invertHeight){
            setPosition(new Point(first.x,second.y));
        }
        else if(invertWidth)
        {
            setPosition(new Point(second.x,first.y));
        }
        else
        {
            setPosition(first);
        }
    }

    public Point getFirstPoint() {
        return first;
    }

    public Point getSecondPoint() {
        return second;
    }

    public boolean isInvertHeight() {
        return invertHeight;
    }

    public boolean isInvertWidth() {
        return invertWidth;
    }
}
