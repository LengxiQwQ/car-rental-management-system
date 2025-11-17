/*
 * Created by JFormDesigner on Mon Nov 17 22:36:49 SGT 2025
 */

package carrental.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

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
        label4 = new JLabel();
        comboBoxRegisterRole = new JComboBox<>();
        label3 = new JLabel();
        textRegisterUserID = new JTextField();
        label2 = new JLabel();
        textRegisterPassword = new JTextField();
        buttonGoToLogin = new JButton();
        buttonRegister = new JButton();

        //======== this ========
        setLayout(new FormLayout(
            "11*(default, $lcgap), default",
            "3*(fill:default, $lgap), fill:default, $pgap, 4*(default, $lgap), default"));

        //---- label1 ----
        label1.setText("Register");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label1.setHorizontalTextPosition(SwingConstants.LEADING);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1, CC.xywh(1, 3, 23, 1));

        //---- label4 ----
        label4.setText("Role");
        add(label4, CC.xy(7, 7));

        //---- comboBoxRegisterRole ----
        comboBoxRegisterRole.setModel(new DefaultComboBoxModel<>(new String[] {
            "Staff",
            "Admin"
        }));
        add(comboBoxRegisterRole, CC.xywh(13, 7, 7, 1));

        //---- label3 ----
        label3.setText("User ID");
        add(label3, CC.xy(7, 9));
        add(textRegisterUserID, CC.xywh(11, 9, 9, 1));

        //---- label2 ----
        label2.setText("Password");
        add(label2, CC.xy(7, 11));
        add(textRegisterPassword, CC.xywh(11, 11, 9, 1));

        //---- buttonGoToLogin ----
        buttonGoToLogin.setText("Go to Login");
        buttonGoToLogin.addActionListener(e -> GoToLogin(e));
        add(buttonGoToLogin, CC.xywh(7, 15, 5, 1));

        //---- buttonRegister ----
        buttonRegister.setText("Register");
        add(buttonRegister, CC.xywh(15, 15, 5, 1));
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
}