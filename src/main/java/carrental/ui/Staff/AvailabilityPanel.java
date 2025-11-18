/*
 * Created by JFormDesigner on Tue Nov 18 00:30:23 SGT 2025
 */

package carrental.ui.Staff;

import java.awt.*;
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

        //---- label1 ----
        label1.setText("Filter");

        //---- comboBoxFilter ----
        comboBoxFilter.setModel(new DefaultComboBoxModel<>(new String[] {
            "All",
            "Available",
            "Rented",
            "Maintenance"
        }));

        //---- buttonRefresh ----
        buttonRefresh.setText("Refresh");

        //---- label2 ----
        label2.setText("Car Inventory Table");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tableCarAvailability);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(comboBoxFilter, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(buttonRefresh, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 957, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 966, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label1))
                        .addComponent(comboBoxFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonRefresh))
                    .addGap(31, 31, 31)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
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
