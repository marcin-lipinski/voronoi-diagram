package VoronoiDiagram;

import java.util.ArrayList;
import java.util.Collections;

public class VoronoiCollinear{
    private ArrayList<double[]> points;
    private double[][] linearFunctions;

    VoronoiCollinear(ArrayList<double[]> points){
        linearFunctions = new double[points.size() - 1][];
        this.points = points;
        sortPoints();
        calculateLinearFunctionEachTwoPoints();
        paint();
    }

    private void sortPoints(){
        Collections.sort(points, (o1, o2) -> {
            if(o1[0] == o2[0]){
                if(o1[1] - o2[1] > 0) return -1;
                if(o1[1] - o2[1] < 0) return 1;
            }
            if(o1[0] != o2[0]){
                if(o1[0] - o2[0] > 0) return -1;
                if(o1[0] - o2[0] < 0) return 1;
            }
            return 0;
        });
    }

    private void calculateLinearFunctionEachTwoPoints(){
        for(int i = 0; i<points.size() - 1; i++){
            linearFunctions[i] = calculateLinearFunctionTwoPoints(points.get(i), points.get(i+1), calculatePointBetweenTwoPoints(points.get(i), points.get(i+1)));
        }
    }

    private double[] calculatePointBetweenTwoPoints(double[] pointA, double[] pointB){
        double[] S = new double[2];
        S[0] = (pointA[0] + pointB[0]) / 2;
        S[1] = (pointA[1] + pointB[1]) / 2;
        return S;
    }

    private double[] calculateLinearFunctionTwoPoints(double[] pointA, double[] pointB, double[] S){
        double[] K = new double[2];
        double dz = pointA[1] - pointB[1];
        if(dz == 0) dz = 1;
        double c = (pointA[0] - pointB[0])/dz;
        K[0] = c;
        K[1] = S[1] - c * S[0];
        System.out.println(K[0] + " " + K[1]);
        return K;
    }

    public void paint(){
        Frame fr = new Frame();
        LinePainter line = new LinePainter(linearFunctions);
        fr.add(line);
    }
}
