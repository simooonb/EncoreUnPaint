package client.controller.drawingComponents;

import client.view.drawingComponents.RectangleComponentView;

public class RectangleComponentController extends DrawingComponentController {
    private RectangleComponentView rectangleComponentView;

    public RectangleComponentController(RectangleComponentView rectangleComponentView) {
        super(rectangleComponentView);
        rectangleComponentView.getDrawingComponent().addDrawingComponentListener(this);
        this.rectangleComponentView = rectangleComponentView;
    }

    @Override
    public void onRemoved() {

    }

    @Override
    public void onColorChanged() {
        rectangleComponentView.setBackground(rectangleComponentView.getDrawingComponent().getDrawing().getBackgroundColor());
        System.out.println(rectangleComponentView.getBackground());
        rectangleComponentView.update();
    }

    @Override
    public void onSelected() {
        rectangleComponentView.getRectangle().setSelected(true);
        rectangleComponentView.update();
    }

    @Override
    public void onUnselected(){
        rectangleComponentView.getRectangle().setSelected(false);
        rectangleComponentView.update();
    }
}
