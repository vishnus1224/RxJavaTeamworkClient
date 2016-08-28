package com.vishnus1224.teamworkapidemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Helper class for handling operations related to dates.
 * Created by Vishnu on 8/28/2016.
 */
public final class DateTimeHelper {

    private static final String ZULU_DATE_TIME_PATTERN = "yyyy-MM-dd'T'hh:mm:ss'Z'";

    private static final String DUE_DATE_PATTERN = "YYYYMMDD";

    private static final String TIME_AM_PM_PATTERN = "E hh:mm a";

    /**
     * Convert the date string in the latest activity response to a date.
     * @param dateString string to parse.
     * @return date object.
     */
    public Date latestActivityDateTimeToDate(String dateString) throws ParseException {

        return convertStringToDate(dateString, ZULU_DATE_TIME_PATTERN,
                TimeZone.getTimeZone(TimeZone.getDefault().getDisplayName()));

    }

    public Date latestActivityDueDateToDate(String dueDate) throws ParseException{

        return convertStringToDate(dueDate, DUE_DATE_PATTERN,
                TimeZone.getTimeZone(TimeZone.getDefault().getDisplayName()));


    }

    public String extractDayAndTimeFromDate(Date date){

        return formatDate(date, TIME_AM_PM_PATTERN, TimeZone.getDefault());

    }

    private Date convertStringToDate(String dateString, String pattern, TimeZone timeZone) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());

        simpleDateFormat.setTimeZone(timeZone);

        return simpleDateFormat.parse(dateString);

    }

    private String formatDate(Date date, String pattern, TimeZone timeZone){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());

        simpleDateFormat.setTimeZone(timeZone);

        return simpleDateFormat.format(date);

    }

}
