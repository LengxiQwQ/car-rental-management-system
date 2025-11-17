package carrental.ui;

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
            MainFrame frame = new MainFrame();
            frame.getCardPanel().setVisible(true);
        });
    }
}