package carrental.service;

import carrental.dao.LogDAO;
import carrental.model.SystemLog;
import java.time.LocalDateTime;
import java.util.List;

public class LogService {
    private LogDAO logDAO = new LogDAO();

    // 记录日志（通用方法）
    public void recordLog(String username, String operationType, String details, boolean success) {
        SystemLog log = new SystemLog(
                username,
                operationType,
                details,
                success ? "Success" : "Failed"
        );
        logDAO.insert(log);
    }

    // 获取所有日志
    public List<SystemLog> getAllLogs() {
        return logDAO.getAllLogs();
    }

    // 按条件筛选日志
    public List<SystemLog> getLogsByFilter(String username, LocalDateTime startDate, LocalDateTime endDate) {
        return logDAO.getLogsByFilter(username, startDate, endDate);
    }
}