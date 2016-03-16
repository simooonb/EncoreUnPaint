package client.view;

import javax.swing.*;
import java.awt.*;

public class ClientContainerView extends JPanel {
    private DrawingContainerView drawingContainerView = new DrawingContainerView();
    private StatusAreaView statusAreaView = new StatusAreaView();
    private ToolbarView toolbarView = new ToolbarView();

    public ClientContainerView() {
        setLayout(new BorderLayout());

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
