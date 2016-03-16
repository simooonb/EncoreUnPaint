package client.view;

import client.model.Drawing;

import javax.swing.*;

public class ClientFrameView extends JFrame {
    private Drawing drawing = new Drawing();

    private ClientContainerView clientContainerView = new ClientContainerView(drawing);

    public ClientFrameView() {
        add(clientContainerView);

        setTitle("JPaint");
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
