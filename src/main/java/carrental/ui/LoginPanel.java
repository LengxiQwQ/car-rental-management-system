/*
 * Created by JFormDesigner on Mon Nov 17 22:32:30 SGT 2025
 */

package carrental.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LengxiQwQ
 */
public class LoginPanel extends JPanel {
    private MainFrame mainFrame;
    
    public LoginPanel() {
        initComponents();
    }

    private void goToRegister(ActionEvent e) {
        // 切换到注册面板
        if (mainFrame != null) {
            mainFrame.showRegisterPanel();
        }
    }
    
    // 添加设置MainFrame引用的方法
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textLoginPassword = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textLoginUserID = new JTextField();
        buttonLogin = new JButton();
        buttonGoToRegister = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Login");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 18));

        //---- label2 ----
        label2.setText("Password");

        //---- label3 ----
        label3.setText("User ID");

        //---- buttonLogin ----
        buttonLogin.setText("Login");

        //---- buttonGoToRegister ----
        buttonGoToRegister.setText("Go to Register");
        buttonGoToRegister.addActionListener(e -> goToRegister(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addGap(61, 61, 61))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonGoToRegister)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(textLoginPassword, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textLoginUserID, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(textLoginUserID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textLoginPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonGoToRegister)
                        .addComponent(buttonLogin))
                    .addGap(78, 78, 78))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textLoginPassword;
    private JLabel label2;
    private JLabel label3;
    private JTextField textLoginUserID;
    private JButton buttonLogin;
    private JButton buttonGoToRegister;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}