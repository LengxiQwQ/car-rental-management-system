package carrental.ui;

import carrental.ui.LoginRegister.LoginRegisterFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // 设置Swing界面风格
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 在事件调度线程中创建并显示界面
        SwingUtilities.invokeLater(() -> {
            LoginRegisterFrame frame = new LoginRegisterFrame();
            frame.getCardPanel().setVisible(true);
        });
    }
}