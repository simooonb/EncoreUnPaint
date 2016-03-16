package client.view;

import client.model.Drawing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingContainerView extends JPanel {
    private String currentStatus = "none";
    private List<DrawingComponentView> drawingComponentViewList = new ArrayList<>();
    private Drawing drawing;

    public DrawingContainerView(Drawing drawing) {
        this.drawing = drawing;

        setBackground(Color.white);
        setSize(500, 500);
    }

    public void update() {
        removeAll();

        for (DrawingComponentView drawingComponentView : drawingComponentViewList) {
            drawingComponentView.update();
            add(drawingComponentView);
        }

        repaint();
    }

    public String getCurrentStatus() { return currentStatus; }

    public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }
}
