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
        User user = userDAO.login(username, password);
        if (user == null) {
            throw new RuntimeException("用户名或密码错误"); // 合并错误信息，避免泄露用户存在性
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