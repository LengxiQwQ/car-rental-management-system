/*
 * Created by JFormDesigner on Mon Nov 17 22:36:49 SGT 2025
 */

package carrental.ui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LengxiQwQ
 */
public class RegisterPanel extends JPanel {
    private MainFrame mainFrame;
    
    public RegisterPanel() {
        initComponents();
    }

    private void GoToLogin(ActionEvent e) {
        // 切换到登录面板
        if (mainFrame != null) {
            mainFrame.showLoginPanel();
        }
    }
    
    // 添加设置MainFrame引用的方法
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textRegisterPassword = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textRegisterUserID = new JTextField();
        buttonRegister = new JButton();
        buttonGoToLogin = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Register");

        //---- label2 ----
        label2.setText("Password");

        //---- label3 ----
        label3.setText("User ID");

        //---- buttonRegister ----
        buttonRegister.setText("Register");

        //---- buttonGoToLogin ----
        buttonGoToLogin.setText("Go to Login");
        buttonGoToLogin.addActionListener(e -> GoToLogin(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonGoToLogin)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonRegister))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(textRegisterPassword, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textRegisterUserID, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(textRegisterUserID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textRegisterPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonGoToLogin)
                        .addComponent(buttonRegister))
                    .addContainerGap(70, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textRegisterPassword;
    private JLabel label2;
    private JLabel label3;
    private JTextField textRegisterUserID;
    private JButton buttonRegister;
    private JButton buttonGoToLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}