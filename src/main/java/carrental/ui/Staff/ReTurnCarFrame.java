/*
 * Created by JFormDesigner on Wed Nov 19 01:36:28 SGT 2025
 */

package carrental.ui.Staff;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LengxiQwQ
 */
public class ReTurnCarFrame extends JFrame {
    public ReTurnCarFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textFieldAddStaffID = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textFieldtextFieldAddStaffName = new JTextField();
        label4 = new JLabel();
        textFieldtextFieldAddStaffPassword = new JTextField();
        buttonAddStaff = new JButton();
        buttonAddStaffCancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Return Car");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label2 ----
        label2.setText("Staff ID");

        //---- label3 ----
        label3.setText("Username");

        //---- label4 ----
        label4.setText("Password");

        //---- buttonAddStaff ----
        buttonAddStaff.setText("Add");

        //---- buttonAddStaffCancel ----
        buttonAddStaffCancel.setText("Cancel");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(57, 57, 57)
                            .addComponent(textFieldAddStaffID, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(45, 45, 45)
                            .addComponent(textFieldtextFieldAddStaffName, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(48, 48, 48)
                            .addComponent(textFieldtextFieldAddStaffPassword, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(buttonAddStaffCancel)
                            .addGap(87, 87, 87)
                            .addComponent(buttonAddStaff)))
                    .addContainerGap(135, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(label1)
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label2))
                        .addComponent(textFieldAddStaffID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label3))
                        .addComponent(textFieldtextFieldAddStaffName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label4))
                        .addComponent(textFieldtextFieldAddStaffPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(65, 65, 65)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(buttonAddStaffCancel)
                        .addComponent(buttonAddStaff))
                    .addContainerGap(122, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textFieldAddStaffID;
    private JLabel label2;
    private JLabel label3;
    private JTextField textFieldtextFieldAddStaffName;
    private JLabel label4;
    private JTextField textFieldtextFieldAddStaffPassword;
    private JButton buttonAddStaff;
    private JButton buttonAddStaffCancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
