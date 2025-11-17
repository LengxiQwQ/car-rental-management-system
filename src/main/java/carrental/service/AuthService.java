package carrental.service;

import carrental.dao.UserDAO;
import carrental.model.User;
import carrental.model.userRole;
import carrental.util.Validator;

/**
 * 认证服务：明文密码登录验证
 */
public class AuthService {
    private final UserDAO userDAO = new UserDAO();

    // 登录验证（明文直接对比）
    public User login(String username, String password) {
        // 输入校验
        if (!Validator.isNotEmpty(username) || !Validator.isNotEmpty(password)) {
            throw new IllegalArgumentException("用户名和密码不能为空");
        }

        // 查询用户
        User user = userDAO.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("用户名不存在");
        }

        // 明文密码对比（无加密）
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        System.out.println("用户[" + username + "]登录成功");
        return user;
    }

    public boolean register(User user) {
        // 检查用户名是否已存在（假设已有findByUsername方法，若无则需新增）
        if (userDAO.findByUsername(user.getUsername()) != null) {
            return false;
        }
        return userDAO.register(user);
    }

    // 判断是否为管理员
    public boolean isAdmin(User user) {
        return user != null && user.getRole() == userRole.admin;
    }
}