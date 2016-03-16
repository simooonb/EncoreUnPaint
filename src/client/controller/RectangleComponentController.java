package client.controller;

import client.view.RectangleComponentView;

public class RectangleComponentController extends DrawingComponentController {
    private RectangleComponentView rectangleComponentView;

    public RectangleComponentController(RectangleComponentView rectangleComponentView) {
        super(rectangleComponentView);

        this.rectangleComponentView = rectangleComponentView;
    }
}
