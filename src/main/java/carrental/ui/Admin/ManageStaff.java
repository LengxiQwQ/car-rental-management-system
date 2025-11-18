/*
 * Created by JFormDesigner on Tue Nov 18 19:00:15 SGT 2025
 */

package carrental.ui.Admin;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author LengxiQwQ
 */
public class ManageStaff extends JPanel {
    public ManageStaff() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxSearchStaffType = new JComboBox<>();
        textSearchStaffContent = new JTextField();
        buttonSearchStaff = new JButton();
        scrollPane1 = new JScrollPane();
        tableStaffInfo = new JTable();
        buttonAddStaff = new JButton();
        buttonDeleteSelected = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Search Staff");

        //---- comboBoxSearchStaffType ----
        comboBoxSearchStaffType.setModel(new DefaultComboBoxModel<>(new String[] {
            "Name",
            "Staff ID"
        }));

        //---- buttonSearchStaff ----
        buttonSearchStaff.setText("Search Staff");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tableStaffInfo);
        }

        //---- buttonAddStaff ----
        buttonAddStaff.setText("Add Staff");

        //---- buttonDeleteSelected ----
        buttonDeleteSelected.setText("Delete Selected");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 965, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBoxSearchStaffType, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textSearchStaffContent, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonSearchStaff)
                            .addGap(108, 108, 108)
                            .addComponent(buttonDeleteSelected)
                            .addGap(18, 18, 18)
                            .addComponent(buttonAddStaff)
                            .addGap(34, 34, 34)))
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textSearchStaffContent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSearchStaff)
                        .addComponent(comboBoxSearchStaffType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(buttonAddStaff)
                        .addComponent(buttonDeleteSelected))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox<String> comboBoxSearchStaffType;
    private JTextField textSearchStaffContent;
    private JButton buttonSearchStaff;
    private JScrollPane scrollPane1;
    private JTable tableStaffInfo;
    private JButton buttonAddStaff;
    private JButton buttonDeleteSelected;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
