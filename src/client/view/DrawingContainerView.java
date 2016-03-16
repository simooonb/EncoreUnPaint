package client.view;

import javax.swing.*;
import java.awt.*;

public class DrawingContainerView extends JPanel {
    private String currentStatus = "None";
    private Color currentColor = Color.BLACK;

    public DrawingContainerView() {
        setBackground(Color.white);
        setSize(500, 500);
    }

    public String getCurrentStatus() { return currentStatus; }

    public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }

    public Color getCurrentColor() { return currentColor; }

    public void setCurrentColor(Color currentColor) { this.currentColor = currentColor; }
}
