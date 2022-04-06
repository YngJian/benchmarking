package com.zhonglv.benchmarking.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author : Yang Jian
 * @date : 2021/7/12 0012 22:40
 */
@Slf4j
public class DateUtils {
    private DateUtils() {
    }
    /**
     * 开始时间结束时间是否合法
     *
     * @param patten    patten
     * @param startDate startDate
     * @param endDate   endDate
     * @return true合法 false不合法
     */
    public static boolean correctDateParam(String patten, String startDate, String endDate) {
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendPattern(patten).parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .toFormatter();
        LocalDate start = null;
        LocalDate end = null;
        try {
            if (StringUtils.isNotBlank(startDate)) {
                start = LocalDate.parse(startDate, dateTimeFormatter);
            }
            if (StringUtils.isNotBlank(endDate)) {
                end = LocalDate.parse(endDate, dateTimeFormatter);
            }
            if (start != null && end != null) {
                return start.isBefore(end) || start.equals(end);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * Date To Local Date time
     *
     * @param date date
     * @return LocalDate
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        //系统默认的时区
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * local Date time To Date
     *
     * @param localDateTime localDateTime
     * @return date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 获取间隔月份
     *
     * @param date     date
     * @param format   format
     * @param interval interval
     * @return date
     */
    public static String getIntervalMonthTime(LocalDate date, String format, Integer interval) {
        date = date.minusMonths(interval);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        return date.format(fmt);
    }
}
