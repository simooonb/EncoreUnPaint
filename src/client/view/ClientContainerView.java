package client.view;

import client.model.Drawing;

import javax.swing.*;
import java.awt.*;

public class ClientContainerView extends JPanel {
    private Drawing drawing;

    private DrawingContainerView drawingContainerView;
    private StatusAreaView statusAreaView;
    private ToolbarView toolbarView ;

    public ClientContainerView(Drawing drawing) {
        setLayout(new BorderLayout());

        statusAreaView = new StatusAreaView();
        drawingContainerView = new DrawingContainerView(drawing);
        toolbarView = new ToolbarView();

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
