package cn.com.idriven.util.datetime

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date
import java.util.TimeZone

/**
 *
 * 针对 {@link Calendar} 对象封装工具类
 * https://github.com/dromara/hutool/blob/v5-master/hutool-core/src/main/java/cn/hutool/core/date/CalendarUtil.java
 */
object CalendarUtil {

    /**
     * 创建 Calendar 对象
     * @param timeZone 时区，默认 TimeZone.getDefault()
     * @return Calendar对象
     */
    fun calendar(timeZone: TimeZone = TimeZone.getDefault()): Calendar {
        return Calendar.getInstance(timeZone)
    }

    /**
     * Date 转换为 Calendar 对象
     * @param date 日期对象
     * @param timeZone 时区，默认 TimeZone.getDefault()
     * @return Calendar 对象
     */
    fun calendar(date: Date, timeZone: TimeZone = TimeZone.getDefault()): Calendar {
        return calendar(date.time, timeZone)
    }

    /**
     * 时间戳转换为 Calendar 对象
     * @param millis 时间戳
     * @param timeZone 时区，默认 TimeZone.getDefault()
     * @return Calendar 对象
     */
    fun calendar(millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Calendar {
        return Calendar.getInstance(timeZone).apply {
            timeInMillis = millis
        }
    }

    fun date(calendar: Calendar): Date {
        return calendar.time
    }

    fun millis(calendar: Calendar): Long {
        return calendar.timeInMillis
    }

    /**
     * 当前是否为上午
     * @param timeZone 时区，默认 TimeZone.getDefault()
     * @return 是否为上午
     */
    fun isAM(timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isAM(calendar(timeZone))
    }

    /**
     * Date 是否为上午
     * @param timeZone 时区，默认 TimeZone.getDefault()
     * @return 是否为上午
     */
    fun isAM(date: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isAM(calendar(date, timeZone))
    }

    /**
     * 时间戳是否为上午
     * @param timeZone 时区，默认 TimeZone.getDefault()
     * @return 是否为上午
     */
    fun isAM(millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isAM(calendar(millis, timeZone))
    }

    /**
     * 是否为上午
     * @param calendar {@link Calendar}
     * @return 是否为上午
     */
    fun isAM(calendar: Calendar): Boolean {
        return Calendar.AM == calendar.get(Calendar.AM_PM)
    }

    /**
     * 当前是否为下午
     * @param timeZone 时区，默认 TimeZone.getDefault()
     * @return 是否为下午
     */
    fun isPM(timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isPM(calendar(timeZone))
    }

    /**
     * Date 是否为下午
     * @param timeZone 时区，默认 TimeZone.getDefault()
     * @return 是否为下午
     */
    fun isPM(date: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isPM(calendar(date, timeZone))
    }

    /**
     * 时间戳是否为下午
     * @param timeZone 时区，默认 TimeZone.getDefault()
     * @return 是否为下午
     */
    fun isPM(millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isPM(calendar(millis, timeZone))
    }

    /**
     * 是否为下午
     * @param calendar {@link Calendar}
     * @return 是否为下午
     */
    fun isPM(calendar: Calendar): Boolean {
        return Calendar.PM == calendar.get(Calendar.AM_PM)
    }

    /**
     * 修改日期为某个时间字段起始时间
     * @param calendar  [Calendar]
     * @param dateField 保留到的时间字段，如定义为 [DateField.SECOND]，表示这个字段不变，这个字段以下字段全部归0
     * @return 原{@link Calendar}
     */
    fun truncate(calendar: Calendar, dateField: DateField): Calendar {
        return DateModifier.modify(calendar, dateField.value, DateModifier.ModifyType.TRUNCATE)
    }
    fun truncate(calendar: Calendar, dateField: Int): Calendar {
        return DateModifier.modify(calendar, dateField, DateModifier.ModifyType.TRUNCATE)
    }

    /**
     * 修改日期为某个时间字段四舍五入时间
     * @param calendar  [Calendar]
     * @param dateField 时间字段
     * @return 原{@link Calendar}
     */
    fun round(calendar: Calendar, dateField: DateField): Calendar {
        return DateModifier.modify(calendar, dateField.value, DateModifier.ModifyType.ROUND)
    }
    fun round(calendar: Calendar, dateField: Int): Calendar {
        return DateModifier.modify(calendar, dateField, DateModifier.ModifyType.ROUND)
    }

    /**
     * 修改日期为某个时间字段结束时间
     * @param calendar  [Calendar]
     * @param dateField 保留到的时间字段，如定义为 [DateField.SECOND]，表示这个字段不变，这个字段以下字段全部取最大值
     * @return 原{@link Calendar}
     */
    fun ceiling(calendar: Calendar, dateField: DateField): Calendar {
        return DateModifier.modify(calendar, dateField.value, DateModifier.ModifyType.CEILING)
    }
    fun ceiling(calendar: Calendar, dateField: Int): Calendar {
        return DateModifier.modify(calendar, dateField, DateModifier.ModifyType.CEILING)
    }

    /**
     * 修改日期为某个时间字段结束时间<br></br>
     * 可选是否归零毫秒。
     * 有时候由于毫秒部分必须为0（如MySQL数据库中），因此在此加上选项。
     * @param calendar            [Calendar]
     * @param dateField           时间字段
     * @param truncateMillisecond 是否毫秒归零
     * @return 原{@link Calendar}
     */
    fun ceiling(calendar: Calendar, dateField: DateField, truncateMillisecond: Boolean): Calendar {
        return DateModifier.modify(calendar, dateField.value, DateModifier.ModifyType.CEILING, truncateMillisecond)
    }
    fun ceiling(calendar: Calendar, dateField: Int, truncateMillisecond: Boolean): Calendar {
        return DateModifier.modify(calendar, dateField, DateModifier.ModifyType.CEILING, truncateMillisecond)
    }

    /**
     * 修改秒级别的开始时间，即忽略毫秒部分
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun beginOfSecond(calendar: Calendar): Calendar {
        return truncate(calendar, DateField.SECOND)
    }

    /**
     * 修改秒级别的结束时间，即毫秒设置为999
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun endOfSecond(calendar: Calendar): Calendar {
        return ceiling(calendar, DateField.SECOND)
    }

    /**
     * 修改某分钟的开始时间
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun beginOfMinute(calendar: Calendar): Calendar {
        return truncate(calendar, DateField.MINUTE)
    }

    /**
     * 修改某分钟的结束时间
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun endOfMinute(calendar: Calendar): Calendar {
        return ceiling(calendar, DateField.MINUTE)
    }


    /**
     * 修改某小时的开始时间
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun beginOfHour(calendar: Calendar): Calendar {
        return truncate(calendar, DateField.HOUR_OF_DAY)
    }

    /**
     * 修改某小时的结束时间
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun endOfHour(calendar: Calendar): Calendar {
        return ceiling(calendar, DateField.HOUR_OF_DAY)
    }

    /**
     * 修改某天的开始时间
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun beginOfDay(calendar: Calendar): Calendar {
        return truncate(calendar, DateField.DAY_OF_MONTH)
    }

    /**
     * 修改某天的结束时间
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun endOfDay(calendar: Calendar): Calendar {
        return ceiling(calendar, DateField.DAY_OF_MONTH)
    }

    /**
     * 修改给定日期当前周的开始时间
     * @param calendar           日期 [Calendar]
     * @param isMondayAsFirstDay 是否周一做为一周的第一天（false表示周日做为第一天）
     * @return [Calendar]
     */
    fun beginOfWeek(calendar: Calendar, isMondayAsFirstDay: Boolean = true): Calendar {
        calendar.firstDayOfWeek = if (isMondayAsFirstDay) Calendar.MONDAY else Calendar.SUNDAY
        // WEEK_OF_MONTH为上限的字段（不包括），实际调整的为DAY_OF_MONTH
        return truncate(calendar, DateField.WEEK_OF_MONTH)
    }

    /**
     * 修改某周的结束时间
     * @param calendar          日期 [Calendar]
     * @param isSundayAsLastDay 是否周日做为一周的最后一天（false表示周六做为最后一天）
     * @return [Calendar]
     */
    fun endOfWeek(calendar: Calendar, isSundayAsLastDay: Boolean = true): Calendar {
        calendar.firstDayOfWeek = if (isSundayAsLastDay) Calendar.MONDAY else Calendar.SUNDAY
        // WEEK_OF_MONTH为上限的字段（不包括），实际调整的为DAY_OF_MONTH
        return ceiling(calendar, DateField.WEEK_OF_MONTH)
    }

    /**
     * 修改某月的开始时间
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun beginOfMonth(calendar: Calendar): Calendar {
        return truncate(calendar, DateField.MONTH)
    }

    /**
     * 修改某月的结束时间
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun endOfMonth(calendar: Calendar): Calendar {
        return ceiling(calendar, DateField.MONTH)
    }

    /**
     * 修改某年的开始时间
     *
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun beginOfYear(calendar: Calendar): Calendar {
        return truncate(calendar, DateField.YEAR)
    }

    /**
     * 修改某年的结束时间
     *
     * @param calendar 日期 [Calendar]
     * @return [Calendar]
     */
    fun endOfYear(calendar: Calendar): Calendar {
        return ceiling(calendar, DateField.YEAR)
    }

    /**
     * 检查两个 Calendar 时间戳是否相同。
     * 此方法检查两个 Calendar 的毫秒数时间戳是否相同。
     * @param date1 时间1
     * @param date2 时间2
     * @return 两个Calendar时间戳是否相同。如果两个时间都为`null`返回true，否则有`null`返回false
     */
    fun isSameMillis(date1: Calendar, date2: Calendar): Boolean {
        return date1.timeInMillis == date2.timeInMillis
    }
    fun isSameMillis(calendar: Calendar, date: Date): Boolean {
        return calendar.timeInMillis == date.time
    }
    fun isSameMillis(calendar: Calendar, millis: Long): Boolean {
        return calendar.timeInMillis == millis
    }

    /**
     * 比较两个日期是否为同一秒
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 是否为同一秒
     */
    fun isSameSecond(cal1: Calendar, cal2: Calendar): Boolean {
        return cal1[Calendar.SECOND] == cal2[Calendar.SECOND]
            && cal1[Calendar.MINUTE] == cal2[Calendar.MINUTE]
            && cal1[Calendar.HOUR_OF_DAY] == cal2[Calendar.HOUR_OF_DAY]
            && cal1[Calendar.DAY_OF_YEAR] == cal2[Calendar.DAY_OF_YEAR]
            && cal1[Calendar.YEAR] == cal2[Calendar.YEAR]
            && cal1[Calendar.ERA] == cal2[Calendar.ERA]
    }
    fun isSameSecond(calendar: Calendar, date: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameSecond(calendar, calendar(date, timeZone))
    }
    fun isSameSecond(calendar: Calendar, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameSecond(calendar, calendar(millis, timeZone))
    }


    /**
     * 比较两个日期是否为同一分钟
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 是否为同一分钟
     */
    fun isSameMinute(cal1: Calendar, cal2: Calendar): Boolean {
        return cal1[Calendar.MINUTE] == cal2[Calendar.MINUTE]
            && cal1[Calendar.HOUR_OF_DAY] == cal2[Calendar.HOUR_OF_DAY]
            && cal1[Calendar.DAY_OF_YEAR] == cal2[Calendar.DAY_OF_YEAR]
            && cal1[Calendar.YEAR] == cal2[Calendar.YEAR]
            && cal1[Calendar.ERA] == cal2[Calendar.ERA]
    }
    fun isSameMinute(calendar: Calendar, date: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameMinute(calendar, calendar(date, timeZone))
    }
    fun isSameMinute(calendar: Calendar, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameMinute(calendar, calendar(millis, timeZone))
    }

    /**
     * 比较两个日期是否为同一小时
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 是否为同一小时
     */
    fun isSameHour(cal1: Calendar, cal2: Calendar): Boolean {
        return cal1[Calendar.HOUR_OF_DAY] == cal2[Calendar.HOUR_OF_DAY]
            && cal1[Calendar.DAY_OF_YEAR] == cal2[Calendar.DAY_OF_YEAR]
            && cal1[Calendar.YEAR] == cal2[Calendar.YEAR]
            && cal1[Calendar.ERA] == cal2[Calendar.ERA]
    }
    fun isSameHour(calendar: Calendar, date: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameHour(calendar, calendar(date, timeZone))
    }
    fun isSameHour(calendar: Calendar, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameHour(calendar, calendar(millis, timeZone))
    }

    /**
     * 比较两个日期是否为同一天
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 是否为同一天
     */
    fun isSameDay(cal1: Calendar, cal2: Calendar): Boolean {
        return cal1[Calendar.DAY_OF_YEAR] == cal2[Calendar.DAY_OF_YEAR]
            && cal1[Calendar.YEAR] == cal2[Calendar.YEAR]
            && cal1[Calendar.ERA] == cal2[Calendar.ERA]
    }
    fun isSameDay(calendar: Calendar, date: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameDay(calendar, calendar(date, timeZone))
    }
    fun isSameDay(calendar: Calendar, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameDay(calendar, calendar(millis, timeZone))
    }

    /**
     * 比较两个日期是否为同一周
     * @param cal1 日期1
     * @param cal2 日期2
     * @param isMon 是否为周一。国内第一天为星期一，国外第一天为星期日
     * @return 是否为同一周
     */
    fun isSameWeek(cal1: Calendar, cal2: Calendar, isMon: Boolean = true): Boolean {
        var mCal1 = cal1
        var mCal2 = cal2
        // 防止比较前修改原始Calendar对象
        mCal1 = mCal1.clone() as Calendar
        mCal2 = mCal2.clone() as Calendar
        // 把所传日期设置为其当前周的第一天
        // 比较设置后的两个日期是否是同一天：true 代表同一周
        if (isMon) {
            mCal1.firstDayOfWeek = Calendar.MONDAY
            mCal1[Calendar.DAY_OF_WEEK] = Calendar.MONDAY
            mCal2.firstDayOfWeek = Calendar.MONDAY
            mCal2[Calendar.DAY_OF_WEEK] = Calendar.MONDAY
        } else {
            mCal1.firstDayOfWeek = Calendar.SUNDAY
            mCal1[Calendar.DAY_OF_WEEK] = Calendar.SUNDAY
            mCal2.firstDayOfWeek = Calendar.SUNDAY
            mCal2[Calendar.DAY_OF_WEEK] = Calendar.SUNDAY
        }
        return isSameDay(mCal1, mCal2)
    }
    fun isSameWeek(calendar: Calendar, date: Date, isMon: Boolean = true, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameWeek(calendar, calendar(date, timeZone), isMon)
    }
    fun isSameWeek(calendar: Calendar, millis: Long, isMon: Boolean = true, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameWeek(calendar, calendar(millis, timeZone), isMon)
    }

    /**
     * 比较两个日期是否为同一月<br></br>
     * 同一个月的意思是：ERA（公元）、year（年）、month（月）都一致。
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 是否为同一月
     */
    fun isSameMonth(cal1: Calendar, cal2: Calendar): Boolean {
        return cal1[Calendar.YEAR] == cal2[Calendar.YEAR]
            && cal1[Calendar.MONTH] == cal2[Calendar.MONTH]
            && cal1[Calendar.ERA] == cal2[Calendar.ERA]
    }
    fun isSameMonth(calendar: Calendar, date: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameMonth(calendar, calendar(date, timeZone))
    }
    fun isSameMonth(calendar: Calendar, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameMonth(calendar, calendar(millis, timeZone))
    }

    /**
     * 比较两个日期是否为同一年<br></br>
     * 同一个年的意思是：ERA（公元）、year（年）都一致。
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 是否为同一年
     */
    fun isSameYear(cal1: Calendar, cal2: Calendar): Boolean {
        return cal1[Calendar.YEAR] == cal2[Calendar.YEAR]
            && cal1[Calendar.ERA] == cal2[Calendar.ERA]
    }
    fun isSameYear(calendar: Calendar, date: Date, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameYear(calendar, calendar(date, timeZone))
    }
    fun isSameYear(calendar: Calendar, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Boolean {
        return isSameYear(calendar, calendar(millis, timeZone))
    }

    /**
     * 获取指定日期字段的最小值，例如分钟的最小值是0
     * @param calendar  [Calendar]
     * @param dateField [DateField]
     * @return 字段最小值
     * @see Calendar.getActualMinimum
     */
    fun getBeginValue(calendar: Calendar, dateField: DateField): Int {
        return getBeginValue(calendar, dateField.value)
    }

    /**
     * 获取指定日期字段的最小值，例如分钟的最小值是0
     * @param calendar  [Calendar]
     * @param dateField [DateField]
     * @return 字段最小值
     * @see Calendar.getActualMinimum
     */
    fun getBeginValue(calendar: Calendar, dateField: Int): Int {
        return if (Calendar.DAY_OF_WEEK == dateField) {
            calendar.firstDayOfWeek
        } else calendar.getActualMinimum(dateField)
    }

    /**
     * 获取指定日期字段的最大值，例如分钟的最大值是59
     * @param calendar  [Calendar]
     * @param dateField [DateField]
     * @return 字段最大值
     * @see Calendar.getActualMaximum
     */
    fun getEndValue(calendar: Calendar, dateField: DateField): Int {
        return getEndValue(calendar, dateField.value)
    }

    /**
     * 获取指定日期字段的最大值，例如分钟的最大值是59
     * @param calendar  [Calendar]
     * @param dateField [DateField]
     * @return 字段最大值
     * @see Calendar.getActualMaximum
     */
    fun getEndValue(calendar: Calendar, dateField: Int): Int {
        return if (Calendar.DAY_OF_WEEK == dateField) {
            (calendar.firstDayOfWeek + 6) % 7
        } else calendar.getActualMaximum(dateField)
    }

    /**
     * [Calendar]比较
     * @param calendar1 日期1
     * @param calendar2 日期2
     * @return 比较结果，如果calendar1 &lt; calendar2，返回数小于0，calendar1==calendar2返回0，calendar1 &gt; calendar2 大于0
     */
    fun compare(calendar1: Calendar, calendar2: Calendar): Int {
        return calendar1.compareTo(calendar2)
    }
    fun compare(calendar: Calendar, date: Date, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return compare(calendar, calendar(date, timeZone))
    }
    fun compare(calendar: Calendar, millis: Long, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return compare(calendar, calendar(millis, timeZone))
    }

    /**
     * 计算相对于dateToCompare的年龄，长用于计算指定生日在某年的年龄
     * @param birthday      生日
     * @param dateToCompare 需要对比的日期
     * @return 年龄
     */
    fun age(birthday: Calendar, dateToCompare: Calendar): Int {
        return age(birthday.timeInMillis, dateToCompare.timeInMillis)
    }
    fun age(birthday: Calendar, dateToCompare: Date, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return age(birthday, calendar(dateToCompare, timeZone))
    }
    fun age(birthday: Calendar, dateToCompare: Long, timeZone: TimeZone = TimeZone.getDefault()): Int {
        return age(birthday, calendar(dateToCompare, timeZone))
    }


    /**
     * 计算相对于dateToCompare的年龄，常用于计算指定生日在某年的年龄<br></br>
     * 按照《最高人民法院关于审理未成年人刑事案件具体应用法律若干问题的解释》第二条规定刑法第十七条规定的“周岁”，按照公历的年、月、日计算，从周岁生日的第二天起算。
     *  * 2022-03-01出生，则相对2023-03-01，周岁为0，相对于2023-03-02才是1岁。
     *  * 1999-02-28出生，则相对2000-02-29，周岁为1
     * @param birthday      生日
     * @param dateToCompare 需要对比的日期
     * @return 年龄 or -1 birthday <= dateToCompare
     */
    private fun age(birthday: Long, dateToCompare: Long): Int {
        if(birthday <= dateToCompare) return -1
        val cal = Calendar.getInstance()
        cal.timeInMillis = dateToCompare
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val dayOfMonth = cal[Calendar.DAY_OF_MONTH]

        // 复用cal
        cal.timeInMillis = birthday
        var age = year - cal[Calendar.YEAR]

        //当前日期，则为0岁
        if (age == 0) {
            return 0
        }
        val monthBirth = cal[Calendar.MONTH]
        if (month == monthBirth) {
            val dayOfMonthBirth = cal[Calendar.DAY_OF_MONTH]
            // issue#I6E6ZG，法定生日当天不算年龄，从第二天开始计算
            if (dayOfMonth <= dayOfMonthBirth) {
                // 如果生日在当月，但是未达到生日当天的日期，年龄减一
                age--
            }
        } else if (month < monthBirth) {
            // 如果当前月份未达到生日的月份，年龄计算减一
            age--
        }
        return age
    }



}