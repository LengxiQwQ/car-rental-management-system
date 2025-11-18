/*
 * Created by JFormDesigner on Tue Nov 18 00:30:25 SGT 2025
 */

package carrental.ui.Staff;

import javax.swing.*;
import javax.swing.table.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author LengxiQwQ
 */
public class ManageRentalsPanel extends JPanel {
    public ManageRentalsPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBoxRentalCustomer = new JComboBox();
        label3 = new JLabel();
        comboBoxRentalStartDate = new JComboBox();
        label2 = new JLabel();
        comboBoxRentalCar = new JComboBox();
        label4 = new JLabel();
        comboBoxRentalEndDate = new JComboBox();
        buttonRentalAdd = new JButton();
        buttonRentalReturn = new JButton();
        label5 = new JLabel();
        textComment = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setLayout(new FormLayout(
            "default, $lcgap, 37dlu, $lcgap, 63dlu, $rgap, 18dlu, $lcgap, 17dlu, $lcgap, 43dlu, $lcgap, 61dlu, $lcgap, 29dlu, $lcgap, 61dlu, 2*($lcgap, default)",
            "4*(default, $lgap), default, $pgap, default, $lgap, 186dlu"));

        //---- label1 ----
        label1.setText("Customer");
        add(label1, CC.xy(3, 3));
        add(comboBoxRentalCustomer, CC.xy(5, 3));

        //---- label3 ----
        label3.setText("Start Date");
        add(label3, CC.xy(11, 3));
        add(comboBoxRentalStartDate, CC.xy(13, 3));

        //---- label2 ----
        label2.setText("Car");
        add(label2, CC.xy(3, 5));
        add(comboBoxRentalCar, CC.xy(5, 5));

        //---- label4 ----
        label4.setText("End Date");
        add(label4, CC.xy(11, 5));
        add(comboBoxRentalEndDate, CC.xy(13, 5));

        //---- buttonRentalAdd ----
        buttonRentalAdd.setText("Add Rental");
        add(buttonRentalAdd, CC.xy(17, 5));

        //---- buttonRentalReturn ----
        buttonRentalReturn.setText("Return Car");
        add(buttonRentalReturn, CC.xy(21, 5));

        //---- label5 ----
        label5.setText("Comment");
        add(label5, CC.xy(3, 9));
        add(textComment, CC.xywh(5, 9, 17, 1));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
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
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, CC.xywh(3, 13, 19, 1));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox comboBoxRentalCustomer;
    private JLabel label3;
    private JComboBox comboBoxRentalStartDate;
    private JLabel label2;
    private JComboBox comboBoxRentalCar;
    private JLabel label4;
    private JComboBox comboBoxRentalEndDate;
    private JButton buttonRentalAdd;
    private JButton buttonRentalReturn;
    private JLabel label5;
    private JTextField textComment;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
