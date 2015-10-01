import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by dreaminteam on 10.6.15.
 */

public class ActionTest {

    public static void main(String[] args) {

        Runnable run=()->{
            ActionFrame frame=new ActionFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        };
        new Thread(run).start();
    }
}


class ActionFrame extends JFrame{


    public ActionFrame(){

        setTitle("ActionTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        buttonPanel=new JPanel();

        Action yellowAction=new ColorAction("Yellow",new ImageIcon(iconPath), Color.YELLOW);
        Action blueAction=new ColorAction("Blue",new ImageIcon(iconPath),Color.BLUE);
        Action redAction=new ColorAction("Red",new ImageIcon(iconPath),Color.RED);

        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        add(buttonPanel);

        InputMap imap=buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

        ActionMap amap=buttonPanel.getActionMap();
        amap.put("panel.yellow",yellowAction);
        amap.put("panel.blue",blueAction);
        amap.put("panel.red",redAction);
    }

    private class ColorAction extends AbstractAction{

        public ColorAction(String name,Icon icon,Color c){

            putValue(Action.NAME,name);
            putValue(Action.SMALL_ICON,icon);
            putValue(Action.SHORT_DESCRIPTION,"Set panel color to "+
            name.toLowerCase());
            putValue("color",c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Color c=(Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }

    private JPanel buttonPanel;

    public static final String iconPath="/home/dreaminteam/ALL PROJECTS/swing/src/main/resources/01.gif";

    public static final int DEFAULT_WIDTH=300;
    public static final int DEFAULT_HEIGHT=200;
}
