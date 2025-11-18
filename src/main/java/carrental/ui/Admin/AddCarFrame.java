/*
 * Created by JFormDesigner on Tue Nov 18 23:49:20 SGT 2025
 */

package carrental.ui.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LengxiQwQ
 */
public class AddCarFrame extends JFrame {
    public AddCarFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        textFieldAddCarID = new JTextField();
        label3 = new JLabel();
        textFieldtextFieldAddCarBrand = new JTextField();
        textFieldAddCarYear = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textFieldAddCarModel = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        textFieldAddCarLicencePlate = new JTextField();
        textFieldAddCarColor = new JTextField();
        textFieldAddCarStatus = new JTextField();
        textFieldAddCarDailyFee = new JTextField();
        buttonAddCar = new JButton();
        buttonAddCarCancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Add Car");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label2 ----
        label2.setText("Car ID");

        //---- label3 ----
        label3.setText("Brand");

        //---- label4 ----
        label4.setText("Year");

        //---- label5 ----
        label5.setText("Model");

        //---- label6 ----
        label6.setText("Daily fee");

        //---- label7 ----
        label7.setText("Status");

        //---- label8 ----
        label8.setText("Color");

        //---- label9 ----
        label9.setText("Licence plate");

        //---- buttonAddCar ----
        buttonAddCar.setText("Add");

        //---- buttonAddCarCancel ----
        buttonAddCarCancel.setText("Cancel");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(75, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(buttonAddCarCancel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAddCar))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label2)
                                .addComponent(label4)
                                .addComponent(label5)
                                .addComponent(label7)
                                .addComponent(label8)
                                .addComponent(label6)
                                .addComponent(label9))
                            .addGap(21, 21, 21)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textFieldAddCarColor, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldAddCarStatus, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldAddCarDailyFee, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textFieldAddCarID, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(textFieldAddCarLicencePlate, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(textFieldtextFieldAddCarBrand, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(textFieldAddCarModel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(textFieldAddCarYear, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                                .addComponent(label1))))
                    .addContainerGap(94, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(label1)
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textFieldAddCarID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textFieldtextFieldAddCarBrand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textFieldAddCarModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textFieldAddCarYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldAddCarLicencePlate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8)
                        .addComponent(textFieldAddCarColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(textFieldAddCarStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(textFieldAddCarDailyFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAddCar)
                        .addComponent(buttonAddCarCancel))
                    .addContainerGap(43, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField textFieldAddCarID;
    private JLabel label3;
    private JTextField textFieldtextFieldAddCarBrand;
    private JTextField textFieldAddCarYear;
    private JLabel label4;
    private JLabel label5;
    private JTextField textFieldAddCarModel;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField textFieldAddCarLicencePlate;
    private JTextField textFieldAddCarColor;
    private JTextField textFieldAddCarStatus;
    private JTextField textFieldAddCarDailyFee;
    private JButton buttonAddCar;
    private JButton buttonAddCarCancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
