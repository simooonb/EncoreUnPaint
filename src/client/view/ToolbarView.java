package client.view;

import javax.swing.*;

public class ToolbarView extends JToolBar{
    private JButton selectForm;
    private JButton fillForm;
    private JButton drawOval;
    private JButton drawRectangle;
    private JButton drawLine;
    private JButton colorChooser;

    public ToolbarView(){
        super(null, JToolBar.VERTICAL);
        this.setFloatable(true);
        this.setRollover(true);
        this.setBorderPainted(true);
        initButton();
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
        this.add(colorChooser);
    }

    private void initButton(){
        selectForm = new JButton("Select");
        fillForm = new JButton("Fill");
        drawOval = new JButton("Oval");
        drawRectangle = new JButton("Rectangle");
        drawLine = new JButton("Line");
        colorChooser = new JButton("Color");
    }

    public JButton getSelectForm() { return selectForm; }

    public JButton getFillForm() { return fillForm; }

    public JButton getDrawOval() { return drawOval; }

    public JButton getDrawRectangle() { return drawRectangle; }

    public JButton getDrawLine() { return drawLine; }

    public JButton getColorChooser() { return colorChooser; }
}
