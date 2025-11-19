/*
 * Created by JFormDesigner on Mon Nov 17 22:36:49 SGT 2025
 */

package carrental.ui.LoginRegister;

import carrental.model.User;
import carrental.model.userRole;
import carrental.service.AuthService;
import carrental.util.TimestampUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LengxiQwQ
 */
public class RegisterPanel extends JPanel {
    private LoginRegisterFrame loginRegisterFrame;
    
    public RegisterPanel() {
        initComponents();
        addRegisterListener();
    }

    private void GoToLogin(ActionEvent e) {
        // 切换到登录面板
        if (loginRegisterFrame != null) {
            loginRegisterFrame.showLoginPanel();
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
        comboBoxRegisterRole = new JComboBox<>();
        label3 = new JLabel();
        textRegisterUserID = new JTextField();
        label2 = new JLabel();
        buttonGoToLogin = new JButton();
        buttonRegister = new JButton();
        label5 = new JLabel();
        textRegisterPassword = new JPasswordField();
        textRegisterConfirm = new JPasswordField();

        //======== this ========

        //---- label1 ----
        label1.setText("Register");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label1.setHorizontalTextPosition(SwingConstants.LEADING);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label4 ----
        label4.setText("Role");

        //---- comboBoxRegisterRole ----
        comboBoxRegisterRole.setModel(new DefaultComboBoxModel<>(new String[] {
            "Staff",
            "Admin"
        }));

        //---- label3 ----
        label3.setText("User ID");

        //---- label2 ----
        label2.setText("Password");

        //---- buttonGoToLogin ----
        buttonGoToLogin.setText("Go to Login");
        buttonGoToLogin.addActionListener(e -> GoToLogin(e));

        //---- buttonRegister ----
        buttonRegister.setText("Register");
        buttonRegister.setForeground(new Color(0xaaaaaa));

        //---- label5 ----
        label5.setText("Confirm");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonGoToLogin, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(buttonRegister, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(label2)
                                    .addComponent(label5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(textRegisterPassword, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textRegisterConfirm, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(comboBoxRegisterRole, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(textRegisterUserID, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))))
                    .addGap(74, 74, 74))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(label1)
                    .addGap(33, 33, 33)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxRegisterRole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textRegisterUserID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textRegisterPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textRegisterConfirm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonGoToLogin)
                        .addComponent(buttonRegister))
                    .addContainerGap(38, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label4;
    private JComboBox<String> comboBoxRegisterRole;
    private JLabel label3;
    private JTextField textRegisterUserID;
    private JLabel label2;
    private JButton buttonGoToLogin;
    private JButton buttonRegister;
    private JLabel label5;
    private JPasswordField textRegisterPassword;
    private JPasswordField textRegisterConfirm;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    // 在类内部的末尾添加（不要放在类外面）
    private void addRegisterListener() {
        // 添加回车键监听器到确认密码输入框
        textRegisterConfirm.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performRegister();
                }
            }
        });
        
        // 使用原有代码中的实际按钮变量名 buttonRegister
        buttonRegister.addActionListener(e -> performRegister());
    }
    
    // 将注册逻辑提取到独立方法中
    private void performRegister() {
        // 使用实际的组件变量名
        String role = (String) comboBoxRegisterRole.getSelectedItem(); // 正确变量名
        String username = textRegisterUserID.getText().trim(); // 正确变量名
        String password = textRegisterPassword.getText().trim(); // 正确变量名
        String confirmPassword = textRegisterConfirm.getText().trim();
        // 简单验证（如果没有Validator类，可先注释或替换为基础判断）
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username or password cannot be empty");
            return;
        }
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match");
            return; // 终止注册
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        // 根据下拉框选择的角色（"Admin" 或 "Staff"）来设置用户角色
        user.setRole(userRole.valueOf(role.toLowerCase()));

        AuthService authService = new AuthService();
        if (authService.register(user)) {
            JOptionPane.showMessageDialog(this, "Registration successfully");
            // 切换到登录面板
            if (loginRegisterFrame != null) {
                loginRegisterFrame.showLoginPanel();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed, username already exists");
            System.out.println(TimestampUtil.getCurrentTimestamp() + " Registration failed, username [" + username + "] already exists");
        }
    }
}