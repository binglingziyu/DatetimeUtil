package cn.com.idriven.util.datetime

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date
import java.util.TimeZone

/**
 * 时间工具类
 * https://github.com/dromara/hutool/blob/v5-master/hutool-core/src/main/java/cn/hutool/core/date/DateUtil.java
 */
object DateUtil {

    fun date(): Date {
        return Date()
    }

    fun date(millis: Long): Date {
        return Date(millis)
    }

    fun date(calendar: Calendar): Date {
        return calendar.time
    }

    fun millis(date: Date): Long {
        return date.time
    }

    fun calendar(date: Date, timeZone: TimeZone = TimeZone.getDefault()): Calendar {
        return CalendarUtil.calendar(date, timeZone)
    }

    fun isAM(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isAM(date, timeZone)
    }

    fun isAM(millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isAM(millis, timeZone)
    }

    fun isPM(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isPM(date, timeZone)
    }

    fun isPM(millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isPM(millis, timeZone)
    }

    fun truncate(date: Date = Date(), dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.truncate(CalendarUtil.calendar(date, timeZone), dateField).time
    }

    fun truncate(date: Date = Date(), dateField: Int, timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.truncate(CalendarUtil.calendar(date, timeZone), dateField).time
    }

    fun round(date: Date = Date(), dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.round(CalendarUtil.calendar(date, timeZone), dateField).time
    }

    fun round(date: Date = Date(), dateField: Int, timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.round(CalendarUtil.calendar(date, timeZone), dateField).time
    }

    fun ceiling(date: Date = Date(), dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.ceiling(CalendarUtil.calendar(date, timeZone), dateField).time
    }

    fun ceiling(date: Date = Date(), dateField: Int, timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.ceiling(CalendarUtil.calendar(date, timeZone), dateField).time
    }

    fun ceiling(date: Date = Date(), dateField: DateField, truncateMillisecond: Boolean, timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.ceiling(CalendarUtil.calendar(date, timeZone), dateField, truncateMillisecond).time
    }

    fun ceiling(date: Date = Date(), dateField: Int, truncateMillisecond: Boolean, timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.ceiling(CalendarUtil.calendar(date, timeZone), dateField, truncateMillisecond).time
    }

    fun beginOfSecond(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.beginOfSecond(CalendarUtil.calendar(date, timeZone)).time
    }

    fun endOfSecond(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.endOfSecond(CalendarUtil.calendar(date, timeZone)).time
    }

    fun beginOfMinute(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.beginOfMinute(CalendarUtil.calendar(date, timeZone)).time
    }

    fun endOfMinute(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.endOfMinute(CalendarUtil.calendar(date, timeZone)).time
    }

    fun beginOfHour(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.beginOfHour(CalendarUtil.calendar(date, timeZone)).time
    }

    fun endOfHour(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.endOfHour(CalendarUtil.calendar(date, timeZone)).time
    }

    fun beginOfDay(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.beginOfDay(CalendarUtil.calendar(date, timeZone)).time
    }

    fun endOfDay(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.endOfDay(CalendarUtil.calendar(date, timeZone)).time
    }

    fun beginOfWeek(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault(), isMondayAsFirstDay: Boolean = true): Date {
        return CalendarUtil.beginOfWeek(CalendarUtil.calendar(date, timeZone), isMondayAsFirstDay).time
    }

    fun endOfWeek(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault(), isMondayAsFirstDay: Boolean = true): Date {
        return CalendarUtil.endOfWeek(CalendarUtil.calendar(date, timeZone), isMondayAsFirstDay).time
    }

    fun beginOfMonth(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.beginOfMonth(CalendarUtil.calendar(date, timeZone)).time
    }

    fun endOfMonth(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.endOfMonth(CalendarUtil.calendar(date, timeZone)).time
    }

    fun beginOfYear(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.beginOfYear(CalendarUtil.calendar(date, timeZone)).time
    }

    fun endOfYear(date: Date = Date(), timeZone: TimeZone = TimeZone.getDefault()): Date {
        return CalendarUtil.endOfYear(CalendarUtil.calendar(date, timeZone)).time
    }

    fun isSameMillis(date1: Date, date2: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameMillis(CalendarUtil.calendar(date1, timeZone), CalendarUtil.calendar(date2, timeZone))
    }
    fun isSameMillis(date: Date, calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameMillis(CalendarUtil.calendar(date, timeZone), calendar)
    }
    fun isSameMillis(date: Date, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameMillis(CalendarUtil.calendar(date, timeZone), CalendarUtil.calendar(millis, timeZone))
    }

