import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

/**
 * Created by dreaminteam on 5.6.15.
 */
public class FontTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FontFrame frame = new FontFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}

class FontFrame extends JFrame {

    public FontFrame() {

        setTitle("FontTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        FontComponent component = new FontComponent();
        add(component);

        ImageComponent imageComponent = new ImageComponent();
       // add(imageComponent);

    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;


    private class FontComponent extends JComponent {

        @Override
        public void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;
            // String message="Hello, World";

            Font f = new Font("Serif", Font.ITALIC, 24);
            g2.setFont(f);

            String message = f.getFontName();

            FontRenderContext context = g2.getFontRenderContext();
            Rectangle2D bounds = f.getStringBounds(message, context);

            double x = (getWidth() - bounds.getWidth()) / 2;
            double y = (getHeight() - bounds.getHeight()) / 2;

            double ascent = -bounds.getY();
            double baseY = y + ascent;

            g2.drawString(message, (int) x, (int) baseY);

            g2.setPaint(Color.RED);

            g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

            g2.setPaint(Color.BLUE);
            g2.draw(new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight()));


        }
    }


    private class ImageComponent extends JComponent {

        public ImageComponent() {

            try {
                image = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            if (image == null) return;
            g.drawImage(image, 200, 200, null);
        }

        public String imagePath = "/home/dreaminteam/ALL PROJECTS/swing/src/main/resources/foto_106610.gif";
        private Image image;


    }
}
