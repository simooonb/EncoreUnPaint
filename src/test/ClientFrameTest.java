package test;

import client.controller.ClientFrameController;
import client.view.ClientFrameView;

public class ClientFrameTest {
    public static void main(String[] args) {
        ClientFrameView frame = new ClientFrameView();
        new ClientFrameController(frame);
    }
}
