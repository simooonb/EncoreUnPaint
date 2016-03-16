package client.view;

import javax.swing.*;
import java.awt.*;
import client.controller.ToolbarController;

public class ClientContainerView extends JPanel {
    private DrawingContainerView drawingContainerView = new DrawingContainerView();
    private StatusAreaView statusAreaView = new StatusAreaView();
    private ToolbarView toolbarView = new ToolbarView();

    public ClientContainerView() {
        setLayout(new BorderLayout());

        new ToolbarController(toolbarView);

        add(drawingContainerView, BorderLayout.CENTER);
        add(toolbarView, BorderLayout.WEST);
        add(statusAreaView, BorderLayout.SOUTH);
    }
}
