package client.view;

import client.model.drawing.Drawing;

import javax.swing.*;
import java.awt.*;

public class ClientFrameView extends JFrame {
    private Drawing drawing = new Drawing();

    private ClientContainerView clientContainerView = new ClientContainerView(this, drawing);

    public ClientFrameView() {
        add(clientContainerView);

        setTitle("JPaint");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width,(Toolkit.getDefaultToolkit().getScreenSize().height)-50);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public ClientContainerView getClientContainerView() {
        return clientContainerView;
    }
}
