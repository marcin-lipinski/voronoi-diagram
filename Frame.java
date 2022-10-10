package VoronoiDiagram;

import javax.swing.*;

public class Frame extends JFrame {
    Frame(){
        super("Voronoi Diagram");
        setBounds(0, 0, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
