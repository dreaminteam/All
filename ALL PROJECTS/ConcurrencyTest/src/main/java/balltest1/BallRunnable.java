package balltest1;

import java.awt.*;

/**
 * Created by dreaminteam on 8.7.15.
 */
public class BallRunnable implements Runnable {

    public BallRunnable(Ball aBall, Component aComponent){
        ball=aBall;
        component=aComponent;
    }

    @Override
    public void run() {
        try {
            for (int i=1;i<=STEPS;i++){
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private Ball ball;
    private Component component;
    public static final int STEPS=1000;
    public static final int DELAY=5;
}
