package carrental.service;

import carrental.dao.UserDAO;
import carrental.model.User;
import carrental.model.userRole;
import carrental.util.Validator;
import carrental.util.TimestampUtil;

/**
 * 认证服务：明文密码登录验证
 * 该类提供了用户认证相关的功能，包括登录、注册和管理员权限验证
 */
public class AuthService {
    // 用户数据访问对象，用于与数据库交互
    private final UserDAO userDAO = new UserDAO();
    // 日志服务对象，用于记录系统操作日志
    private final LogService logService = new LogService();

    // 登录验证（明文直接对比）
    public User login(String username, String password) {
        // 输入校验
        if (!Validator.isNotEmpty(username) || !Validator.isNotEmpty(password)) {
            // 不抛出异常，而是返回null让UI层处理
            return null;
        }

        // 查询用户
        User user = userDAO.login(username, password);
        if (user == null) {
            // 记录系统日志
            logService.recordLog(username, "Login", "User login failed, incorrect username or password", false);
            // 返回null让UI层处理错误消息
            return null;
        }

        System.out.println(TimestampUtil.getCurrentTimestamp() + " User [" + username + "] login successfully");

        // 记录系统日志
        logService.recordLog(username, "Login", "User login successful", true);

        return user;
    }

    public boolean register(User user) {
        // 检查用户名是否已存在（假设已有findByUsername方法，若无则需新增）
        if (userDAO.findByUsername(user.getUsername()) != null) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " Registration failed, username [" + user.getUsername() + "] already exists");
            // 记录系统日志
            logService.recordLog(user.getUsername(), "Register", "User registration failed, username already exists", false);
            return false;
        }
        
        boolean result = userDAO.register(user);
        if (result) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " User [" + user.getUsername() + "] registered successfully");
            // 记录系统日志
            logService.recordLog(user.getUsername(), "Register", "User registration successful", true);
        } else {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " User [" + user.getUsername() + "] registration failed");
            // 记录系统日志
            logService.recordLog(user.getUsername(), "Register", "User registration failed", false);
        }
        return result;
    }

    // 判断是否为管理员
    public boolean isAdmin(User user) {
        return user != null && user.getRole() == userRole.admin;
    }
}