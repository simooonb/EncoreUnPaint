package client.controller;

import client.view.ClientContainerView;
import client.view.ClientFrameView;

public class ClientFrameController {
    private ClientFrameView clientFrameView;

    public ClientFrameController(ClientFrameView clientFrameView) {
        this.clientFrameView = clientFrameView;

        ClientContainerView clientContainerView = clientFrameView.getClientContainerView();
        new ClientContainerController(clientContainerView);
    }
}
