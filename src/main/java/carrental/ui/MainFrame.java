/*
 * Created by JFormDesigner on Mon Nov 17 22:45:16 SGT 2025
 */

package carrental.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import net.miginfocom.swing.*;

/**
 * @author LengxiQwQ
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
        // 设置面板间的引用关系，用于切换面板
        loginPanel1.setMainFrame(this);
        registerPanel1.setMainFrame(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        cardPanel = new JFrame();
        loginPanel1 = new LoginPanel();
        registerPanel1 = new RegisterPanel();

        //======== cardPanel ========
        {
            var cardPanelContentPane = cardPanel.getContentPane();
            cardPanelContentPane.setLayout(new CardLayout());
            cardPanelContentPane.add(loginPanel1, "card1");
            cardPanelContentPane.add(registerPanel1, "card2");
            cardPanel.pack();
            cardPanel.setLocationRelativeTo(cardPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame cardPanel;
    private LoginPanel loginPanel1;
    private RegisterPanel registerPanel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    
    // 添加显示登录面板的方法
    public void showLoginPanel() {
        ((CardLayout) cardPanel.getContentPane().getLayout()).show(cardPanel.getContentPane(), "card1");
    }
    
    // 添加显示注册面板的方法
    public void showRegisterPanel() {
        ((CardLayout) cardPanel.getContentPane().getLayout()).show(cardPanel.getContentPane(), "card2");
    }
    
    // 添加获取cardPanel的方法
    public JFrame getCardPanel() {
        return cardPanel;
    }
}