    fun isSameSecond(date1: Date, date2: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameSecond(CalendarUtil.calendar(date1, timeZone), CalendarUtil.calendar(date2, timeZone))
    }
    fun isSameSecond(date: Date, calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameSecond(CalendarUtil.calendar(date, timeZone), calendar)
    }
    fun isSameSecond(date: Date, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameSecond(CalendarUtil.calendar(date, timeZone), CalendarUtil.calendar(millis, timeZone))
    }

    fun isSameMinute(date1: Date, date2: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameMinute(CalendarUtil.calendar(date1, timeZone), CalendarUtil.calendar(date2, timeZone))
    }
    fun isSameMinute(date: Date, calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameMinute(CalendarUtil.calendar(date, timeZone), calendar)
    }
    fun isSameMinute(date: Date, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameMinute(CalendarUtil.calendar(date, timeZone), CalendarUtil.calendar(millis, timeZone))
    }

    fun isSameHour(date1: Date, date2: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameHour(CalendarUtil.calendar(date1, timeZone), CalendarUtil.calendar(date2, timeZone))
    }
    fun isSameHour(date: Date, calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameHour(CalendarUtil.calendar(date, timeZone), calendar)
    }
    fun isSameHour(date: Date, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameHour(CalendarUtil.calendar(date, timeZone), CalendarUtil.calendar(millis, timeZone))
    }

    fun isSameDay(date1: Date, date2: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameDay(CalendarUtil.calendar(date1, timeZone), CalendarUtil.calendar(date2, timeZone))
    }
    fun isSameDay(date: Date, calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameDay(CalendarUtil.calendar(date, timeZone), calendar)
    }
    fun isSameDay(date: Date, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameDay(CalendarUtil.calendar(date, timeZone), CalendarUtil.calendar(millis, timeZone))
    }

    fun isSameWeek(date1: Date, date2: Date, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true): Boolean {
        return CalendarUtil.isSameWeek(CalendarUtil.calendar(date1, timeZone), CalendarUtil.calendar(date2, timeZone), isMon)
    }
    fun isSameWeek(date: Date, calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true): Boolean {
        return CalendarUtil.isSameWeek(CalendarUtil.calendar(date, timeZone), calendar, isMon)
    }
    fun isSameWeek(date: Date, millis: Long, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true): Boolean {
        return CalendarUtil.isSameWeek(CalendarUtil.calendar(date, timeZone), CalendarUtil.calendar(millis, timeZone), isMon)
    }

    fun isSameMonth(date1: Date, date2: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameMonth(CalendarUtil.calendar(date1, timeZone), CalendarUtil.calendar(date2, timeZone))
    }
    fun isSameMonth(date: Date, calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameMonth(CalendarUtil.calendar(date, timeZone), calendar)
    }
    fun isSameMonth(date: Date, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameMonth(CalendarUtil.calendar(date, timeZone), CalendarUtil.calendar(millis, timeZone))
    }

    fun isSameYear(date1: Date, date2: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameYear(CalendarUtil.calendar(date1, timeZone), CalendarUtil.calendar(date2, timeZone))
    }
    fun isSameYear(date: Date, calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameYear(CalendarUtil.calendar(date, timeZone), calendar)
    }
    fun isSameYear(date: Date, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return CalendarUtil.isSameYear(CalendarUtil.calendar(date, timeZone), CalendarUtil.calendar(millis, timeZone))
    }

    fun getBeginValue(date: Date, dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.getBeginValue(CalendarUtil.calendar(date, timeZone), dateField)
    }

    fun getBeginValue(date: Date, dateField: Int, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.getBeginValue(CalendarUtil.calendar(date, timeZone), dateField)
    }

    fun getEndValue(date: Date, dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.getEndValue(CalendarUtil.calendar(date, timeZone), dateField)
    }

    fun getEndValue(date: Date, dateField: Int, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.getEndValue(CalendarUtil.calendar(date, timeZone), dateField)
    }

    fun compare(date1: Date, date2: Date, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.compare(CalendarUtil.calendar(date1, timeZone), date2, timeZone)
    }
    fun compare(date: Date, calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.compare(CalendarUtil.calendar(date, timeZone), calendar)
    }
    fun compare(date: Date, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.compare(CalendarUtil.calendar(date, timeZone), millis, timeZone)
    }

    fun age(birthday: Date, dateToCompare: Date, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.age(CalendarUtil.calendar(birthday, timeZone), CalendarUtil.calendar(dateToCompare, timeZone))
    }
    fun age(birthday: Date, dateToCompare: Calendar, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.age(CalendarUtil.calendar(birthday, timeZone), dateToCompare)
    }
    fun age(birthday: Date, dateToCompare: Long, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return CalendarUtil.age(CalendarUtil.calendar(birthday, timeZone), CalendarUtil.calendar(dateToCompare, timeZone))
    }

}