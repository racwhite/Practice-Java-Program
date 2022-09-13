import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class SimplePlot extends Drawable{

    @Override
    public void draw(Graphics g) {
        if (data.size() < 2) {
            return;
        }
        ArrayList<Integer> ys = PlotPanel.getYValues(data, g);
        Iterator<Integer> iter = ys.iterator();
        int lastX = 0;
        int xIncr = g.getClipBounds().width / 20;
        int lastY = iter.next();
        g.setColor(Color.blue);

        while (iter.hasNext()) {
            int nextY = iter.next();
            g.drawLine(lastX, lastY, lastX + xIncr, nextY);
            lastX += xIncr;
            lastY = nextY;
        }
    }

    @Override
    public void setData(ArrayList<Integer> newData) {
        data = newData;
    }
}
