package carrental.model;

import java.time.LocalDateTime;

public class SystemLog {
    private int logId;
    private String username;
    private String operationType;
    private String operationDetails;
    private LocalDateTime operationTime;
    private String ipAddress;
    private String result;

    // 构造方法
    public SystemLog(String username, String operationType, String operationDetails,
                     String ipAddress, String result) {
        this.username = username;
        this.operationType = operationType;
        this.operationDetails = operationDetails;
        this.operationTime = LocalDateTime.now();
        this.ipAddress = ipAddress;
        this.result = result;
    }

    // Getter和Setter
    public int getLogId() {
        return logId;
    }
    public void setLogId(int logId) {
        this.logId = logId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    public String getOperationDetails() {
        return operationDetails;
    }
    public void setOperationDetails(String operationDetails) {
        this.operationDetails = operationDetails;
    }
    public LocalDateTime getOperationTime() {
        return operationTime;
    }
    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
