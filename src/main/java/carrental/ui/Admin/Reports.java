/*
 * Created by JFormDesigner on Tue Nov 18 18:59:59 SGT 2025
 */

package carrental.ui.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.*;
import com.toedter.calendar.*;

/**
 * @author LengxiQwQ
 */
public class Reports extends JPanel {
    public Reports() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        tableCustomerInfo = new JTable();
        label8 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        textInputIDCardNumber = new JTextField();
        label5 = new JLabel();
        textInputEmail = new JTextField();
        label6 = new JLabel();
        textInputAddress = new JTextField();
        label7 = new JLabel();
        textInputDriverLicenseNumber = new JTextField();
        buttonSave = new JButton();
        label9 = new JLabel();
        dateChooser1 = new JDateChooser();

        //======== this ========

        //======== scrollPane1 ========
        {

            //---- tableCustomerInfo ----
            tableCustomerInfo.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(tableCustomerInfo);
        }

        //---- label8 ----
        label8.setText("Selected Customer Details\uff1a");
        label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

        //---- label1 ----
        label1.setText("From date");

        //---- label2 ----
        label2.setText("To date");

        //---- label4 ----
        label4.setText("ID card number");

        //---- label5 ----
        label5.setText("Email address");

        //---- label6 ----
        label6.setText("Address");

        //---- label7 ----
        label7.setText("Driver license number");

        //---- buttonSave ----
        buttonSave.setText("Save Change");

        //---- label9 ----
        label9.setText("Reports");
        label9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        label9.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(27, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label8, GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonSave, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textInputEmail)
                                    .addComponent(textInputAddress)
                                    .addComponent(textInputIDCardNumber)
                                    .addComponent(dateChooser1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textInputDriverLicenseNumber, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(label9)
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(dateChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addComponent(label2)
                            .addGap(63, 63, 63)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textInputIDCardNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(textInputEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(textInputAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7)
                                .addComponent(textInputDriverLicenseNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(107, 107, 107)
                            .addComponent(label8)
                            .addGap(22, 22, 22)
                            .addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(25, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable tableCustomerInfo;
    private JLabel label8;
    private JLabel label1;
    private JLabel label2;
    private JLabel label4;
    private JTextField textInputIDCardNumber;
    private JLabel label5;
    private JTextField textInputEmail;
    private JLabel label6;
    private JTextField textInputAddress;
    private JLabel label7;
    private JTextField textInputDriverLicenseNumber;
    private JButton buttonSave;
    private JLabel label9;
    private JDateChooser dateChooser1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
