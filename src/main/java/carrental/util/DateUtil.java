package carrental.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 日期工具类：计算日期差、格式转换
 */
public class DateUtil {
    // 计算两个日期之间的天数（包含起始日）
    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("日期不能为空");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("结束日期不能早于开始日期");
        }
        return ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    // 字符串转LocalDate（格式：yyyy-MM-dd）
    public static LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("日期格式错误，正确格式：yyyy-MM-dd", e);
        }
    }
}