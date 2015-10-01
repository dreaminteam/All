package CoreJavaBook.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 * Created by dreaminteam on 31.7.14.
 */
public class TimerTest {

    public static void main(String...args){
        ActionListener listener=new TimerPrint();
        Timer t=new Timer(1000,listener);
        t.start();
        JOptionPane.showMessageDialog(null,"Exit programm");
        System.exit(0);
    }
}

class TimerPrint implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent event){
        Date now=new Date();
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Time: "+now);
    }
}
