package carrental.util;

/**
 * 输入校验工具类：验证用户名、手机号、邮箱等
 */
public class Validator {
    // 验证非空
    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // 验证手机号（简单校验：10-13位数字）
    public static boolean isValidPhone(String phone) {
        if (!isNotEmpty(phone)) return false;
        return phone.matches("\\d{10,13}");
    }

    // 验证邮箱（简单格式校验）
    public static boolean isValidEmail(String email) {
        if (!isNotEmpty(email)) return false;
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}