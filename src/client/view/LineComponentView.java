package client.view;

import client.model.LineComponent;

public class LineComponentView extends DrawingComponentView {
    private LineComponent line;

    public LineComponentView() {

    }

    public LineComponent getLine() {
        return line;
    }

    public void setLine(LineComponent line) {
        this.line = line;
    }
}
