package com.sigsauer.univ.birthcalculator.utils;

import org.joda.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static String DATE_FORMAT_REGEX = "(\\d{4}[-]\\d{2}[-]\\d{2})";
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public static Date convert(String date) {
        if (!isFormatted(date)) return null;
        try {
            return sdf.parse(date);
        }catch (ParseException e) {
            return null;
        }
    }

    public static String convert(Date date) {
        return sdf.format(date);
    }

    public static String convert(LocalDate date) {
        return convert(date.toDate());
    }

    public static boolean isFormatted (String date) {
        return date.matches(DATE_FORMAT_REGEX);
    }

    public static boolean isConvertable (String date) {
        if (!isFormatted(date)) return false;
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
