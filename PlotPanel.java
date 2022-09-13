import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PlotPanel extends JPanel implements Observer {
    private Drawable _plot;
    public Evaluator evaluator = Evaluator.getEvaluator();

    public void setPlot(Drawable plot) {
        _plot = plot;
    }

    public static ArrayList<Integer> getYValues(ArrayList<Integer> data, Graphics g) {
        Rectangle bounds = g.getClipBounds();
        int h = bounds.height;
        ArrayList<Integer> newY = new ArrayList<Integer>();

        for (Integer datum : data) {
            double temp = (datum - 1) / 200.0;
            int newHeight = h - (int) (h * temp);
            newY.add(newHeight);
        }

        return newY;
    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 250);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        _plot.draw(g);
        double average = evaluator.computeAverage(_plot.data);
        if (!Double.isNaN(average)) {
            g.setColor(Color.red);
            Rectangle bounds = g.getClipBounds();
            int h = bounds.height;
            int newHeight = h - (int) (h * ((average - 1.0) / 200.0));
            g.fillRect(0, newHeight - 1, bounds.width, 2);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void update(Observable o, Object arg) {
        _plot.setData(((Source)o).getValues());
        repaint();
    }
}