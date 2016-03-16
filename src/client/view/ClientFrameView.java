package client.view;

import client.model.Drawing;

import javax.swing.*;
import java.awt.*;

public class ClientFrameView extends JFrame {
    private Drawing drawing;

    private ClientContainerView clientContainerView = new ClientContainerView();

    public ClientFrameView() {
        add(clientContainerView);

        setTitle("JPaint");
        setSize(new Dimension(600, 600));
        setVisible(true);
    }
}
