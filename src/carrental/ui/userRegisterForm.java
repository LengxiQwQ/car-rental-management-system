/*
 * Created by JFormDesigner on Sun Nov 16 17:18:44 SGT 2025
 */

package carrental.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author LengxiQwQ
 */
public class userRegisterForm extends JFrame {
    public userRegisterForm() {
        initComponents();
    }

    private void userRoleItemStateChanged(ItemEvent e) {
        // Listen for selection changes
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedRole = (String) roleComboBox.getSelectedItem();
            System.out.println("[Register] Currently selected role: " + selectedRole);

            // Show or hide panels based on selection
            boolean isCustomer = "Customer".equals(selectedRole);
            boolean isAdminOrStaff = "Admin".equals(selectedRole) || "Staff".equals(selectedRole);
            panelCustomer.setVisible(isCustomer);
            panelStaffAdmin.setVisible(isAdminOrStaff);
        }
    }

    private void buttonGoToLoginActionPerformed(ActionEvent e) {
        // Open login window and close current register window
        new userLoginForm().setVisible(true);
        this.dispose(); // Close current window
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        titleRegister = new JLabel();
        label12 = new JLabel();
        roleComboBox = new JComboBox<>();
        panelCustomer = new JPanel();
        label2 = new JLabel();
        textCustomerID = new JTextField();
        label10 = new JLabel();
        textDriverLicenseNumber = new JTextField();
        label4 = new JLabel();
        textPhoneNumber = new JTextField();
        label5 = new JLabel();
        textEmail = new JTextField();
        label6 = new JLabel();
        textAddress = new JTextField();
        panelStaffAdmin = new JPanel();
        label8 = new JLabel();
        textUserID = new JTextField();
        panelDefault = new JPanel();
        label3 = new JLabel();
        textName = new JTextField();
        label9 = new JLabel();
        textPassword = new JTextField();
        label11 = new JLabel();
        textPasswordConfirm = new JTextField();
        buttonGoToLogin = new JButton();
        buttonRegister = new JButton();

        //======== this ========
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[163,fill]" +
            "[168,fill]",
            // rows
            "[]" +
            "[]" +
            "[18]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- titleRegister ----
        titleRegister.setText("Register Page");
        titleRegister.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleRegister.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titleRegister, "cell 0 1 2 1");

        //---- label12 ----
        label12.setText("Select your Role");
        contentPane.add(label12, "cell 0 4");

        //---- roleComboBox ----
        roleComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "Customer",
            "Staff",
            "Admin"
        }));
        roleComboBox.addItemListener(e -> userRoleItemStateChanged(e));
        contentPane.add(roleComboBox, "cell 1 4");

        //======== panelCustomer ========
        {
            panelCustomer.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[154,fill]" +
                "[166,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label2 ----
            label2.setText("Customer ID");
            panelCustomer.add(label2, "cell 0 0");
            panelCustomer.add(textCustomerID, "cell 1 0");

            //---- label10 ----
            label10.setText("Driver License Number");
            panelCustomer.add(label10, "cell 0 1");
            panelCustomer.add(textDriverLicenseNumber, "cell 1 1");

            //---- label4 ----
            label4.setText("Phone Number");
            panelCustomer.add(label4, "cell 0 2");
            panelCustomer.add(textPhoneNumber, "cell 1 2");

            //---- label5 ----
            label5.setText("Email");
            panelCustomer.add(label5, "cell 0 3");
            panelCustomer.add(textEmail, "cell 1 3");

            //---- label6 ----
            label6.setText("Address");
            panelCustomer.add(label6, "cell 0 4");
            panelCustomer.add(textAddress, "cell 1 4");
        }
        contentPane.add(panelCustomer, "cell 0 6 2 1");

        //======== panelStaffAdmin ========
        {
            panelStaffAdmin.setLayout(new MigLayout(
                "novisualpadding,hidemode 3",
                // columns
                "[154,fill]" +
                "[166,fill]",
                // rows
                "[]"));

            //---- label8 ----
            label8.setText("Your ID");
            panelStaffAdmin.add(label8, "cell 0 0");
            panelStaffAdmin.add(textUserID, "cell 1 0");
        }
        contentPane.add(panelStaffAdmin, "cell 0 7 2 1");

        //======== panelDefault ========
        {
            panelDefault.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[154,fill]" +
                "[166,fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //---- label3 ----
            label3.setText("Name");
            panelDefault.add(label3, "cell 0 0");
            panelDefault.add(textName, "cell 1 0");

            //---- label9 ----
            label9.setText("Password");
            panelDefault.add(label9, "cell 0 1");
            panelDefault.add(textPassword, "cell 1 1");

            //---- label11 ----
            label11.setText("Confirm");
            panelDefault.add(label11, "cell 0 2");
            panelDefault.add(textPasswordConfirm, "cell 1 2");
        }
        contentPane.add(panelDefault, "cell 0 8 2 1");

        //---- buttonGoToLogin ----
        buttonGoToLogin.setText("Go to Login");
        contentPane.add(buttonGoToLogin, "cell 0 10");

        //---- buttonRegister ----
        buttonRegister.setText("Register");
        contentPane.add(buttonRegister, "cell 1 10");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel titleRegister;
    private JLabel label12;
    private JComboBox<String> roleComboBox;
    private JPanel panelCustomer;
    private JLabel label2;
    private JTextField textCustomerID;
    private JLabel label10;
    private JTextField textDriverLicenseNumber;
    private JLabel label4;
    private JTextField textPhoneNumber;
    private JLabel label5;
    private JTextField textEmail;
    private JLabel label6;
    private JTextField textAddress;
    private JPanel panelStaffAdmin;
    private JLabel label8;
    private JTextField textUserID;
    private JPanel panelDefault;
    private JLabel label3;
    private JTextField textName;
    private JLabel label9;
    private JTextField textPassword;
    private JLabel label11;
    private JTextField textPasswordConfirm;
    private JButton buttonGoToLogin;
    private JButton buttonRegister;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}