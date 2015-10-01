import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*Листинг 8.2
/**
 * Created by dreaminteam on 9.6.15.
 */
public class PlafTest {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            PlafFrame frame = new PlafFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        };
        new Thread(runnable).start();
    }
}


class PlafFrame extends JFrame {

    public PlafFrame() {

        setTitle("PlafTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }

        add(buttonPanel);
    }


    void makeButton(String name, final String plafName) {

        JButton button = new JButton(name);
        buttonPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(plafName);
                    SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
    }

    private JPanel buttonPanel;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

}