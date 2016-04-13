package client.view.tools;

import client.view.DrawingContainerView;
import client.view.StatusAreaView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ToolbarView extends JToolBar{

    private List<Tool> toolList  = new ArrayList<>();
    private JButton plus;
    private JButton minus;

    private final Integer jtoolbarWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().width*0.2);
    private final Integer jtoolbarHeight = (Toolkit.getDefaultToolkit().getScreenSize().height)-155;

    private DrawingContainerView drawingContainerView;
    private StatusAreaView statusAreaView;

    public ToolbarView(DrawingContainerView drawingContainerView, StatusAreaView statusAreaView){
        super(null, JToolBar.VERTICAL);

        this.drawingContainerView = drawingContainerView;
        this.statusAreaView = statusAreaView;

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setSize(jtoolbarWidth,jtoolbarHeight);
        setPreferredSize((getSize()));
        setMaximumSize(getSize());
        setMinimumSize(getSize());
        setFloatable(true);
        setRollover(true);
        setBorderPainted(true);

        plus = new JButton("+");
        add(plus);
        setButtonSize(plus,25,25);

        minus = new JButton("-");
        add(minus);
        setButtonSize(minus,25,25);

        addSeparator();
        initButton();
    }

    public void addTool(Tool tool){
        toolList.add(tool);
        int nbTools = toolList.size();

        for (Tool currentTool : toolList){
            setButtonSize(currentTool, jtoolbarWidth-10,jtoolbarHeight / nbTools);
        }

        this.add(tool);
    }

    public void removeLastTool(){
        toolList.get(toolList.size()-1).setVisible(false);
        this.remove(toolList.get(toolList.size()-1));
        toolList.remove(toolList.size()-1);

        int nbTools = toolList.size();

        for (Tool currentTool : toolList){
            setButtonSize(currentTool, jtoolbarWidth-10,jtoolbarHeight / nbTools);
        }
    }

    private void initButton() {
        File toolsFolder = new File(ToolbarView.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/client/view/tools/");
        String ext, nameWithoutExt, nameWithPackage;
        Object o;
        File[] fileList = toolsFolder.listFiles();

        if (fileList == null)
            return;

        for (File file : fileList) {
            o = null;
            ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            nameWithoutExt = file.getName().replaceAll("." + ext, "");
            nameWithPackage = ToolbarView.class.getPackage().getName() + "." + nameWithoutExt;

            if ("Tool".equals(nameWithoutExt) || "ToolbarView".equals(nameWithoutExt))
                continue;

            if (file.isFile() && "class".equals(ext)) {
                try {
                    Class<?> tool = Class.forName(nameWithPackage);
                    Constructor<?> constructor = tool.getConstructor(drawingContainerView.getClass(), statusAreaView.getClass());
                    o = constructor.newInstance(drawingContainerView, statusAreaView);
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }

                if (o != null) {
                    addTool((Tool) o);
                }
            }
        }
    }

    private void setButtonSize(JButton button, int width, int height){
        button.setPreferredSize(new Dimension(width,height));
        button.setMaximumSize(button.getPreferredSize());
        button.setMinimumSize(button.getPreferredSize());
    }

    public JButton getPlus() {
        return plus;
    }

    public JButton getMinus() {
        return minus;
    }
}
