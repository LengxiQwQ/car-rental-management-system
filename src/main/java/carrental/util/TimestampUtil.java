package carrental.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间戳工具类，用于在控制台输出前添加时间戳
 */
public class TimestampUtil {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 获取当前时间的时间戳，格式为 [HH:mm:ss]
     *
     * @return 格式化后的时间戳字符串
     */
    public static String getCurrentTimestamp() {
        return "[" + LocalTime.now().format(TIME_FORMATTER) + "]";
    }
}