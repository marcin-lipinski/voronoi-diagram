package VoronoiDiagram;

import java.util.ArrayList;

public class VoronoiInterpreter{
    VoronoiInterpreter(ArrayList<double[]> points){
        if(points.size() == 0) return;
        //if(points.size() == 1) new VoroniSingle();
        if(points.size() == 2) new VoronoiCollinear(points);
        if(arePointsCollinear(points)) new VoronoiCollinear(points);
        new VoronoiComplex();
        }

    public boolean arePointsCollinear(ArrayList<double[]> points){
        double y1 = points.get(0)[1];
        double x1 = points.get(0)[0];
        double x2 = points.get(1)[0];
        double y2 = points.get(1)[1];

        double valueNextY = x2 - x1;
        double valueNextX = y2 - y1;

        double y = valueNextY;
        double x = -1 * valueNextX;
        double free = (-1 * y1 * valueNextY) - (valueNextX * -1 * x1);

        for(int i = 2; i<points.size(); i++){
            double ix = x * points.get(i)[0];
            double iy = y * points.get(i)[1];
            if(iy + ix + free != 0) return false;
        }
        return true;
    }
}
