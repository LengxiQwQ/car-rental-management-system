/*
 * Created by JFormDesigner on Sun Nov 16 17:18:44 SGT 2025
 */

package carrental.ui;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author LengxiQwQ
 */
public class CustomerRegisterForm extends JFrame {
    public CustomerRegisterForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label3 = new JLabel();
        textName = new JTextField();
        label8 = new JLabel();
        textID = new JTextField();
        label2 = new JLabel();
        textUserName = new JTextField();
        label4 = new JLabel();
        textPhoneNumber = new JTextField();
        label5 = new JLabel();
        textEmail = new JTextField();
        label6 = new JLabel();
        textAddress = new JTextField();
        label10 = new JLabel();
        textDriverLicenseNumber = new JTextField();
        buttonGoToLogin = new JButton();
        buttonRegister = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[222,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
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
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Customer Register Page");
        contentPane.add(label1, "cell 6 1 3 2");

        //---- label3 ----
        label3.setText("Name");
        contentPane.add(label3, "cell 6 4");
        contentPane.add(textName, "cell 8 4");

        //---- label8 ----
        label8.setText("ID Number");
        contentPane.add(label8, "cell 6 5");
        contentPane.add(textID, "cell 8 5");

        //---- label2 ----
        label2.setText("User Name");
        contentPane.add(label2, "cell 6 6");
        contentPane.add(textUserName, "cell 8 6");

        //---- label4 ----
        label4.setText("Phone Number");
        contentPane.add(label4, "cell 6 7");
        contentPane.add(textPhoneNumber, "cell 8 7");

        //---- label5 ----
        label5.setText("Email");
        contentPane.add(label5, "cell 6 8");
        contentPane.add(textEmail, "cell 8 8");

        //---- label6 ----
        label6.setText("Address");
        contentPane.add(label6, "cell 6 9");
        contentPane.add(textAddress, "cell 8 9");

        //---- label10 ----
        label10.setText("Driver License Number");
        contentPane.add(label10, "cell 6 10");
        contentPane.add(textDriverLicenseNumber, "cell 8 10");

        //---- buttonGoToLogin ----
        buttonGoToLogin.setText("Go to Login");
        contentPane.add(buttonGoToLogin, "cell 6 12");

        //---- buttonRegister ----
        buttonRegister.setText("Register");
        contentPane.add(buttonRegister, "cell 8 12");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label3;
    private JTextField textName;
    private JLabel label8;
    private JTextField textID;
    private JLabel label2;
    private JTextField textUserName;
    private JLabel label4;
    private JTextField textPhoneNumber;
    private JLabel label5;
    private JTextField textEmail;
    private JLabel label6;
    private JTextField textAddress;
    private JLabel label10;
    private JTextField textDriverLicenseNumber;
    private JButton buttonGoToLogin;
    private JButton buttonRegister;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
