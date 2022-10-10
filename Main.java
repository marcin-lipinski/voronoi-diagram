package VoronoiDiagram;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        String pointsAsString = "(4, 5); (2, 1); (-3, -9)";
        pointsAsString = "(20,0);(15,0);(10,0);(5,0);(0,0);(-5,0);(-10,0);(-15,0);(-20,0);(-30,0)";
        ArrayList<double[]> points = convertPointsStringToArray(pointsAsString);

        new VoronoiInterpreter(points);
    }

    static ArrayList<double[]> convertPointsStringToArray(String s){
        ArrayList<double[]> p = new ArrayList<>();
        String[] temp = s.trim().split(";");

        for(int i = 0; i<temp.length; i++){
            String[] point = temp[i].trim().replace("(", "").replace(")", "").split(",");
            if(point[0].length() == 0 || point[1].length() == 0 ) break;
            else p.add(new double[]{Double.parseDouble(point[0].trim()), Double.parseDouble(point[1].trim())});
        }
        return p;
    }
}
