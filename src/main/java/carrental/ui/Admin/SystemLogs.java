/*
 * Created by JFormDesigner on Tue Nov 18 18:59:51 SGT 2025
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
public class SystemLogs extends JPanel {
    public SystemLogs() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxFilterbyUser = new JComboBox();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        tableLogRecords = new JTable();
        dateChooserFilterbyDate = new JDateChooser();
        label10 = new JLabel();
        buttonRefresh = new JButton();
        buttonEnterFilterbyDate = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Filter by User");

        //---- label2 ----
        label2.setText("Filter by Date");

        //======== scrollPane1 ========
        {

            //---- tableLogRecords ----
            tableLogRecords.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(tableLogRecords);
        }

        //---- label10 ----
        label10.setText("Log Records");
        label10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        label10.setHorizontalAlignment(SwingConstants.CENTER);

        //---- buttonRefresh ----
        buttonRefresh.setText("Refresh");

        //---- buttonEnterFilterbyDate ----
        buttonEnterFilterbyDate.setText("Enter");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(comboBoxFilterbyUser, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                            .addGap(116, 116, 116)
                            .addComponent(buttonRefresh)
                            .addGap(76, 76, 76)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateChooserFilterbyDate, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonEnterFilterbyDate))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(375, 375, 375)
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 968, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(label10)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBoxFilterbyUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1)
                                    .addComponent(buttonRefresh)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(buttonEnterFilterbyDate)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateChooserFilterbyDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox comboBoxFilterbyUser;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable tableLogRecords;
    private JDateChooser dateChooserFilterbyDate;
    private JLabel label10;
    private JButton buttonRefresh;
    private JButton buttonEnterFilterbyDate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
