package client.controller;

import client.view.RectangleComponentView;

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

    }
}
