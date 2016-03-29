package client.view;

import client.model.LineComponent;

import java.awt.*;
import java.awt.geom.Line2D;

public class LineComponentView extends DrawingComponentView {
    private LineComponent line;

    public LineComponentView(LineComponent line) {
        super(line);
        this.line = line;
        setOpaque(true);
        update();
    }

    @Override
    public void update() {
        super.update();
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(g instanceof Graphics2D){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(line.getBackgroundColor());
            if(line.isSelected()){
                g2d.setStroke(new BasicStroke(3));
            }
            else
            {
                g2d.setStroke(new BasicStroke(1));
            }
            g2d.draw(new Line2D.Float(0,0,line.getSecondPoint().x-line.getFirstPoint().x,line.getSecondPoint().y-line.getFirstPoint().y));
        }
        g.dispose();
    }

    public LineComponent getLine() {
        return line;
    }

    public void setLine(LineComponent line) {
        this.line = line;
    }
}
