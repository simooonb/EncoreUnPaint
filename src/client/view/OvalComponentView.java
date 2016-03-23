package client.view;

import client.model.OvalComponent;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class OvalComponentView extends DrawingComponentView {
    private OvalComponent oval;

    public OvalComponentView(OvalComponent oval) {
        super(oval);
        this.oval = oval;
        setOpaque(false);
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
            g2d.setPaint(oval.getBackgroundColor());
            g2d.setStroke(new BasicStroke(1));
            Rectangle boundingBox = oval.getBoundingBox();
            g2d.fill(new Ellipse2D.Float(0,0, boundingBox.width, boundingBox.height));
            g2d.setPaint(oval.getForeGroundColor());
            g2d.draw(new Ellipse2D.Float(0,0,boundingBox.width-1,boundingBox.height-1));
        }
    }

    public OvalComponent getOval() {
        return oval;
    }

    public void setOval(OvalComponent oval) {
        this.oval = oval;
    }
}
