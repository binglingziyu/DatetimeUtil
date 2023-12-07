package cn.com.idriven.util.datetime

import java.util.Calendar
import java.util.Date
import java.util.TimeZone

//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓  Calendar  ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
fun Calendar.date() = CalendarUtil.date(this)
fun Calendar.millis() = CalendarUtil.millis(this)

fun Calendar.isAM() = CalendarUtil.isAM(this)
fun Calendar.isPM() = CalendarUtil.isPM(this)

fun Calendar.truncate(dateField: DateField) = CalendarUtil.truncate(this, dateField)
fun Calendar.truncate(dateField: Int) = CalendarUtil.truncate(this, dateField)
fun Calendar.round(dateField: DateField) = CalendarUtil.round(this, dateField)
fun Calendar.round(dateField: Int) = CalendarUtil.round(this, dateField)
fun Calendar.ceiling(dateField: DateField) = CalendarUtil.ceiling(this, dateField)
fun Calendar.ceiling(dateField: Int) = CalendarUtil.ceiling(this, dateField)
fun Calendar.ceiling(dateField: DateField, truncateMillisecond: Boolean) = CalendarUtil.ceiling(this, dateField, truncateMillisecond)
fun Calendar.ceiling(dateField: Int, truncateMillisecond: Boolean) = CalendarUtil.ceiling(this, dateField, truncateMillisecond)

fun Calendar.beginOfSecond() = CalendarUtil.beginOfSecond(this)
fun Calendar.endOfSecond() = CalendarUtil.endOfSecond(this)
fun Calendar.beginOfMinute() = CalendarUtil.beginOfMinute(this)
fun Calendar.endOfMinute() = CalendarUtil.endOfMinute(this)
fun Calendar.beginOfHour() = CalendarUtil.beginOfHour(this)
fun Calendar.endOfHour() = CalendarUtil.endOfHour(this)
fun Calendar.beginOfDay() = CalendarUtil.beginOfDay(this)
fun Calendar.endOfDay() = CalendarUtil.endOfDay(this)
fun Calendar.beginOfWeek(isMondayAsFirstDay: Boolean = true) = CalendarUtil.beginOfWeek(this, isMondayAsFirstDay)
fun Calendar.endOfWeek(isMondayAsFirstDay: Boolean = true) = CalendarUtil.endOfWeek(this, isMondayAsFirstDay)
fun Calendar.beginOfMonth() = CalendarUtil.beginOfMonth(this)
fun Calendar.endOfMonth() = CalendarUtil.endOfMonth(this)
fun Calendar.beginOfYear() = CalendarUtil.beginOfYear(this)
fun Calendar.endOfYear() = CalendarUtil.endOfYear(this)

