package client.controller.drawingComponents;

import client.model.drawingComponents.DrawingComponent;
import client.model.drawingComponents.DrawingComponentListener;
import client.model.action.MoveComponentAction;
import client.view.drawingComponents.DrawingComponentView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

abstract public class DrawingComponentController implements DrawingComponentListener {
    private DrawingComponentView drawingComponentView;

    public DrawingComponentController(DrawingComponentView drawingComponentView) {
        this.drawingComponentView = drawingComponentView;

        DrawingComponentMouseListener listener = new DrawingComponentMouseListener();
        drawingComponentView.addMouseListener(listener);
        drawingComponentView.addMouseMotionListener(listener);

        drawingComponentView.getDrawingComponent().addDrawingComponentListener(this);
    }

    public void updateView() {
        drawingComponentView.update();
    }

    @Override
    public void onMoved() {
        drawingComponentView.updateLocation();
    }

    private class DrawingComponentMouseListener extends MouseAdapter {
        private Point parentOnScreen, mouseOnScreen, position;
        private boolean dragging = false;

        @Override
        public void mouseDragged(MouseEvent e) {
            if (!dragging)
                return;

            if (!"selection".equals(drawingComponentView.getDrawingComponent().getDrawing().getCurrentStatus()))
                return;

            int anchorX = drawingComponentView.getAnchorPoint().x;
            int anchorY = drawingComponentView.getAnchorPoint().y;

            parentOnScreen = drawingComponentView.getParent().getLocationOnScreen();
            mouseOnScreen = e.getLocationOnScreen();
            position = new Point(mouseOnScreen.x - parentOnScreen.x - anchorX, mouseOnScreen.y - parentOnScreen.y - anchorY);

            drawingComponentView.setLocation(position);
            drawingComponentView.getParent().setComponentZOrder(drawingComponentView, 0);
            drawingComponentView.repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if (!"selection".equals(drawingComponentView.getDrawingComponent().getDrawing().getCurrentStatus()))
                return;

            drawingComponentView.setCursor(Cursor.getPredefinedCursor((Cursor.HAND_CURSOR)));
            drawingComponentView.setAnchorPoint(e.getPoint());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            dragging = true;
            if (!"selection".equals(drawingComponentView.getDrawingComponent().getDrawing().getCurrentStatus()))
                return;

            unselectAllOthers();
            drawingComponentView.getDrawingComponent().getDrawing().setCurrentComponentSelected(drawingComponentView.getDrawingComponent());
            drawingComponentView.getDrawingComponent().fireSelected();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            dragging = false;

            if (position == null)
                return;

            if (Objects.equals(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), drawingComponentView.getCursor())) {
                MoveComponentAction moveComponentAction = new MoveComponentAction(drawingComponentView, position);
                drawingComponentView.getDrawingComponent().getDrawing().getActionStack().push(moveComponentAction);
            }
        }

        private void unselectAllOthers(){
            for(DrawingComponent drawingComponent : drawingComponentView.getDrawingComponent().getDrawing().getDrawingComponents()){
                if(drawingComponent != drawingComponentView.getDrawingComponent()){
                    drawingComponent.fireUnselected();
                }
            }
        }
    }
}
