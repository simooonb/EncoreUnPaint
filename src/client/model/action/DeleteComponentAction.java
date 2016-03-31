package client.model.action;

import client.model.drawing.Drawing;
import client.model.drawingComponents.DrawingComponent;

public class DeleteComponentAction implements Action {
    private Drawing drawing;
    private DrawingComponent oldComponent = null;

    public DeleteComponentAction(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void invoke() {
        if (drawing.getCurrentComponentSelected() == null)
            return;

        oldComponent = drawing.getCurrentComponentSelected();
        drawing.getCurrentComponentSelected().remove();
        drawing.getCurrentComponentSelected().remove();
    }

    @Override
    public void undo() {
        drawing.addDrawingComponent(oldComponent);
        oldComponent = null;
    }
}
