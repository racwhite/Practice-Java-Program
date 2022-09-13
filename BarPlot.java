import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BarPlot extends DecoratedPlot{

    public BarPlot() {
        _plot = null;
    }

    public BarPlot(Drawable plot) {
        _plot = plot;
    }

    @Override
    public void draw(Graphics g) {

        if (data.size() < 1) {
            return;
        }
        ArrayList<Integer> ys = PlotPanel.getYValues(data, g);
        Iterator<Integer> iter = ys.iterator();
        int lastX = 0;
        int xIncr = g.getClipBounds().width / 20;
        int height = g.getClipBounds().height;
        g.setColor(Color.lightGray);

        while (iter.hasNext()) {
            int y = iter.next();
            g.fillRect(lastX - 5, y, 10, height - y);
            lastX += xIncr;
        }
        if (_plot != null) {
            _plot.draw(g);
        }
    }

    @Override
    public void setData(ArrayList<Integer> newData) {
        data = newData;
    }
}
