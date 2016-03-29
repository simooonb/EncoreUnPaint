package client.controller;

import client.model.DrawingComponent;
import client.view.ClientContainerView;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;
import client.view.ToolbarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public class ClientContainerController {
    private ClientContainerView clientContainerView;

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
                List<DrawingComponent> components = clientContainerView.getDrawingContainerView().getDrawing().getDrawingComponents();
                for (DrawingComponent component : components) {
                    if (component.isSelected())
                        component.remove();
                }
            }
        });
    }
}
