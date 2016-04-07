package client.view;

import client.model.drawing.Drawing;
import client.view.drawingComponents.DrawingComponentView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingContainerView extends JPanel{
    private List<DrawingComponentView> drawingComponentViewList = new ArrayList<>();
    private Drawing drawing;

    public DrawingContainerView(Drawing drawing) {
        this.drawing = drawing;

        setLayout(null);

        setBackground(Color.white);
        setSize(500,500);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void update() {
        removeAll();

        for (DrawingComponentView drawingComponentView : drawingComponentViewList) {
            add(drawingComponentView);
            drawingComponentView.update();
        }

        revalidate();
        repaint();
    }


    public void addView(DrawingComponentView drawingComponentView){
        drawingComponentViewList.add(drawingComponentView);
    }

    public List<DrawingComponentView> getDrawingComponentViewList() { return drawingComponentViewList; }

    public Drawing getDrawing() { return drawing; }

    public String getCurrentStatus() { return drawing.getCurrentStatus(); }

    public void setCurrentStatus(String currentStatus) { drawing.setCurrentStatus(currentStatus); }


    public Color getCurrentColorForeground() {
        return drawing.getForegroundColor();
    }

    public void setCurrentColorForeground(Color currentColorForeground) {
        drawing.setForegroundColor(currentColorForeground);
    }

    public Color getCurrentColorBackground() {
        return drawing.getBackgroundColor();
    }

    public void setCurrentColorBackground(Color currentColorBackground) {
        drawing.setBackgroundColor(currentColorBackground);
    }
}
