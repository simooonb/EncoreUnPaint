package client.view.tools;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ToolbarView extends JToolBar{

    private List<Tool> toolList  = new ArrayList<>();
    private JButton plus;
    private JButton madness;

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
        madness = new JButton("-");
        this.add(plus);
        this.add(madness);
        this.addSeparator();
        /*initButton();
        this.add(selectForm);
        this.addSeparator();
        this.add(fillForm);
        this.addSeparator();
        this.add(drawOval);
        this.addSeparator();
        this.add(drawRectangle);
        this.addSeparator();
        this.add(drawLine);
        this.addSeparator();
        this.add(buttonPanel);*/
    }

    public void addTool(){

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
    }

    private void setButtonSize(JButton button, int width, int height){
        button.setPreferredSize(new Dimension(width,height));
        button.setMaximumSize(button.getPreferredSize());
        button.setMinimumSize(button.getPreferredSize());
    }
    public JButton getSelectForm() { return selectForm; }

    public JButton getFillForm() { return fillForm; }

    public JButton getDrawOval() { return drawOval; }

    public JButton getDrawRectangle() { return drawRectangle; }

    public JButton getDrawLine() { return drawLine; }

    public JButton getForegroundColorChooser() { return foregroundColorChooser; }

    public JButton getBackgroundColorChooser() { return backgroundColorChooser; }*/
}