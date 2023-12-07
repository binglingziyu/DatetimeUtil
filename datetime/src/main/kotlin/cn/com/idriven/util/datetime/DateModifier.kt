package cn.com.idriven.util.datetime

import java.util.Calendar

/**
 * 日期修改器<br>
 * 用于实现自定义某个日期字段的调整，包括：
 *
 * <pre>
 * 1. 获取指定字段的起始时间
 * 2. 获取指定字段的四舍五入时间
 * 3. 获取指定字段的结束时间
 * </pre>
 * https://github.com/dromara/hutool/blob/v5-master/hutool-core/src/main/java/cn/hutool/core/date/DateModifier.java
 */
object DateModifier {

    /**
     * 忽略的计算的字段
     */
    private val IGNORE_FIELDS = intArrayOf( //
        Calendar.HOUR_OF_DAY,  // 与 HOUR 同名
        Calendar.AM_PM,  // 此字段单独处理，不参与计算起始和结束
        Calendar.DAY_OF_WEEK_IN_MONTH,  // 不参与计算
        Calendar.DAY_OF_YEAR,  // DAY_OF_MONTH 体现
        Calendar.WEEK_OF_MONTH,  // 特殊处理
        Calendar.WEEK_OF_YEAR // WEEK_OF_MONTH 体现
    )

    /**
     * 修改日期
     *
     * @param calendar   [Calendar]
     * @param dateField  日期字段，即保留到哪个日期字段
     * @param modifyType 修改类型，包括舍去、四舍五入、进一等
     * @return 修改后的{@link Calendar}
     */
    fun modify(calendar: Calendar, dateField: Int, modifyType: ModifyType): Calendar {
        return modify(calendar, dateField, modifyType, false)
    }

    /**
     * 修改日期，取起始值或者结束值<br></br>
     * 可选是否归零毫秒。
     *
     *
     *
     * 在[ModifyType.TRUNCATE]模式下，毫秒始终要归零,
     * 但是在[ModifyType.CEILING]和[ModifyType.ROUND]模式下，
     * 有时候由于毫秒部分必须为0（如MySQL数据库中），因此在此加上选项。
     *
     *
     * @param calendar            [Calendar]
     * @param dateField           日期字段，即保留到哪个日期字段
     * @param modifyType          修改类型，包括舍去、四舍五入、进一等
     * @param truncateMillisecond 是否归零毫秒
     * @return 修改后的{@link Calendar}
     * @since 5.7.5
     */
    fun modify(
        calendar: Calendar,
        dateField: Int,
        modifyType: ModifyType,
        truncateMillisecond: Boolean
    ): Calendar {
        // AM_PM上下午特殊处理
        if (Calendar.AM_PM == dateField) {
            val isAM: Boolean = CalendarUtil.isAM(calendar)
            when (modifyType) {
                ModifyType.TRUNCATE -> calendar[Calendar.HOUR_OF_DAY] = if (isAM) 0 else 12
                ModifyType.CEILING -> calendar[Calendar.HOUR_OF_DAY] = if (isAM) 11 else 23
                ModifyType.ROUND -> {
                    val min = if (isAM) 0 else 12
                    val max = if (isAM) 11 else 23
                    val href = (max - min) / 2 + 1
                    val value = calendar[Calendar.HOUR_OF_DAY]
                    calendar[Calendar.HOUR_OF_DAY] = if (value < href) min else max
                }
            }
            // 处理下一级别字段
            return modify(calendar, dateField + 1, modifyType)
        }
        val endField = if (truncateMillisecond) Calendar.SECOND else Calendar.MILLISECOND
        // 循环处理各级字段，精确到毫秒字段
        for (i in dateField + 1..endField) {
            if (IGNORE_FIELDS.contains(i)) {
                // 忽略无关字段（WEEK_OF_MONTH）始终不做修改
                continue
            }

            // 在计算本周的起始和结束日时，月相关的字段忽略。
            if (Calendar.WEEK_OF_MONTH == dateField || Calendar.WEEK_OF_YEAR == dateField) {
                if (Calendar.DAY_OF_MONTH == i) {
                    continue
                }
            } else {
                // 其它情况忽略周相关字段计算
                if (Calendar.DAY_OF_WEEK == i) {
                    continue
                }
            }
            modifyField(calendar, i, modifyType)
        }
        if (truncateMillisecond) {
            calendar[Calendar.MILLISECOND] = 0
        }
        return calendar
    }

    // -------------------------------------------------------------------------------------------------- Private method start

    // -------------------------------------------------------------------------------------------------- Private method start
    /**
     * 修改日期字段值
     *
     * @param calendar   [Calendar]
     * @param field      字段，见[Calendar]
     * @param modifyType [ModifyType]
     */
    private fun modifyField(calendar: Calendar, field: Int, modifyType: ModifyType) {
        var mField = field
        if (Calendar.HOUR == mField) {
            // 修正小时。HOUR为12小时制，上午的结束时间为12:00，此处改为HOUR_OF_DAY: 23:59
            mField = Calendar.HOUR_OF_DAY
        }
        when (modifyType) {
            ModifyType.TRUNCATE -> calendar[mField] = CalendarUtil.getBeginValue(calendar, mField)
            ModifyType.CEILING -> calendar[mField] = CalendarUtil.getEndValue(calendar, mField)
            ModifyType.ROUND -> {
                val min: Int = CalendarUtil.getBeginValue(calendar, mField)
                val max: Int = CalendarUtil.getEndValue(calendar, mField)
                val href: Int = if (Calendar.DAY_OF_WEEK == mField) {
                    // 星期特殊处理，假设周一是第一天，中间的为周四
                    (min + 3) % 7
                } else {
                    (max - min) / 2 + 1
                }
                val value = calendar[mField]
                calendar[mField] = if (value < href) min else max
            }
        }
        // Console.log("# {} -> {}", DateField.of(field), calendar.get(field));
    }
    // -------------------------------------------------------------------------------------------------- Private method end

    // -------------------------------------------------------------------------------------------------- Private method end
    /**
     * 修改类型
     *
     * @author looly
     */
    enum class ModifyType {
        /**
         * 取指定日期短的起始值.
         */
        TRUNCATE,

        /**
         * 指定日期属性按照四舍五入处理
         */
        ROUND,

        /**
         * 指定日期属性按照进一法处理
         */
        CEILING
    }


}