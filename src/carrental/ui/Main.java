package carrental.ui;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 显示客户注册表单
            new CustomerRegisterForm().setVisible(true);
            
            // 如果需要显示登录表单，可以取消下面这行的注释
            // new CustomerLoginForm().setVisible(true);
        });
    }
}