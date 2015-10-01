package balltest1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dreaminteam on 29.6.15.
 */
public class BallComponent extends JPanel {

    /**
     * add ball for component
     *
     * @param b - ball, witch add
     */



    public void add(Ball b) {
        balls.add(b);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    private ArrayList<Ball> balls = new ArrayList<Ball>();
}
