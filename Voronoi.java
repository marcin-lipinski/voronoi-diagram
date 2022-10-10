package VoronoiDiagram;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Voronoi extends JFrame {

    static BufferedImage I;
    Voronoi(){
        super("Voronoi Diagram");
        setBounds(0, 0, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        JComponent j = new JComponent(){

            public void paint(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                Line2D.Double l = new Line2D.Double(0, Math.abs(-148.5 - 300), 600, Math.abs(151.5 - 300));
                g2d.setColor(Color.BLACK);
                g2d.draw(l);
                l = new Line2D.Double(0, Math.abs(-153.75 - 300), 600, Math.abs(146.25 - 300));
                g2d.draw(l);
            }
        };
        this.add(j);
        try {
            ImageIO.write(I, "png",new File("v.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
 //   Voroni(double[][] points){
//        if(points.length == 0) return;
//        if (points.length == 1) VoroniSingle();
//        if(points.length == 2) VoronoiDouble();
 //       if(arePointsCollinear(points)) new Points(points);
//        VoroniTri();
 //   }



    public boolean arePointsCollinear(double[][] points){
        double y1 = points[0][1];
        double x1 = points[0][0];
        double x2 = points[1][0];
        double y2 = points[1][1];

        double valueNextY = x2 - x1;
        double valueNextX = y2 - y1;

        double y = valueNextY;
        double x = -1 * valueNextX;
        double free = (-1 * y1 * valueNextY) - (valueNextX * -1 * x1);

        for(int i = 2; i<points.length; i++){
            double ix = x * points[i][0];
            double iy = y * points[i][1];
            if(iy + ix + free != 0) return false;
        }
        System.out.println("WS");
        return true;
    }
}
