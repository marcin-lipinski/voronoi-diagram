package VoronoiDiagram;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class LinePainter extends JComponent {
    private double[][] f;

    LinePainter(double[][] f) {
        this.f = f;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        for(int i = 0; i<f.length; i++){
            Line2D.Double line = new Line2D.Double(0, Math.abs(-300 * f[i][0] - 300 + f[i][1]), 600, Math.abs(300 * f[i][0] - 300 + f[i][1]));
            g2d.draw(line);
        }
    }
}
