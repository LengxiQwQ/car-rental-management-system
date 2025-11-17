/*
 * Created by JFormDesigner on Mon Nov 17 22:36:49 SGT 2025
 */

package carrental.ui.LoginRegister;

import carrental.model.User;
import carrental.model.userRole;
import carrental.service.AuthService;

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
        textRegisterPassword = new JTextField();
        buttonGoToLogin = new JButton();
        buttonRegister = new JButton();

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

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(comboBoxRegisterRole, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(textRegisterUserID, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(32, 32, 32)
                            .addComponent(textRegisterPassword, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonGoToLogin, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(buttonRegister, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(label1)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxRegisterRole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label3))
                        .addComponent(textRegisterUserID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label2))
                        .addComponent(textRegisterPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(buttonGoToLogin)
                        .addComponent(buttonRegister))
                    .addContainerGap(51, Short.MAX_VALUE))
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
    private JTextField textRegisterPassword;
    private JButton buttonGoToLogin;
    private JButton buttonRegister;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    // 在类内部的末尾添加（不要放在类外面）
    private void addRegisterListener() {
        // 使用原有代码中的实际按钮变量名 buttonRegister
        buttonRegister.addActionListener(e -> {
            // 使用实际的组件变量名
            String role = (String) comboBoxRegisterRole.getSelectedItem(); // 正确变量名
            String username = textRegisterUserID.getText().trim(); // 正确变量名
            String password = textRegisterPassword.getText().trim(); // 正确变量名

            // 简单验证（如果没有Validator类，可先注释或替换为基础判断）
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "用户名或密码不能为空");
                return;
            }

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(userRole.valueOf(role.equals("admin") ? "admin" : "staff"));

            AuthService authService = new AuthService();
            if (authService.register(user)) {
                JOptionPane.showMessageDialog(this, "注册成功");
                GoToLogin(e); // 传递事件参数e，匹配原有方法定义
            } else {
                JOptionPane.showMessageDialog(this, "注册失败，用户名已存在");
            }
        });
    }
}
