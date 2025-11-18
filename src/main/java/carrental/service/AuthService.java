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
            // 返回null让UI层处理错误消息
            return null;
        }

        System.out.println(TimestampUtil.getCurrentTimestamp() + " User [" + username + "] login successfully");
        return user;
    }

    public boolean register(User user) {
        // 检查用户名是否已存在（假设已有findByUsername方法，若无则需新增）
        if (userDAO.findByUsername(user.getUsername()) != null) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " Registration failed, username [" + user.getUsername() + "] already exists");
            return false;
        }
        
        boolean result = userDAO.register(user);
        if (result) {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " User [" + user.getUsername() + "] registered successfully");
        } else {
            System.out.println(TimestampUtil.getCurrentTimestamp() + " User [" + user.getUsername() + "] registration failed");
        }
        return result;
    }

    // 判断是否为管理员
    public boolean isAdmin(User user) {
        return user != null && user.getRole() == userRole.admin;
    }
}