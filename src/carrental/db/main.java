package carrental.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    // 1. 数据库连接参数（替换成你的信息！）
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // 你的MySQL用户名
    private static final String PASSWORD = "123456"; // 你的密码

    // 2. 获取数据库连接的方法
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 加载驱动（MySQL 8.0+用这个类名，旧版本是com.mysql.jdbc.Driver）
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("数据库连接成功！");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到MySQL驱动：" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("连接失败：" + e.getMessage()); // 常见原因：密码错、端口错、数据库名错
        }
        return conn;
    }

    // 3. 插入数据到studenttab表的方法
    public static void insertData(Information info) {
        Connection conn = getConnection();
        if (conn == null) return;

        String sql = "INSERT INTO student (name, age) VALUES (?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, info.getName());
            pstmt.setInt(2, info.getAge());
            pstmt.executeUpdate();
            System.out.println("数据插入成功！");
        } catch (SQLException e) {
            System.out.println("插入失败：" + e.getMessage());
        } finally {
            // 正确关闭资源
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // 4. 主方法（测试：控制台输入+插入数据）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 控制台输入Name和Age
        System.out.print("请输入姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入年龄：");
        int age = scanner.nextInt();

        // 调用插入方法
        insertData(new Information(name, age));
        scanner.close();
    }
}