package client.controller;

import client.view.ClientContainerView;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;
import client.view.ToolbarView;

public class ClientContainerController {
    private ClientContainerView clientContainerView;

    public ClientContainerController(ClientContainerView clientContainerView) {
        this.clientContainerView = clientContainerView;

        ToolbarView toolbarView = clientContainerView.getToolbarView();
        DrawingContainerView drawingContainerView = clientContainerView.getDrawingContainerView();
        StatusAreaView statusAreaView = clientContainerView.getStatusAreaView();

        new ToolbarController(toolbarView,statusAreaView,drawingContainerView);
        new DrawingContainerController(drawingContainerView);
    }
}
