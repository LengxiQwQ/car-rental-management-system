/*
 * Created by JFormDesigner on Tue Nov 18 00:37:45 SGT 2025
 */

package carrental.ui.Staff;

import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author LengxiQwQ
 */
public class CustomerPanel extends JPanel {
    public CustomerPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane2 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setLayout(new FormLayout(
            "default, $lcgap, default",
            "2*(default, $lgap), default"));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table1);
        }
        add(scrollPane2, CC.xy(1, 3));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane2;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
