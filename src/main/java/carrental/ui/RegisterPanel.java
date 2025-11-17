/*
 * Created by JFormDesigner on Mon Nov 17 14:18:09 SGT 2025
 */

package carrental.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author LengxiQwQ
 */
public class RegisterPanel extends JPanel {
    public RegisterPanel() {
        initComponents();
    }

    private void userRoleItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        titleRegister = new JLabel();
        label12 = new JLabel();
        roleComboBox = new JComboBox<>();
        label8 = new JLabel();
        textUserID = new JTextField();
        label3 = new JLabel();
        textName = new JTextField();
        label9 = new JLabel();
        textPassword = new JTextField();
        label11 = new JLabel();
        textPasswordConfirm = new JTextField();
        buttonGoToLogin = new JButton();
        buttonRegister = new JButton();

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[149,fill]",
            // rows
            "[34]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[10]" +
            "[]" +
            "[]" +
            "[]"));

        //---- titleRegister ----
        titleRegister.setText("Register Page");
        titleRegister.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleRegister.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleRegister, "cell 0 1 2 1");

        //---- label12 ----
        label12.setText("Select your Role");
        add(label12, "cell 0 4");

        //---- roleComboBox ----
        roleComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "Staff",
            "Admin"
        }));
        roleComboBox.addItemListener(e -> userRoleItemStateChanged(e));
        add(roleComboBox, "cell 1 4");

        //---- label8 ----
        label8.setText("Your ID");
        add(label8, "cell 0 6");
        add(textUserID, "cell 1 6");

        //---- label3 ----
        label3.setText("Name");
        add(label3, "cell 0 7");
        add(textName, "cell 1 7");

        //---- label9 ----
        label9.setText("Password");
        add(label9, "cell 0 8");
        add(textPassword, "cell 1 8");

        //---- label11 ----
        label11.setText("Confirm");
        add(label11, "cell 0 9");
        add(textPasswordConfirm, "cell 1 9");

        //---- buttonGoToLogin ----
        buttonGoToLogin.setText("Go to Login");
        add(buttonGoToLogin, "cell 0 12");

        //---- buttonRegister ----
        buttonRegister.setText("Register");
        add(buttonRegister, "cell 1 12");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel titleRegister;
    private JLabel label12;
    private JComboBox<String> roleComboBox;
    private JLabel label8;
    private JTextField textUserID;
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
