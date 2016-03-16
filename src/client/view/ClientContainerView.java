package client.view;

import client.model.Drawing;

import javax.swing.*;
import java.awt.*;

public class ClientContainerView extends JPanel {
    private Drawing drawing;

    private DrawingContainerView drawingContainerView;
    private StatusAreaView statusAreaView = new StatusAreaView();
    private ToolbarView toolbarView = new ToolbarView();

    public ClientContainerView(Drawing drawing) {
        setLayout(new BorderLayout());

        drawingContainerView = new DrawingContainerView(drawing);

        add(drawingContainerView, BorderLayout.CENTER);
        add(toolbarView, BorderLayout.WEST);
        add(statusAreaView, BorderLayout.SOUTH);
    }

    public DrawingContainerView getDrawingContainerView() {
        return drawingContainerView;
    }

    public StatusAreaView getStatusAreaView() {
        return statusAreaView;
    }

    public ToolbarView getToolbarView() {
        return toolbarView;
    }
}
