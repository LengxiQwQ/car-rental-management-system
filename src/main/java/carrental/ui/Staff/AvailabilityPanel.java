/*
 * Created by JFormDesigner on Tue Nov 18 00:30:23 SGT 2025
 */

package carrental.ui.Staff;

import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author LengxiQwQ
 */
public class AvailabilityPanel extends JPanel {
    public AvailabilityPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxFilter = new JComboBox<>();
        buttonRefresh = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        tableCarAvailability = new JTable();

        //======== this ========
        setLayout(new FormLayout(
            "default, $lcgap, 31dlu, $lcgap, 83dlu, $lcgap, default, $lcgap, 49dlu, $lcgap, 281dlu",
            "3*(default, $lgap), default, $pgap, default"));

        //---- label1 ----
        label1.setText("Filter");
        add(label1, CC.xy(3, 3));

        //---- comboBoxFilter ----
        comboBoxFilter.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Available",
            "Rented",
            "Maintenance"
        }));
        add(comboBoxFilter, CC.xy(5, 3));

        //---- buttonRefresh ----
        buttonRefresh.setText("Refresh");
        add(buttonRefresh, CC.xy(9, 3));

        //---- label2 ----
        label2.setText("Car Inventory Table");
        add(label2, CC.xywh(3, 7, 9, 1));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tableCarAvailability);
        }
        add(scrollPane1, CC.xywh(3, 9, 9, 1));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox<String> comboBoxFilter;
    private JButton buttonRefresh;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable tableCarAvailability;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
