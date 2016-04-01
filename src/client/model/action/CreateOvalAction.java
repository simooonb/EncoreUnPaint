package client.model.action;

import client.model.drawing.Drawing;
import client.model.drawingComponents.OvalComponent;

import java.awt.*;

public class CreateOvalAction implements Action {
    private Dimension dimension;
    private Color background, foreground;
    private Point position;
    private Drawing drawing;
    private OvalComponent ovalComponent = null;

    public CreateOvalAction(Drawing drawing, Point position, Dimension dimension, Color background, Color foreground) {
        this.position = position;
        this.drawing = drawing;
        this.dimension = dimension;
        this.background = background;
        this.foreground = foreground;
        ovalComponent = new OvalComponent(new Rectangle(position, dimension), background, foreground);
    }

    @Override
    public void invoke() {
        ovalComponent.setSelected(true);
        drawing.addDrawingComponent(ovalComponent);
        drawing.setCurrentComponentSelected(ovalComponent);
    }

    @Override
    public void undo() {
        ovalComponent.remove();
        ovalComponent.remove();
    }
}