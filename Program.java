import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Program extends JFrame{
    private PlotPanel plotPanelTop, plotPanelMid, plotPanelBot;
    private JButton runButton;
    private Source source = new Source();

    public Program() {
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setTitle("Assignment03");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        //the 3 graphs
        SimplePlot simp = new SimplePlot();
        MarkedPlot mark = new MarkedPlot(simp);
        BarPlot bar = new BarPlot(mark);

        // add 3 plot panels and a button
        plotPanelTop = new PlotPanel();
        plotPanelTop.setBackground(Color.white);
        plotPanelTop.setPlot(bar);
        plotPanelTop.setSize(500, 250);

        plotPanelMid = new PlotPanel();
        plotPanelMid.setBackground(Color.lightGray);
        plotPanelMid.setPlot(mark);
        plotPanelMid.setSize(500, 250);

        plotPanelBot = new PlotPanel();
        plotPanelBot.setBackground(Color.gray);
        plotPanelBot.setPlot(simp);
        plotPanelBot.setSize(500, 250);

        source.addObserver(plotPanelTop);
        source.addObserver(plotPanelMid);
        source.addObserver(plotPanelBot);

        this.add(plotPanelTop);
        this.add(plotPanelMid);
        this.add(plotPanelBot);

        JPanel buttonPanel = new JPanel(new BorderLayout());

        runButton = new JButton("Run");
        //runButton.setSize(500, 50);
        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                source.work();
            }
        });
        buttonPanel.add(runButton);
        this.add(buttonPanel);

        this.revalidate();
        this.repaint();

    }

    public static void main(String[] args) {
        new Program();
    }
}