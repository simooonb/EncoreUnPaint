package client.view;

import client.model.Drawing;

import javax.swing.*;
import java.awt.*;

public class ClientContainerView extends JPanel {
    private DrawingContainerView drawingContainerView = new DrawingContainerView();
    private StatusAreaView statusAreaView = new StatusAreaView();
    private ToolbarView toolbarView = new ToolbarView();

    private Drawing drawing;

    public ClientContainerView(Drawing drawing) {
        this.drawing = drawing;

        add(drawingContainerView, BorderLayout.CENTER);
        add(toolbarView, BorderLayout.WEST);
        add(statusAreaView, BorderLayout.SOUTH);
    }
}
