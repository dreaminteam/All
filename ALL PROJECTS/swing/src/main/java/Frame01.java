/**
 *
 * Created by dreaminteam on 1.6.15.
 */
import javax.swing.*;
import java.awt.*;

public class Frame01 {

    public static void main(String[] args) {

        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenWidth=screenSize.width;
        int screenHeight=screenSize.height;



        SimpleFrame frame=new SimpleFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hello library");
        frame.setResizable(false);
        frame.setLocation(screenWidth/2,screenHeight/2);
        frame.setVisible(true);

        Image img=kit.getImage("DSCF5506.JPG");//чет не работает
        frame.setIconImage(img);
    }



    static class SimpleFrame extends JFrame{

        public SimpleFrame(){
            setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

            Toolkit kit=Toolkit.getDefaultToolkit();
            Image img=kit.getImage("DSCF5506.JPG");//чет не работает
            setIconImage(img);
        }
    }

    public static final int DEFAULT_WIDTH=300;
    public static final int DEFAULT_HEIGHT=200;
}
