package client.view;

import client.model.drawing.Drawing;
import client.view.drawingComponents.DrawingComponentView;
import client.view.drawingComponents.LineComponentView;
import client.view.drawingComponents.OvalComponentView;
import client.view.drawingComponents.RectangleComponentView;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class DrawingContainerView extends JPanel{
    private List<DrawingComponentView> drawingComponentViewList = new ArrayList<>();
    private Drawing drawing;

    public DrawingContainerView(Drawing drawing) {
        this.drawing = drawing;

        setLayout(null);

        setBackground(Color.white);
        setSize(500,500);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void update() {
        removeAll();

        for (DrawingComponentView drawingComponentView : drawingComponentViewList) {
            add(drawingComponentView);
            drawingComponentView.update();
        }

        revalidate();
        repaint();
    }

    public DrawingComponentView clickingPointInContainerView(Point clickingPoint){
        for(DrawingComponentView drawingComponentView : drawingComponentViewList){
            if(drawingComponentView instanceof RectangleComponentView){
                RectangleComponentView rectangleView = (RectangleComponentView) drawingComponentView;
                if(rectangleView.getBounds().contains(clickingPoint)){
                    return drawingComponentView;
                }
            }
            else if(drawingComponentView instanceof OvalComponentView){
                OvalComponentView ovalView = (OvalComponentView) drawingComponentView;
                if (ovalView.getBounds().contains(clickingPoint)) {
                    return drawingComponentView;
                }
            }
            else{
                LineComponentView lineView = (LineComponentView) drawingComponentView;
                double dist = Line2D.ptSegDist(lineView.getLine().getFirstPoint().x,lineView.getLine().getFirstPoint().y,lineView.getLine().getSecondPoint().x,lineView.getLine().getSecondPoint().y,clickingPoint.x,clickingPoint.y);
                if(dist <= 2){
                    return drawingComponentView;
                }
            }
        }
        return null;
    }

    public void addView(DrawingComponentView drawingComponentView){
        drawingComponentViewList.add(drawingComponentView);
    }

    public List<DrawingComponentView> getDrawingComponentViewList() { return drawingComponentViewList; }

    public Drawing getDrawing() { return drawing; }

    public String getCurrentStatus() { return drawing.getCurrentStatus(); }

    public void setCurrentStatus(String currentStatus) { drawing.setCurrentStatus(currentStatus); }


    public Color getCurrentColorForeground() {
        return drawing.getForegroundColor();
    }

    public void setCurrentColorForeground(Color currentColorForeground) {
        drawing.setForegroundColor(currentColorForeground);
    }

    public Color getCurrentColorBackground() {
        return drawing.getBackgroundColor();
    }

    public void setCurrentColorBackground(Color currentColorBackground) {
        drawing.setBackgroundColor(currentColorBackground);
    }
}
