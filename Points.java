package VoronoiDiagram;

import java.util.ArrayList;
import java.util.Collections;

public class Points {
    private ArrayList<double[]> points;
    private double[][] linearFunctions;

    Points(ArrayList<double[]> points){
        linearFunctions = new double[points.size() - 1][];
        this.points = points;
        sortPoints();
        calculateLinearFunctionEachTwoPoints();
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
        double c = (pointA[0] - pointB[0])/(pointA[1] - pointB[1]);
        K[0] = c;
        K[1] = S[1] - c * S[0];
        System.out.println(K[0] + " " + K[1]);
        return K;
    }



    ///metoda pustych okręgów
    private double[] virtualCenter(){
        double minX = points.get(0)[0];
        double maxX = points.get(0)[0];
        double minY = points.get(0)[1];
        double maxY = points.get(0)[0];
        for(double[] point : points){
            if(point[0] < minX) minX = point[0];
            if(point[0] > maxX) maxX = point[0];
            if(point[1] < minY) minY = point[1];
            if(point[1] > maxY) maxY = point[1];
        }
        double vx = (maxX + minX) / 2;
        double vt = (maxY + minY) / 2;
        return new double[]{};
    }

    private void srodekOkregu(double[] pointA, double[] pointB, double[] pointC){
        double W = calculateW(pointA[0], pointA[1], pointB[0], pointB[1], pointC[0], pointC[1]);
        double Wxs = calculateWxs(pointA[0], pointA[1], pointB[0], pointB[1], pointC[0], pointC[1]);
        double Wys = calculateWys(pointA[0], pointA[1], pointB[0], pointB[1], pointC[0], pointC[1]);
        double xs = Wxs/W;
        double ys = Wys/W;
        double r2 = calculateR(pointA[0], pointA[1], xs, ys);
    }

    private double calculateW(double x1, double y1, double x2, double y2, double x3, double y3){
        return 4 * (x2 - x1) * (y2 - y3) - 4 *(x2 - x3) * (y2 - y1);
    }
    private double calculateWxs(double x1, double y1, double x2, double y2, double x3, double y3){
        return 2 * (y2 - y3) * (x2*x2 - x1*x1 + y2*y2 - y1*y1) - 2 * (y2 - y1) * (x2*x2 - x3*x3 + y2*y2 - y3*y3);

    }
    private double calculateWys(double x1, double y1, double x2, double y2, double x3, double y3){
        return 2 * (x2 - x1) * (x2*x2 - x3*x3 + y2*y2 - y3*y3) - 2 * (x2 - x3) * (x2*x2 - x1*x1 + y2*y2 - y1*y1);
    }

    private double calculateR(double x1, double y1, double xs, double ys){
        return (x1 - xs) * (x1 - xs) + (y1 - ys) * (y1 - ys);
    }
}
