package client.view;

import client.model.LineComponent;

import java.awt.*;
import java.awt.geom.Line2D;

public class LineComponentView extends DrawingComponentView {
    private LineComponent line;

    public LineComponentView(LineComponent line) {
        super(line);
        this.line = line;
        setOpaque(false);
        update();
    }

    @Override
    public void update() {
        System.out.println("lineview update");
        super.update();
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(g instanceof Graphics2D){
            Graphics2D g2d = (Graphics2D) g;
            System.out.println("lineview paintcomponent");
            System.out.println("color : "+line.getColor());
            System.out.println("point 1 :"+line.getFirstPoint()+ " point 2 :"+line.getSecondPoint());
            g2d.setPaint(line.getColor());
            g2d.setStroke(new BasicStroke(1));
            g2d.draw(new Line2D.Float(line.getFirstPoint().x, line.getFirstPoint().y, line.getSecondPoint().x, line.getSecondPoint().y));
        }
    }

    public LineComponent getLine() {
        return line;
    }

    public void setLine(LineComponent line) {
        this.line = line;
    }
}
