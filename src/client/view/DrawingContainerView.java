package client.view;

import client.model.Drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class DrawingContainerView extends JPanel{
    private String currentStatus = "none";
    private List<DrawingComponentView> drawingComponentViewList = new ArrayList<>();
    private Drawing drawing;
    private Color currentColor = Color.BLACK;

    public DrawingContainerView(Drawing drawing) {
        this.drawing = drawing;

        setBackground(Color.white);
        setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().width*0.75), Toolkit.getDefaultToolkit().getScreenSize().height-155);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void update() {
        removeAll();

        for (DrawingComponentView drawingComponentView : drawingComponentViewList) {
            drawingComponentView.update();
            add(drawingComponentView);
        }

        repaint();
    }

    public List<DrawingComponentView> getDrawingComponentViewList() { return drawingComponentViewList; }

    public Drawing getDrawing() { return drawing; }

    public String getCurrentStatus() { return currentStatus; }

    public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }

    public Color getCurrentColor() { return currentColor; }

    public void setCurrentColor(Color currentColor) { this.currentColor = currentColor; }
}
