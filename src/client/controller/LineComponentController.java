package client.controller;

import client.view.LineComponentView;

public class LineComponentController extends DrawingComponentController {
    private LineComponentView lineComponentView;

    public LineComponentController(LineComponentView lineComponentView) {
        super(lineComponentView);

        this.lineComponentView = lineComponentView;
    }
}
