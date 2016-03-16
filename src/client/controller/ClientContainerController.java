package client.controller;

import client.view.ClientContainerView;
import client.view.DrawingContainerView;
import client.view.ToolbarView;

public class ClientContainerController {
    private ClientContainerView clientContainerView;

    public ClientContainerController(ClientContainerView clientContainerView) {
        this.clientContainerView = clientContainerView;

        ToolbarView toolbarView = clientContainerView.getToolbarView();
        DrawingContainerView drawingContainerView = clientContainerView.getDrawingContainerView();

        new ToolbarController(toolbarView);
        new DrawingContainerController(drawingContainerView);
    }
}
