package com.center.common.datetime;

import com.center.common.ConstantEnum;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtils {

    public static final DateTimeFormatter DATE_FORMATTER, DATE_TIME_FORMATTER;

    static {
        DATE_FORMATTER = DateTimeFormatter.ofPattern(ConstantEnum.Specification.DATE_TIME.getFormats()[0], Locale.CHINA);
        DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(ConstantEnum.Specification.DATE_TIME.getFormats()[1], Locale.CHINA);
    }


}
