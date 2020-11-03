package gui_test_1;

import java.awt.Image;
import java.awt.Toolkit;

public class GUI_test_1 {

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
        java.net.URL url = ClassLoader.getSystemResource("gui_test_1/Images/icon_c.png");
            Toolkit kit = Toolkit.getDefaultToolkit();
            Image img = kit.createImage(url);
            login.setIconImage(img);
    }
    
}
