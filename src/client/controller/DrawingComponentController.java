package client.controller;

import client.view.DrawingComponentView;

abstract public class DrawingComponentController {
    private DrawingComponentView drawingComponentView;

    public DrawingComponentController(DrawingComponentView drawingComponentView) {
        this.drawingComponentView = drawingComponentView;
    }
}
