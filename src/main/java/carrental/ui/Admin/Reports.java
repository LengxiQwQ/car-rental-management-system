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
        tableRentalHistory = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        buttonGenerateReport = new JButton();
        label9 = new JLabel();
        dateChooserFromDate = new JDateChooser();
        dateChooserToDate = new JDateChooser();
        label4 = new JLabel();
        label5 = new JLabel();
        labelTotalRentals = new JLabel();
        labelAvailableCars = new JLabel();
        label10 = new JLabel();

        //======== this ========

        //======== scrollPane1 ========
        {

            //---- tableRentalHistory ----
            tableRentalHistory.setModel(new DefaultTableModel(
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
            scrollPane1.setViewportView(tableRentalHistory);
        }

        //---- label1 ----
        label1.setText("From date");

        //---- label2 ----
        label2.setText("To date");

        //---- buttonGenerateReport ----
        buttonGenerateReport.setText("Generate Report");

        //---- label9 ----
        label9.setText("Reports");
        label9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        label9.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label4 ----
        label4.setText("Total Rentals: ");

        //---- label5 ----
        label5.setText("Available Cars: ");

        //---- labelTotalRentals ----
        labelTotalRentals.setText("0");

        //---- labelAvailableCars ----
        labelAvailableCars.setText("0");

        //---- label10 ----
        label10.setText("Rental History");
        label10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        label10.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 30, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelTotalRentals))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label5)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(labelAvailableCars))
                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 31, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(dateChooserToDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateChooserFromDate, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
                            .addGap(18, 18, 18))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(buttonGenerateReport, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(225, 225, 225)
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                            .addGap(239, 239, 239))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 671, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label10))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(labelTotalRentals))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(labelAvailableCars))
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(dateChooserFromDate, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 5, Short.MAX_VALUE)))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(dateChooserToDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54)
                            .addComponent(buttonGenerateReport, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addGap(211, 211, 211))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(25, Short.MAX_VALUE))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable tableRentalHistory;
    private JLabel label1;
    private JLabel label2;
    private JButton buttonGenerateReport;
    private JLabel label9;
    private JDateChooser dateChooserFromDate;
    private JDateChooser dateChooserToDate;
    private JLabel label4;
    private JLabel label5;
    private JLabel labelTotalRentals;
    private JLabel labelAvailableCars;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
