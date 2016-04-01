package client.controller;

import client.model.action.DeleteComponentAction;
import client.view.ClientContainerView;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;
import client.view.tools.ToolbarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ClientContainerController {
    private ClientContainerView clientContainerView;
    private boolean isFullscreen = false;

    public ClientContainerController(ClientContainerView clientContainerView) {
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
