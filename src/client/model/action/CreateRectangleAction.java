package client.model.action;

import client.model.drawing.Drawing;
import client.model.drawingComponents.RectangleComponent;

import java.awt.*;

public class CreateRectangleAction implements Action {
    private Dimension dimension;
    private Color background, foreground;
    private Point position;
    private Drawing drawing;
    private RectangleComponent rectangleComponent = null;

    public CreateRectangleAction(Drawing drawing, Point position, Dimension dimension, Color background, Color foreground) {
        this.position = position;
        this.drawing = drawing;
        this.dimension = dimension;
        this.background = background;
        this.foreground = foreground;
        rectangleComponent = new RectangleComponent(new Rectangle(position, dimension), background, foreground);
    }

    @Override
    public void invoke() {
        rectangleComponent.setSelected(true);
        drawing.setCurrentComponentSelected(rectangleComponent);
        drawing.addDrawingComponent(rectangleComponent);
    }

    @Override
    public void undo() {
        rectangleComponent.remove();
        rectangleComponent.remove();
    }
}
