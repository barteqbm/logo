

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bartek
 */

import pl.edu.agh.student.jfik.gui.MainWindow;
import javax.swing.SwingUtilities;

public class LogoGUI {
    
    public static void main(String[] argv) {
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainWindow window = new MainWindow();
                window.setVisible(true);
            }
        });
        
    }
            
    
}
