/**
 * Created by dreaminteam on 1.6.15.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class SizedFrameTest {


    static class SizedFrame extends JFrame {

        public static void main(String[] args) {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    SizedFrame frame = new SizedFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            });
        }

        public SizedFrame() {

            //определение размеров экрана
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;

            //установка высоты и ширины фрейма и
            //позитионирование с помощью платформы

            setSize(screenWidth / 2, screenHeight / 2);
            setLocationByPlatform(true);

            //установка пиктограммы и заголовка окна

            Image img = kit.getImage("DSCF5506.JPG");
            setIconImage(img);
            setTitle("SizedFreme");
            MessagePanel panel = new MessagePanel();
            //add(panel);
            // setUndecorated(true);
            //setResizable(false);

            DrawComponent drawComponent = new DrawComponent();
            add(drawComponent);
        }


    }

    static class MessagePanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            g.drawString("Not a Hello, World program", Message_X, Message_Y);
        }

        public static final int Message_X = 75;
        public static final int Message_Y = 100;
    }

    static class DrawComponent extends JComponent {

        @Override
        public void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;

            g2.setPaint(Color.blue);

            double leftX = 100;
            double topY = 100;
            double width = 200;
            double height = 150;

            Rectangle2D rectangle2D = new Rectangle2D.Double(leftX, topY, width, height);
            g2.draw(rectangle2D);

            Ellipse2D ellipse2D = new Ellipse2D.Double(leftX, topY, width, height);
            g2.draw(ellipse2D);

            Ellipse2D ellipse = new Ellipse2D.Double();
            ellipse.setFrame(rectangle2D);
            g2.draw(ellipse);

            g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

            double centerX = rectangle2D.getCenterX();
            double centerY = rectangle2D.getCenterY();
            double radius = 150;

            Ellipse2D circle = new Ellipse2D.Double();
            circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
            g2.draw(circle);

            g2.setPaint(Color.red);
            g2.drawString("Color is red",100,100);
            g2.setPaint(new Color(110,100,40));
            g2.drawString("Color is green",100,200);
            //g2.fill(ellipse);

        }
    }
}