fun Calendar.isSameMillis(calendar: Calendar) = CalendarUtil.isSameMillis(this, calendar)
fun Calendar.isSameMillis(date: Date) = CalendarUtil.isSameMillis(this, date)
fun Calendar.isSameMillis(millis: Long) = CalendarUtil.isSameMillis(this, millis)
fun Calendar.isSameSecond(calendar: Calendar) = CalendarUtil.isSameSecond(this, calendar)
fun Calendar.isSameSecond(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameSecond(this, date, timeZone)
fun Calendar.isSameSecond(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameSecond(this, millis, timeZone)
fun Calendar.isSameMinute(calendar: Calendar) = CalendarUtil.isSameMinute(this, calendar)
fun Calendar.isSameMinute(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameMinute(this, date, timeZone)
fun Calendar.isSameMinute(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameMinute(this, millis, timeZone)
fun Calendar.isSameHour(calendar: Calendar) = CalendarUtil.isSameHour(this, calendar)
fun Calendar.isSameHour(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameHour(this, date, timeZone)
fun Calendar.isSameHour(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameHour(this, millis, timeZone)
fun Calendar.isSameDay(calendar: Calendar) = CalendarUtil.isSameDay(this, calendar)
fun Calendar.isSameDay(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameDay(this, date, timeZone)
fun Calendar.isSameDay(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameDay(this, millis, timeZone)
fun Calendar.isSameWeek(calendar: Calendar, isMon: Boolean = true) = CalendarUtil.isSameWeek(this, calendar, isMon)
fun Calendar.isSameWeek(date: Date, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true) = CalendarUtil.isSameWeek(this, date, isMon, timeZone)
fun Calendar.isSameWeek(millis: Long, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true) = CalendarUtil.isSameWeek(this, millis, isMon, timeZone)
fun Calendar.isSameMonth(calendar: Calendar) = CalendarUtil.isSameMonth(this, calendar)
fun Calendar.isSameMonth(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameMonth(this, date, timeZone)
fun Calendar.isSameMonth(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameMonth(this, millis, timeZone)
fun Calendar.isSameYear(calendar: Calendar) = CalendarUtil.isSameYear(this, calendar)
fun Calendar.isSameYear(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameYear(this, date, timeZone)
fun Calendar.isSameYear(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.isSameYear(this, millis, timeZone)

fun Calendar.getBeginValue(dateField: DateField) = CalendarUtil.getBeginValue(this, dateField)
fun Calendar.getBeginValue(dateField: Int) = CalendarUtil.getBeginValue(this, dateField)
fun Calendar.getEndValue(dateField: DateField) = CalendarUtil.getEndValue(this, dateField)
fun Calendar.getEndValue(dateField: Int) = CalendarUtil.getEndValue(this, dateField)

fun Calendar.compare(calendar: Calendar) = CalendarUtil.compare(this, calendar)
fun Calendar.compare(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.compare(this, date, timeZone)
fun Calendar.compare(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.compare(this, millis, timeZone)

fun Calendar.age(calendar: Calendar) = CalendarUtil.age(this, calendar)
fun Calendar.age(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.age(this, date, timeZone)
fun Calendar.age(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = CalendarUtil.age(this, millis, timeZone)

//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  Calendar  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑



//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓  Date  ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
fun Date.calendar(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.calendar(this, timeZone)
fun Date.millis() = DateUtil.millis(this)

fun Date.isAM(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isAM(this, timeZone)
fun Date.isPM(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isPM(this, timeZone)

fun Date.truncate(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.truncate(this, dateField, timeZone)
fun Date.truncate(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.truncate(this, dateField, timeZone)
fun Date.round(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.round(this, dateField, timeZone)
fun Date.round(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.round(this, dateField, timeZone)
fun Date.ceiling(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.ceiling(this, dateField, timeZone)
fun Date.ceiling(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.ceiling(this, dateField, timeZone)
fun Date.ceiling(dateField: DateField, truncateMillisecond: Boolean, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.ceiling(this, dateField, truncateMillisecond, timeZone)
fun Date.ceiling(dateField: Int, truncateMillisecond: Boolean, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.ceiling(this, dateField, truncateMillisecond, timeZone)

fun Date.beginOfSecond(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfSecond(this, timeZone)
fun Date.endOfSecond(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfSecond(this, timeZone)
fun Date.beginOfMinute(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfMinute(this, timeZone)
fun Date.endOfMinute(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfMinute(this, timeZone)
fun Date.beginOfHour(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfHour(this, timeZone)
fun Date.endOfHour(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfHour(this, timeZone)
fun Date.beginOfDay(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfDay(this, timeZone)
fun Date.endOfDay(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfDay(this, timeZone)
fun Date.beginOfWeek(timeZone: TimeZone = TimeZone.getDefault(), isMondayAsFirstDay: Boolean = true) = DateUtil.beginOfWeek(this, timeZone, isMondayAsFirstDay)
fun Date.endOfWeek(timeZone: TimeZone = TimeZone.getDefault(), isMondayAsFirstDay: Boolean = true) = DateUtil.endOfWeek(this, timeZone, isMondayAsFirstDay)
fun Date.beginOfMonth(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfMonth(this, timeZone)
fun Date.endOfMonth(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfMonth(this, timeZone)
fun Date.beginOfYear(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfYear(this, timeZone)
fun Date.endOfYear(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfYear(this, timeZone)

fun Date.isSameMillis(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMillis(this, calendar, timeZone)
fun Date.isSameMillis(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMillis(this, date, timeZone)
fun Date.isSameMillis(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMillis(this, millis, timeZone)
fun Date.isSameSecond(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameSecond(this, calendar, timeZone)
fun Date.isSameSecond(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameSecond(this, date, timeZone)
fun Date.isSameSecond(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameSecond(this, millis, timeZone)
fun Date.isSameMinute(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMinute(this, calendar, timeZone)
fun Date.isSameMinute(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMinute(this, date, timeZone)
fun Date.isSameMinute(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMinute(this, millis, timeZone)
fun Date.isSameHour(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameHour(this, calendar, timeZone)
fun Date.isSameHour(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameHour(this, date, timeZone)
fun Date.isSameHour(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameHour(this, millis, timeZone)
fun Date.isSameDay(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameDay(this, calendar, timeZone)
fun Date.isSameDay(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameDay(this, date, timeZone)
fun Date.isSameDay(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameDay(this, millis, timeZone)
fun Date.isSameWeek(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true) = DateUtil.isSameWeek(this, calendar, timeZone, isMon)
fun Date.isSameWeek(date: Date, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true) = DateUtil.isSameWeek(this, date, timeZone, isMon)
fun Date.isSameWeek(millis: Long, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true) = DateUtil.isSameWeek(this, millis, timeZone, isMon)
fun Date.isSameMonth(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMonth(this, calendar, timeZone)
fun Date.isSameMonth(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMonth(this, date, timeZone)
fun Date.isSameMonth(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMonth(this, millis, timeZone)
fun Date.isSameYear(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameYear(this, calendar, timeZone)
fun Date.isSameYear(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameYear(this, date, timeZone)
fun Date.isSameYear(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameYear(this, millis, timeZone)

fun Date.getBeginValue(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.getBeginValue(this, dateField, timeZone)
fun Date.getBeginValue(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.getBeginValue(this, dateField, timeZone)
fun Date.getEndValue(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.getEndValue(this, dateField, timeZone)
fun Date.getEndValue(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.getEndValue(this, dateField, timeZone)

fun Date.compare(calendar: Calendar) = DateUtil.compare(this, calendar)
fun Date.compare(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.compare(this, date, timeZone)
fun Date.compare(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.compare(this, millis, timeZone)

fun Date.age(calendar: Calendar) = DateUtil.age(this, calendar)
fun Date.age(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.age(this, date, timeZone)
fun Date.age(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.age(this, millis, timeZone)

//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  Date  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑



//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓  Long  ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
fun Long.calendar(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.calendar(Date(this), timeZone)
fun Long.date() = DateUtil.date(this)

fun Long.isAM(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isAM(this, timeZone)
fun Long.isPM(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isPM(this, timeZone)

fun Long.truncate(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.truncate(Date(this), dateField, timeZone).time
fun Long.truncate(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.truncate(Date(this), dateField, timeZone).time
fun Long.round(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.round(Date(this), dateField, timeZone).time
fun Long.round(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.round(Date(this), dateField, timeZone).time
fun Long.ceiling(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.ceiling(Date(this), dateField, timeZone).time
fun Long.ceiling(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.ceiling(Date(this), dateField, timeZone).time
fun Long.ceiling(dateField: DateField, truncateMillisecond: Boolean, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.ceiling(Date(this), dateField, truncateMillisecond, timeZone).time
fun Long.ceiling(dateField: Int, truncateMillisecond: Boolean, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.ceiling(Date(this), dateField, truncateMillisecond, timeZone).time

fun Long.beginOfSecond(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfSecond(Date(this), timeZone).time
fun Long.endOfSecond(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfSecond(Date(this), timeZone).time
fun Long.beginOfMinute(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfMinute(Date(this), timeZone).time
fun Long.endOfMinute(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfMinute(Date(this), timeZone).time
fun Long.beginOfHour(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfHour(Date(this), timeZone).time
fun Long.endOfHour(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfHour(Date(this), timeZone).time
fun Long.beginOfDay(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfDay(Date(this), timeZone).time
fun Long.endOfDay(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfDay(Date(this), timeZone).time
fun Long.beginOfWeek(timeZone: TimeZone = TimeZone.getDefault(), isMondayAsFirstDay: Boolean = true) = DateUtil.beginOfWeek(Date(this), timeZone, isMondayAsFirstDay).time
fun Long.endOfWeek(timeZone: TimeZone = TimeZone.getDefault(), isMondayAsFirstDay: Boolean = true) = DateUtil.endOfWeek(Date(this), timeZone, isMondayAsFirstDay).time
fun Long.beginOfMonth(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfMonth(Date(this), timeZone).time
fun Long.endOfMonth(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfMonth(Date(this), timeZone).time
fun Long.beginOfYear(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.beginOfYear(Date(this), timeZone).time
fun Long.endOfYear(timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.endOfYear(Date(this), timeZone).time

fun Long.isSameMillis(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMillis(Date(this), calendar, timeZone)
fun Long.isSameMillis(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMillis(Date(this), date, timeZone)
fun Long.isSameMillis(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMillis(Date(this), millis, timeZone)
fun Long.isSameSecond(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameSecond(Date(this), calendar, timeZone)
fun Long.isSameSecond(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameSecond(Date(this), date, timeZone)
fun Long.isSameSecond(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameSecond(Date(this), millis, timeZone)
fun Long.isSameMinute(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMinute(Date(this), calendar, timeZone)
fun Long.isSameMinute(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMinute(Date(this), date, timeZone)
fun Long.isSameMinute(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMinute(Date(this), millis, timeZone)
fun Long.isSameHour(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameHour(Date(this), calendar, timeZone)
fun Long.isSameHour(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameHour(Date(this), date, timeZone)
fun Long.isSameHour(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameHour(Date(this), millis, timeZone)
fun Long.isSameDay(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameDay(Date(this), calendar, timeZone)
fun Long.isSameDay(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameDay(Date(this), date, timeZone)
fun Long.isSameDay(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameDay(Date(this), millis, timeZone)
fun Long.isSameWeek(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true) = DateUtil.isSameWeek(Date(this), calendar, timeZone, isMon)
fun Long.isSameWeek(date: Date, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true) = DateUtil.isSameWeek(Date(this), date, timeZone, isMon)
fun Long.isSameWeek(millis: Long, timeZone: TimeZone = TimeZone.getDefault(), isMon: Boolean = true) = DateUtil.isSameWeek(Date(this), millis, timeZone, isMon)
fun Long.isSameMonth(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMonth(Date(this), calendar, timeZone)
fun Long.isSameMonth(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMonth(Date(this), date, timeZone)
fun Long.isSameMonth(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameMonth(Date(this), millis, timeZone)
fun Long.isSameYear(calendar: Calendar, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameYear(Date(this), calendar, timeZone)
fun Long.isSameYear(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameYear(Date(this), date, timeZone)
fun Long.isSameYear(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.isSameYear(Date(this), millis, timeZone)

fun Long.getBeginValue(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.getBeginValue(Date(this), dateField, timeZone)
fun Long.getBeginValue(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.getBeginValue(Date(this), dateField, timeZone)
fun Long.getEndValue(dateField: DateField, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.getEndValue(Date(this), dateField, timeZone)
fun Long.getEndValue(dateField: Int, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.getEndValue(Date(this), dateField, timeZone)

fun Long.compare(calendar: Calendar) = DateUtil.compare(Date(this), calendar)
fun Long.compare(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.compare(Date(this), date, timeZone)
fun Long.compare(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.compare(Date(this), millis, timeZone)

fun Long.age(calendar: Calendar) = DateUtil.age(Date(this), calendar)
fun Long.age(date: Date, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.age(Date(this), date, timeZone)
fun Long.age(millis: Long, timeZone: TimeZone = TimeZone.getDefault()) = DateUtil.age(Date(this), millis, timeZone)

//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑  Long  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