/*
 * Created by JFormDesigner on Sun Nov 16 22:44:07 SGT 2025
 */

package carrental.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author LengxiQwQ
 */
public class userLoginForm extends JFrame {
    public userLoginForm() {
        initComponents();
    }

    private void userRoleItemStateChanged(ItemEvent e) {
        // Listen for selection changes
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedRole = (String) roleComboBox.getSelectedItem();
            System.out.println("[Login] Currently selected role: " + selectedRole);

            // Show or hide panels based on selection
            boolean isCustomer = "Customer".equals(selectedRole);
            boolean isAdminOrStaff = "Admin".equals(selectedRole) || "Staff".equals(selectedRole);
            panelCustomer.setVisible(isCustomer);
            panelStaffAdmin.setVisible(isAdminOrStaff);
        }
    }

    private void buttonRegisterActionPerformed(ActionEvent e) {
        // Open register window and close current login window
        new userRegisterForm().setVisible(true);
        this.dispose(); // Close current window
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        this2 = new JFrame();
        titleLogin = new JLabel();
        label12 = new JLabel();
        roleComboBox = new JComboBox<>();
        panelCustomer = new JPanel();
        label2 = new JLabel();
        textCustomerID = new JTextField();
        panelStaffAdmin = new JPanel();
        label8 = new JLabel();
        textUserID = new JTextField();
        panelDefault = new JPanel();
        label9 = new JLabel();
        textPassword = new JTextField();
        buttonRegister = new JButton();
        buttonGoToLogin = new JButton();

        //======== this2 ========
        {
            this2.setVisible(true);
            var this2ContentPane = this2.getContentPane();
            this2ContentPane.setLayout(new MigLayout(
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

            //---- titleLogin ----
            titleLogin.setText("Login Page");
            titleLogin.setFont(new Font("Segoe UI", Font.BOLD, 20));
            titleLogin.setHorizontalAlignment(SwingConstants.CENTER);
            this2ContentPane.add(titleLogin, "cell 0 1 2 1");

            //---- label12 ----
            label12.setText("Select your Role");
            this2ContentPane.add(label12, "cell 0 4");

            //---- roleComboBox ----
            roleComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "Customer",
                "Staff",
                "Admin"
            }));
            roleComboBox.addItemListener(e -> userRoleItemStateChanged(e));
            this2ContentPane.add(roleComboBox, "cell 1 4");

            //======== panelCustomer ========
            {
                panelCustomer.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[154,fill]" +
                    "[166,fill]",
                    // rows
                    "[]"));

                //---- label2 ----
                label2.setText("Customer ID");
                panelCustomer.add(label2, "cell 0 0");
                panelCustomer.add(textCustomerID, "cell 1 0");
            }
            this2ContentPane.add(panelCustomer, "cell 0 6 2 1");

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
            this2ContentPane.add(panelStaffAdmin, "cell 0 7 2 1");

            //======== panelDefault ========
            {
                panelDefault.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[154,fill]" +
                    "[166,fill]",
                    // rows
                    "[]"));

                //---- label9 ----
                label9.setText("Password");
                panelDefault.add(label9, "cell 0 0");
                panelDefault.add(textPassword, "cell 1 0");
            }
            this2ContentPane.add(panelDefault, "cell 0 8 2 1");

            //---- buttonRegister ----
            buttonRegister.setText("Go To Register");
            this2ContentPane.add(buttonRegister, "cell 0 10");

            //---- buttonGoToLogin ----
            buttonGoToLogin.setText("Login");
            this2ContentPane.add(buttonGoToLogin, "cell 1 10");
            this2.pack();
            this2.setLocationRelativeTo(this2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame this2;
    private JLabel titleLogin;
    private JLabel label12;
    private JComboBox<String> roleComboBox;
    private JPanel panelCustomer;
    private JLabel label2;
    private JTextField textCustomerID;
    private JPanel panelStaffAdmin;
    private JLabel label8;
    private JTextField textUserID;
    private JPanel panelDefault;
    private JLabel label9;
    private JTextField textPassword;
    private JButton buttonRegister;
    private JButton buttonGoToLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}