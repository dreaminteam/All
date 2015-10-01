import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dreaminteam on 9.6.15.
 */
public class ButtonTest {

    public static void main(String[] args) {

        Runnable run = () -> {
            ButtonFrame frame = new ButtonFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        };
        new Thread(run).start();
    }
}


class ButtonFrame extends JFrame {

    public ButtonFrame() {

        setTitle("ButtonTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JButton yellowButton = new JButton("YELLOW");
        JButton blueButton = new JButton("BLUE");
        JButton redButton = new JButton("RED");

        buttonPanel = new JPanel();

        buttonPanel.setBackground(Color.BLACK);

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        add(buttonPanel);


        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }


    private class ColorAction implements ActionListener {

        public ColorAction(Color c) {
            backgroundColor = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            buttonPanel.setBackground(backgroundColor);
        }

        private Color backgroundColor;
    }


    private JPanel buttonPanel;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}
