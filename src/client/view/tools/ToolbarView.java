package client.view.tools;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ToolbarView extends JToolBar{

    private List<Tool> toolList  = new ArrayList<>();
    private JButton plus;
    private JButton minus;

    private final Integer jtoolbarWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().width*0.2);
    private final Integer jtoolbarHeight = (Toolkit.getDefaultToolkit().getScreenSize().height)-155;

    public ToolbarView(){
        super(null, JToolBar.VERTICAL);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setSize(jtoolbarWidth,jtoolbarHeight);
        setPreferredSize((getSize()));
        setMaximumSize(getSize());
        setMinimumSize(getSize());
        this.setFloatable(true);
        this.setRollover(true);
        this.setBorderPainted(true);
        plus = new JButton("+");
        minus = new JButton("-");
        this.add(plus);
        setButtonSize(plus,25,25);
        this.add(minus);
        setButtonSize(minus,25,25);
        this.addSeparator();
    }

    public void addTool(Tool tool){
        toolList.add(tool);
        int nbTools = toolList.size();
        for(Tool currentTool : toolList){
            setButtonSize(currentTool, jtoolbarWidth-10,jtoolbarHeight / nbTools);
        }
        this.add(tool);
    }

    /*private void initButton(){
        selectForm = new JButton("Select");
        setButtonSize(selectForm,jtoolbarWidth -10,jtoolbarHeight/7);
        fillForm = new JButton("Fill");
        setButtonSize(fillForm,jtoolbarWidth -10,jtoolbarHeight/7);
        drawOval = new JButton("Oval");
        setButtonSize(drawOval,jtoolbarWidth -10,jtoolbarHeight/7);
        drawRectangle = new JButton("Rectangle");
        setButtonSize(drawRectangle,jtoolbarWidth -10,jtoolbarHeight/7);
        drawLine = new JButton("Line");
        setButtonSize(drawLine,jtoolbarWidth -10,jtoolbarHeight/7);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        foregroundColorChooser = new JButton();
        setButtonSize(foregroundColorChooser,(jtoolbarWidth/2)-10,jtoolbarHeight/7);
        foregroundColorChooser.setBackground(Color.BLACK);
        backgroundColorChooser = new JButton();
        setButtonSize(backgroundColorChooser,(jtoolbarWidth/2)-10,jtoolbarHeight/7);
        backgroundColorChooser.setBackground(Color.BLACK);
        buttonPanel.add(backgroundColorChooser);
        buttonPanel.add(foregroundColorChooser);
    }*/

    private void setButtonSize(JButton button, int width, int height){
        button.setPreferredSize(new Dimension(width,height));
        button.setMaximumSize(button.getPreferredSize());
        button.setMinimumSize(button.getPreferredSize());
    }

    /*public JButton getSelectForm() { return selectForm; }

    public JButton getFillForm() { return fillForm; }

    public JButton getDrawOval() { return drawOval; }

    public JButton getDrawRectangle() { return drawRectangle; }

    public JButton getDrawLine() { return drawLine; }

    public JButton getForegroundColorChooser() { return foregroundColorChooser; }

    public JButton getBackgroundColorChooser() { return backgroundColorChooser; }*/

    public JButton getPlus() {
        return plus;
    }

    public JButton getMinus() {
        return minus;
    }
}
