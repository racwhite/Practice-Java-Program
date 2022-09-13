import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MarkedPlot extends DecoratedPlot {
    public MarkedPlot() {
        _plot = null;
    }

    public MarkedPlot(Drawable plot) {
        _plot = plot;
    }

    @Override
    public void draw(Graphics g) {
        if (_plot != null) {
            _plot.draw(g);
        }
        if (data.size() < 1) {
            return;
        }
        ArrayList<Integer> ys = PlotPanel.getYValues(data, g);
        Iterator<Integer> iter = ys.iterator();
        int lastX = 0;
        int xIncr = g.getClipBounds().width / 20;
        g.setColor(Color.blue);

        while (iter.hasNext()) {
            g.fillRect(lastX - 5, iter.next() - 5, 10, 10);
            lastX += xIncr;
        }
    }

    @Override
    public void setData(ArrayList<Integer> newData) {
        data = newData;
    }
}
