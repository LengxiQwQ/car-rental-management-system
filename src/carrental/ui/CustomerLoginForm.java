/*
 * Created by JFormDesigner on Sun Nov 16 18:23:17 SGT 2025
 */

package carrental.ui;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author LengxiQwQ
 */
public class CustomerLoginForm extends JFrame {
    public CustomerLoginForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        this2 = new JFrame();
        label1 = new JLabel();
        label8 = new JLabel();
        textCustomerID = new JTextField();
        label2 = new JLabel();
        textPassword = new JTextField();
        buttonGoToLogin = new JButton();
        buttonRegister = new JButton();
        comboBox1 = new JComboBox();

        //======== this2 ========
        {
            var this2ContentPane = this2.getContentPane();
            this2ContentPane.setLayout(new MigLayout(
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
            label1.setText("Customer Login Page");
            this2ContentPane.add(label1, "cell 6 1 3 2");

            //---- label8 ----
            label8.setText("Customer ID");
            this2ContentPane.add(label8, "cell 6 4");
            this2ContentPane.add(textCustomerID, "cell 8 4");

            //---- label2 ----
            label2.setText("Password");
            this2ContentPane.add(label2, "cell 6 5");
            this2ContentPane.add(textPassword, "cell 8 5");

            //---- buttonGoToLogin ----
            buttonGoToLogin.setText("Go to Login");
            this2ContentPane.add(buttonGoToLogin, "cell 6 7");

            //---- buttonRegister ----
            buttonRegister.setText("Login");
            this2ContentPane.add(buttonRegister, "cell 8 7");
            this2ContentPane.add(comboBox1, "cell 8 9");
            this2.pack();
            this2.setLocationRelativeTo(this2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame this2;
    private JLabel label1;
    private JLabel label8;
    private JTextField textCustomerID;
    private JLabel label2;
    private JTextField textPassword;
    private JButton buttonGoToLogin;
    private JButton buttonRegister;
    private JComboBox comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
