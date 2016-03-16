package client.view;

import javax.swing.*;

public class ToolbarView extends JToolBar{
    private JButton selectForm;
    private JButton fillForm;
    private JButton drawOval;
    private JButton drawRectangle;
    private JButton drawLine;

    public ToolbarView(){
        super(null, JToolBar.VERTICAL);
        initButton();
        this.add(selectForm);
        this.add(fillForm);
        this.add(drawOval);
        this.add(drawRectangle);
        this.add(drawLine);
    }

    private void initButton(){
        selectForm = new JButton("Select");
        fillForm = new JButton("Fill");
        drawOval = new JButton("Oval");
        drawRectangle = new JButton("Rectangle");
        drawLine = new JButton("Line");
    }
}
