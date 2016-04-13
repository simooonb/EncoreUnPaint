package client.controller;

import client.model.drawing.DrawingListener;
import client.model.drawingComponents.DrawingComponent;
import client.model.drawingComponents.DrawingComponentListener;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;
import client.view.tools.Tool;
import client.view.tools.ToolbarView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class ToolbarController implements DrawingComponentListener,DrawingListener{
    private ToolbarView toolbarView;
    private StatusAreaView statusAreaView;
    private DrawingContainerView drawingContainerView;

    ToolbarController(ToolbarView toolbarView, StatusAreaView statusAreaView, DrawingContainerView drawingContainerView) {
        this.toolbarView = toolbarView;
        this.statusAreaView = statusAreaView;
        this.drawingContainerView = drawingContainerView;
        drawingContainerView.getDrawing().addDrawingListener(this);

        toolbarView.getPlus().addActionListener(actionEvent -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Classes", "class");
            chooser.setFileFilter(filter);
            Class<?> tool = null;
            Field status = null;

            if (chooser.showOpenDialog(toolbarView) == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = chooser.getSelectedFile();
                    String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                    String nameWithoutExt = file.getName().replaceAll("." + ext, "");
                    String nameWithPackage = ToolbarView.class.getPackage().getName() + "." + nameWithoutExt;
                    tool = Class.forName(nameWithPackage);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            if (tool == null)
                return;

            try {
                status = tool.getDeclaredField("status");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            if (status == null || !"java.lang.String".equals(status.getType().getName()))
                return;

            try {
                Constructor<?> constructor = tool.getConstructor(drawingContainerView.getClass(), statusAreaView.getClass());
                Object o = constructor.newInstance(drawingContainerView, statusAreaView);
                toolbarView.addTool((Tool) o);
            }
            catch (IllegalArgumentException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ilae) {
                ilae.printStackTrace();
            }
        });

        toolbarView.getMinus().addActionListener(e -> toolbarView.removeLastTool());
    }

    @Override
    public void onDrawingComponentAdded(DrawingComponent drawingComponent){
        drawingComponent.addDrawingComponentListener(this);
    }

    @Override
    public void onDrawingComponentRemoved(DrawingComponent drawingComponent){
        drawingComponent.removeDrawingComponentListener(this);
    }

    @Override
    public void onMoved(){

    }

    @Override
    public void onRemoved(){

    }

    @Override
    public void onColorChanged(){

    }

    @Override
    public void onSelected(){

    }

    @Override
    public void onUnselected(){

    }

}
