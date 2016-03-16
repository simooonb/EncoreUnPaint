package client.controller;

import client.view.DrawingContainerView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingContainerController {
    private DrawingContainerView drawingContainerView;

    public DrawingContainerController(DrawingContainerView drawingContainerView) {
        this.drawingContainerView = drawingContainerView;

        drawingContainerView.addMouseListener(new DrawingContainerListener());
    }

    class DrawingContainerListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("clicked");
        }
    }
}
