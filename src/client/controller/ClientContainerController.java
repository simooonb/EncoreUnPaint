package client.controller;

import client.model.action.CreateLineAction;
import client.model.action.CreateOvalAction;
import client.model.action.CreateRectangleAction;
import client.model.action.DeleteComponentAction;
import client.model.drawingComponents.DrawingComponent;
import client.model.drawingComponents.LineComponent;
import client.model.drawingComponents.OvalComponent;
import client.model.drawingComponents.RectangleComponent;
import client.view.ClientContainerView;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;
import client.view.tools.ToolbarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

class ClientContainerController {
    private ClientContainerView clientContainerView;
    private boolean isFullscreen = false;
    private DrawingComponent drawingComponentCopy = null;

    ClientContainerController(ClientContainerView clientContainerView) {
        this.clientContainerView = clientContainerView;

        addShortcuts();

        ToolbarView toolbarView = clientContainerView.getToolbarView();
        DrawingContainerView drawingContainerView = clientContainerView.getDrawingContainerView();
        StatusAreaView statusAreaView = clientContainerView.getStatusAreaView();

        new ToolbarController(toolbarView,statusAreaView,drawingContainerView);
        new DrawingContainerController(drawingContainerView);
    }

    private void addShortcuts() {
        InputMap inputMap = clientContainerView.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = clientContainerView.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("control Z"), "undo");
        actionMap.put("undo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clientContainerView.getDrawingContainerView().getDrawing().getActionStack().pop();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("control Y"), "redo");
        actionMap.put("redo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clientContainerView.getDrawingContainerView().getDrawing().getActionStack().redo();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("control C"), "copy");
        actionMap.put("copy", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrawingComponent drawingComponentSelected = clientContainerView.getDrawingContainerView().getDrawing().getCurrentComponentSelected();

                if (drawingComponentSelected == null)
                    return;

                drawingComponentCopy = drawingComponentSelected;
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("control V"), "paste");
        actionMap.put("paste", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drawingComponentCopy == null)
                    return;

                clientContainerView.getDrawingContainerView().getDrawing().getCurrentComponentSelected().fireUnselected();
                clientContainerView.getDrawingContainerView().getDrawing().setCurrentComponentSelected(null);

                if (drawingComponentCopy instanceof LineComponent){
                    LineComponent lineComponent = (LineComponent) drawingComponentCopy;
                    CreateLineAction createLineAction = new CreateLineAction(
                            clientContainerView.getDrawingContainerView().getDrawing(),
                            clientContainerView.getDrawingContainerView().getMousePosition(),
                            new Point(clientContainerView.getDrawingContainerView().getMousePosition().x + (lineComponent.getSecondPoint().x - lineComponent.getFirstPoint().x),clientContainerView.getDrawingContainerView().getMousePosition().y + (lineComponent.getSecondPoint().y - lineComponent.getFirstPoint().y)),
                            lineComponent.isInvertWidth(),
                            lineComponent.isInvertHeight(),
                            clientContainerView.getDrawingContainerView().getCurrentColorBackground()
                    );
                    clientContainerView.getDrawingContainerView().getDrawing().getActionStack().push(createLineAction);

                } else if(drawingComponentCopy instanceof RectangleComponent){
                    RectangleComponent rectangleComponent = (RectangleComponent) drawingComponentCopy;
                    CreateRectangleAction createRectangleAction = new CreateRectangleAction(
                            clientContainerView.getDrawingContainerView().getDrawing(),
                            clientContainerView.getDrawingContainerView().getMousePosition(),
                            new Dimension(Math.abs((int)rectangleComponent.getBoundingBox().getWidth()), Math.abs((int)rectangleComponent.getBoundingBox().getHeight())),
                            clientContainerView.getDrawingContainerView().getCurrentColorBackground(),
                            clientContainerView.getDrawingContainerView().getCurrentColorForeground()
                    );
                    clientContainerView.getDrawingContainerView().getDrawing().getActionStack().push(createRectangleAction);

                } else if(drawingComponentCopy instanceof OvalComponent){
                    OvalComponent ovalComponent = (OvalComponent) drawingComponentCopy;
                    CreateOvalAction createOvalAction = new CreateOvalAction(
                            clientContainerView.getDrawingContainerView().getDrawing(),
                            clientContainerView.getDrawingContainerView().getMousePosition(),
                            new Dimension(Math.abs((int)ovalComponent.getBoundingBox().getWidth()), Math.abs((int)ovalComponent.getBoundingBox().getHeight())),
                            clientContainerView.getDrawingContainerView().getCurrentColorBackground(),
                            clientContainerView.getDrawingContainerView().getCurrentColorForeground()
                    );
                    clientContainerView.getDrawingContainerView().getDrawing().getActionStack().push(createOvalAction);
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");
        actionMap.put("delete", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DeleteComponentAction deleteComponentAction = new DeleteComponentAction(clientContainerView.getDrawingContainerView().getDrawing());
                clientContainerView.getDrawingContainerView().getDrawing().getActionStack().push(deleteComponentAction);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "fullscreen");
        actionMap.put("fullscreen", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                isFullscreen = !isFullscreen;
                if (isFullscreen) {
                    clientContainerView.getClientFrameView().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    clientContainerView.getClientFrameView().dispose();
                    clientContainerView.getClientFrameView().setUndecorated(true);
                    clientContainerView.getClientFrameView().setVisible(true);
                } else {
                    clientContainerView.getClientFrameView().setExtendedState(JFrame.NORMAL);
                    clientContainerView.getClientFrameView().dispose();
                    clientContainerView.getClientFrameView().setUndecorated(false);
                    clientContainerView.getClientFrameView().setSize(Toolkit.getDefaultToolkit().getScreenSize().width,(Toolkit.getDefaultToolkit().getScreenSize().height)-50);
                    clientContainerView.getClientFrameView().setVisible(true);
                }
            }
        });
    }
}
