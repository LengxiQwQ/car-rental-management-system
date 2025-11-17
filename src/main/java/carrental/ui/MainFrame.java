/*
 * Created by JFormDesigner on Mon Nov 17 15:28:47 SGT 2025
 */

package carrental.ui;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author LengxiQwQ
 */
public class MainFrame  {

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        cardPanel = new JFrame();
        panel1 = new JPanel();

        //======== cardPanel ========
        {
            cardPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            cardPanel.setTitle("Car Rental Management System");
            var cardPanelContentPane = cardPanel.getContentPane();
            cardPanelContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[725,grow,fill]",
                // rows
                "[grow,fill]"));

            //======== panel1 ========
            {
                panel1.setLayout(new CardLayout());
            }
            cardPanelContentPane.add(panel1, "cell 0 0");
            cardPanel.setSize(715, 550);
            cardPanel.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame cardPanel;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
