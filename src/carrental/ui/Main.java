package carrental.ui;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 显示登录表单
            new userLoginForm().setVisible(true);

            // 如果需要显示注册表单，可以取消下面这行的注释
            // new userRegisterForm().setVisible(true);
        });
    }
}