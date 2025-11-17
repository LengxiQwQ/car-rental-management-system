/*
 * Created by JFormDesigner on Mon Nov 17 22:32:30 SGT 2025
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
        label4 = new JLabel();
        comboBoxLoginRole = new JComboBox<>();
        label3 = new JLabel();
        textLoginUserID = new JTextField();
        label2 = new JLabel();
        textLoginPassword = new JTextField();
        buttonGoToRegister = new JButton();
        buttonLogin = new JButton();

        //======== this ========
        setLayout(new FormLayout(
            "9*(default, $lcgap), 16dlu, 3*($lcgap, default)",
            "3*(fill:default, $lgap), fill:default, $pgap, 5*(default, $lgap), default"));

        //---- label1 ----
        label1.setText("Login");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1, CC.xywh(1, 3, 24, 1));

        //---- label4 ----
        label4.setText("Role");
        add(label4, CC.xy(7, 7));

        //---- comboBoxLoginRole ----
        comboBoxLoginRole.setModel(new DefaultComboBoxModel<>(new String[] {
            "Staff",
            "Admin"
        }));
        add(comboBoxLoginRole, CC.xywh(13, 7, 7, 1));

        //---- label3 ----
        label3.setText("User ID");
        add(label3, CC.xy(7, 9));
        add(textLoginUserID, CC.xywh(11, 9, 9, 1));

        //---- label2 ----
        label2.setText("Password");
        add(label2, CC.xy(7, 11));
        add(textLoginPassword, CC.xywh(11, 11, 9, 1));

        //---- buttonGoToRegister ----
        buttonGoToRegister.setText("Go to Register");
        buttonGoToRegister.addActionListener(e -> goToRegister(e));
        add(buttonGoToRegister, CC.xywh(7, 15, 6, 1));

        //---- buttonLogin ----
        buttonLogin.setText("Login");
        add(buttonLogin, CC.xywh(15, 15, 5, 1));
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