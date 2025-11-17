package carrental.ui;

import carrental.ui.LoginRegister.LoginRegisterFrame;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // 启用暗色主题
        FlatDarkLaf.setup();

//        // 设置Swing界面风格
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        SwingUtilities.invokeLater(() -> {
            // ...  创建 UI 组件 ...
            // 创建并显示登录注册界面
            LoginRegisterFrame frame = new LoginRegisterFrame();
            frame.getCardPanel().setVisible(true);
        });




    }
}