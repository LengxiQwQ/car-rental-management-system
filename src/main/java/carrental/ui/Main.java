package carrental.ui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {
    public static void main(String[] args) {
        // 设置FlatLaf外观
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
        
        SwingUtilities.invokeLater(() -> {
            // 显示登录表单
            new userLoginForm().setVisible(true);
        });
    }
}