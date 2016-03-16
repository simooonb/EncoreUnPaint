package client.controller;

import client.view.OvalComponentView;

public class OvalComponentController extends DrawingComponentController {
    private OvalComponentView ovalComponentView;

    public OvalComponentController(OvalComponentView ovalComponentView) {
        super(ovalComponentView);

        this.ovalComponentView = ovalComponentView;
    }
}
