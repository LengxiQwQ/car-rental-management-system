package carrental.ui;

import carrental.db.DBConnection;
import carrental.ui.Staff.*;
// import carrental.ui.Admin.*;
import carrental.ui.LoginRegister.*;


import com.formdev.flatlaf.FlatDarkLaf;

import carrental.util.TimestampUtil;
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

        // 检查数据库连接
        System.out.println(TimestampUtil.getCurrentTimestamp() + " Checking database connection...");
        if (!DBConnection.isConnectionSuccessful()) {
            System.err.println("Database connection failed! Please check database configuration and connection status.");
            System.exit(1);
            return;
        } else {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " Database connection successfully");
        }

        SwingUtilities.invokeLater(() -> {
            // ...  创建 UI 组件 ...

            // 创建并显示登录注册界面
            LoginRegisterFrame frame = new LoginRegisterFrame();
            frame.getCardPanel().setVisible(true);

            // 注释掉直接显示员工面板的代码，改为通过登录后显示
            // StaffDashboardFrame staff = new StaffDashboardFrame();
            // staff.getFreamRoot().setVisible(true);
        });




    }
}