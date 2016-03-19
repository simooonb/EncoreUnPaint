package client.model;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private List<DrawingComponent> drawingComponents;

    public Drawing() {
        drawingComponents = new ArrayList<>();
    }

    public List<DrawingComponent> getDrawingComponents() {
        return drawingComponents;
    }

    public DrawingComponent getDrawingComponent(int id) {
        return id >= 0 && id < drawingComponents.size() ? drawingComponents.get(id) : null;
    }

    public void addDrawingComponent(DrawingComponent drawingComponent) {
        System.out.println("add : "+drawingComponent);
        drawingComponents.add(drawingComponent); // think to informate the view of the adding component ?
    }
}
