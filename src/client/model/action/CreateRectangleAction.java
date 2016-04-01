package client.model.action;

import client.model.drawing.Drawing;
import client.model.drawingComponents.RectangleComponent;

import java.awt.*;

public class CreateRectangleAction implements Action {
    private Drawing drawing;
    private RectangleComponent rectangleComponent = null;

    public CreateRectangleAction(Drawing drawing, Point position, Dimension dimension, Color background, Color foreground) {
        this.drawing = drawing;
        rectangleComponent = new RectangleComponent(new Rectangle(position, dimension), background, foreground);
    }

    @Override
    public void invoke() {
        rectangleComponent.setSelected(true);
        drawing.addDrawingComponent(rectangleComponent);
        drawing.setCurrentComponentSelected(rectangleComponent);
    }

    @Override
    public void undo() {
        rectangleComponent.remove();
        rectangleComponent.remove();
    }
}
