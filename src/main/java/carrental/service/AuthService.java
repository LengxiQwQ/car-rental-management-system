package carrental.service;

import carrental.dao.UserDAO;
import carrental.model.User;
import carrental.model.userRole;
import carrental.util.Validator;
import carrental.util.TimestampUtil;

/**
 * 认证服务：明文密码登录验证
 */
public class AuthService {
    private final UserDAO userDAO = new UserDAO();
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
            logService.recordLog(username, "登录", "用户登录失败，用户名或密码错误", false);
            // 返回null让UI层处理错误消息
            return null;
        }

        System.out.println(TimestampUtil.getCurrentTimestamp() + " User [" + username + "] login successfully");

        // 记录系统日志
        logService.recordLog(username, "登录", "用户登录成功", true);

        return user;
    }

    public boolean register(User user) {
        // 检查用户名是否已存在（假设已有findByUsername方法，若无则需新增）
        if (userDAO.findByUsername(user.getUsername()) != null) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " Registration failed, username [" + user.getUsername() + "] already exists");
            // 记录系统日志
            logService.recordLog(user.getUsername(), "注册", "用户注册失败，用户名已存在", false);
            return false;
        }
        
        boolean result = userDAO.register(user);
        if (result) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " User [" + user.getUsername() + "] registered successfully");
            // 记录系统日志
            logService.recordLog(user.getUsername(), "注册", "用户注册成功", true);
        } else {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " User [" + user.getUsername() + "] registration failed");
            // 记录系统日志
            logService.recordLog(user.getUsername(), "注册", "用户注册失败", false);
        }
        return result;
    }

    // 判断是否为管理员
    public boolean isAdmin(User user) {
        return user != null && user.getRole() == userRole.admin;
    }
}