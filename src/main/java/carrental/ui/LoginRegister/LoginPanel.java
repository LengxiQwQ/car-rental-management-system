/*
 * Created by JFormDesigner on Mon Nov 17 22:32:30 SGT 2025
 */

package carrental.ui.LoginRegister;

import carrental.model.User;
import carrental.service.AuthService;
import carrental.ui.Staff.StaffDashboardFrame;

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
        addLoginListener();
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
                    .addGap(81, 81, 81)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonLogin, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
                    .addGap(87, 87, Short.MAX_VALUE))
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonGoToRegister)
                        .addComponent(buttonLogin))
                    .addGap(40, 40, 40))
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
    // 在类内部的末尾添加（不要放在类外面）
    private void addLoginListener() {
        // 使用原有代码中的实际按钮变量名 buttonLogin
        buttonLogin.addActionListener(e -> {
            // 使用实际的组件变量名
            String role = (String) comboBoxLoginRole.getSelectedItem(); // 正确变量名：角色下拉框
            String username = textLoginUserID.getText().trim(); // 正确变量名：用户名输入框
            String password = textLoginPassword.getText().trim(); // 正确变量名：密码输入框

            // 验证输入是否为空
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请输入用户名和密码");
                return;
            }

            // 调用AuthService进行登录验证
            AuthService authService = new AuthService();
            User user = authService.login(username, password);

            if (user == null) {
                JOptionPane.showMessageDialog(this, "用户名或密码错误");
                return;
            }

            // 验证角色是否匹配
            // 正确的权限判断逻辑
// 1. 如果用户选择了 "Admin" 角色登录
            if ("Admin".equals(role)) {
                // 2. 检查该用户是否真的是管理员
                if (!authService.isAdmin(user)) {
                    JOptionPane.showMessageDialog(this, "无管理员权限，无法以管理员身份登录");
                    return;
                }
            }
// 如果选择的是 "Staff" 角色，则不需要额外检查，直接放行

            // 登录成功：关闭登录窗口，打开主面板
            JOptionPane.showMessageDialog(this, "登录成功");
            // 获取父窗口（LoginRegisterFrame）并关闭
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose();
            }
            // 打开对应的主面板（根据角色判断）
//           if (authService.isAdmin(user)) {
//                new AdminDashboardFrame().setVisible(true); // 管理员面板
//            } else {
//                new StaffDashboardFrame().setVisible(true); // 员工面板
//            }
            //new StaffDashboardFrame().setVisible(true); // 员工面板
        });
    }
}