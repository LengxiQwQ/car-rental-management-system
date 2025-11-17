/*
 * Created by JFormDesigner on Mon Nov 17 22:32:30 SGT 2025
 */

package carrental.ui.LoginRegister;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LengxiQwQ
 */
public class LoginPanel extends JPanel {
    private LoginRegisterFrame loginRegisterFrame;
    
    public LoginPanel() {
        initComponents();
    }

    private void goToRegister(ActionEvent e) {
        // 切换到注册面板
        if (loginRegisterFrame != null) {
            loginRegisterFrame.showRegisterPanel();
        }
    }
    
    // 添加设置MainFrame引用的方法
    public void setMainFrame(LoginRegisterFrame loginRegisterFrame) {
        this.loginRegisterFrame = loginRegisterFrame;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label4 = new JLabel();
        comboBoxLoginRole = new JComboBox<>();
        label3 = new JLabel();
        textLoginUserID = new JTextField();
        label2 = new JLabel();
        textLoginPassword = new JTextField();
        buttonGoToRegister = new JButton();
        buttonLogin = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Login");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label4 ----
        label4.setText("Role");

        //---- comboBoxLoginRole ----
        comboBoxLoginRole.setModel(new DefaultComboBoxModel<>(new String[] {
            "Staff",
            "Admin"
        }));

        //---- label3 ----
        label3.setText("User ID");

        //---- label2 ----
        label2.setText("Password");

        //---- buttonGoToRegister ----
        buttonGoToRegister.setText("Go to Register");
        buttonGoToRegister.addActionListener(e -> goToRegister(e));

        //---- buttonLogin ----
        buttonLogin.setText("Login");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addGap(59, 59, 59)
                                    .addComponent(comboBoxLoginRole, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(textLoginUserID, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(32, 32, 32)
                                    .addComponent(textLoginPassword, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonGoToRegister, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(buttonLogin, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(label1)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxLoginRole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label3))
                        .addComponent(textLoginUserID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label2))
                        .addComponent(textLoginPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(buttonGoToRegister)
                        .addComponent(buttonLogin))
                    .addContainerGap(51, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label4;
    private JComboBox<String> comboBoxLoginRole;
    private JLabel label3;
    private JTextField textLoginUserID;
    private JLabel label2;
    private JTextField textLoginPassword;
    private JButton buttonGoToRegister;
    private JButton buttonLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}