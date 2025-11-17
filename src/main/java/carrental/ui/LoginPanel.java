/*
 * Created by JFormDesigner on Mon Nov 17 14:20:05 SGT 2025
 */

package carrental.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author LengxiQwQ
 */
public class LoginPanel extends JPanel {
    public LoginPanel() {
        initComponents();
    }

    private void userRoleItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        titleLogin = new JLabel();
        buttonLogin = new JButton();
        buttonGoToRegister = new JButton();
        label9 = new JLabel();
        textPassword = new JTextField();
        textUserID = new JTextField();
        label12 = new JLabel();
        roleComboBox = new JComboBox<>();
        label8 = new JLabel();

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[138,fill]" +
            "[fill]",
            // rows
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
        add(titleLogin, "cell 1 2 2 1");

        //---- buttonLogin ----
        buttonLogin.setText("Login");
        add(buttonLogin, "cell 2 7");

        //---- buttonGoToRegister ----
        buttonGoToRegister.setText("Go To Register");
        add(buttonGoToRegister, "cell 1 7");

        //---- label9 ----
        label9.setText("Password");
        add(label9, "cell 1 5");
        add(textPassword, "cell 2 5");
        add(textUserID, "cell 2 4");

        //---- label12 ----
        label12.setText("Select your Role");
        add(label12, "cell 1 3");

        //---- roleComboBox ----
        roleComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "Staff",
            "Admin"
        }));
        roleComboBox.addItemListener(e -> userRoleItemStateChanged(e));
        add(roleComboBox, "cell 2 3");

        //---- label8 ----
        label8.setText("Your ID");
        add(label8, "cell 1 4");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel titleLogin;
    private JButton buttonLogin;
    private JButton buttonGoToRegister;
    private JLabel label9;
    private JTextField textPassword;
    private JTextField textUserID;
    private JLabel label12;
    private JComboBox<String> roleComboBox;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
