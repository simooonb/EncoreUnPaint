package client.controller;

import client.view.OvalComponentView;

public class OvalComponentController extends DrawingComponentController {
    private OvalComponentView ovalComponentView;

    public OvalComponentController(OvalComponentView ovalComponentView) {
        super(ovalComponentView);
        ovalComponentView.getDrawingComponent().addDrawingComponentListener(this);
        this.ovalComponentView = ovalComponentView;
    }

    @Override
    public void onRemoved() { }

    @Override
    public void onColorChanged() { }

    @Override
    public void onSelected() {
        ovalComponentView.getOval().setSelected(true);
        ovalComponentView.update();
    }

    @Override
    public void onUnselected() {
        ovalComponentView.getOval().setSelected(false);
        ovalComponentView.update();
    }
}
