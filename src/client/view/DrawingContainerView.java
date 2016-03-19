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
    private Color currentColorForeground = Color.BLACK;
    private Color currentColorBackground = Color.BLACK;

    public DrawingContainerView(Drawing drawing) {
        this.drawing = drawing;

        setBackground(Color.white);
        setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().width*0.75), Toolkit.getDefaultToolkit().getScreenSize().height-155);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void update() {
        System.out.println("update drawingcontainerview");
        removeAll();

        for (DrawingComponentView drawingComponentView : drawingComponentViewList) {
            drawingComponentView.update();
            add(drawingComponentView);
        }

        revalidate();
        repaint();
    }

    public List<DrawingComponentView> getDrawingComponentViewList() { return drawingComponentViewList; }

    public Drawing getDrawing() { return drawing; }

    public String getCurrentStatus() { return currentStatus; }

    public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }


    public Color getCurrentColorForeground() {
        return currentColorForeground;
    }

    public void setCurrentColorForeground(Color currentColorForeground) {
        this.currentColorForeground = currentColorForeground;
    }

    public Color getCurrentColorBackground() {
        return currentColorBackground;
    }

    public void setCurrentColorBackground(Color currentColorBackground) {
        this.currentColorBackground = currentColorBackground;
    }
}
