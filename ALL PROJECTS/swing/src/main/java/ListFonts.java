import java.awt.*;

/**
 * Created by dreaminteam on 5.6.15.
 */
public class ListFonts {

    public static void main(String[] args) {

        String[] fontNames= GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        for (int i=0;i<fontNames.length;i++){
            System.out.println(fontNames[i]);
        }
    }
}
