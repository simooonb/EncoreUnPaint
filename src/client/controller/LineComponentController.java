package client.controller;

import client.view.LineComponentView;

public class LineComponentController extends DrawingComponentController {
    private LineComponentView lineComponentView;

    public LineComponentController(LineComponentView lineComponentView) {
        super(lineComponentView);
        lineComponentView.getDrawingComponent().addDrawingComponentListener(this);
        this.lineComponentView = lineComponentView;
    }

    @Override
    public void onRemoved() {

    }

    @Override
    public void onColorChanged() {

    }
}
