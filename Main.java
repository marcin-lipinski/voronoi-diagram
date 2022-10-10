package VoronoiDiagram;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        new Voronoi().setVisible(true);;

        double[][] pr = {{4, 5}, {2, 1}, {-3, -9}};
        ArrayList<double[]> points = new ArrayList<>(Arrays.asList(pr));

        Points p = new Points(points);
        //Voroni v = new Voroni(new double[][]{{4, 5}, {2, 1}, {-3, -9}});
    }


}
