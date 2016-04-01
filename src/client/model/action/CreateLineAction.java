package client.model.action;

import client.model.drawing.Drawing;
import client.model.drawingComponents.LineComponent;

import java.awt.*;

public class CreateLineAction implements Action {
    private Drawing drawing;
    private LineComponent line = null;

    public CreateLineAction(Drawing drawing, Point start, Point end, boolean invertWidth, boolean invertHeight, Color background) {
        this.drawing = drawing;
        this.line = new LineComponent(start, end, invertWidth, invertHeight, background, Color.black);
    }

    @Override
    public void invoke() {
        line.setSelected(true);
        drawing.addDrawingComponent(line);
        drawing.setCurrentComponentSelected(line);
    }

    @Override
    public void undo() {
        line.remove();
        line.remove();
    }
}
