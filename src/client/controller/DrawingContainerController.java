package client.controller;

import client.view.DrawingContainerView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingContainerController {
    private DrawingContainerView drawingContainerView;

    public DrawingContainerController(DrawingContainerView drawingContainerView) {
        this.drawingContainerView = drawingContainerView;

        drawingContainerView.addMouseListener(new DrawingContainerListener());

        updateView();
    }

    private void updateView() {
        drawingContainerView.update();
    }

    class DrawingContainerListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (drawingContainerView.getCurrentStatus()) {
                case "selection": {
                    updateView();
                    break;
                }

                case "fill": {
                    updateView();
                    break;
                }

                case "line": {
                    updateView();
                    break;
                }

                case "rectangle": {
                    updateView();
                    break;
                }

                case "oval": {
                    updateView();
                    break;
                }
            }
        }
    }
}
