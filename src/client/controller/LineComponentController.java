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
    public void onRemoved() { }

    @Override
    public void onColorChanged() {}

    @Override
    public void onSelected() {
        lineComponentView.getDrawingComponent().setSelected(true);
        lineComponentView.update();
    }

    @Override
    public void onUnselected(){
        lineComponentView.getDrawingComponent().setSelected(false);
        lineComponentView.update();
    }
}
