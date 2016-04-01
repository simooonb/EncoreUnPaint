package client.view;

import client.model.drawing.Drawing;
import client.view.tools.ToolbarView;

import javax.swing.*;
import java.awt.*;

public class ClientContainerView extends JPanel {
    private Drawing drawing;

    private ClientFrameView clientFrameView;
    private DrawingContainerView drawingContainerView;
    private StatusAreaView statusAreaView;
    private ToolbarView toolbarView ;

    public ClientContainerView(ClientFrameView frame, Drawing drawing) {
        setLayout(new BorderLayout());

        clientFrameView = frame;
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

    public ClientFrameView getClientFrameView() {
        return clientFrameView;
    }
}
