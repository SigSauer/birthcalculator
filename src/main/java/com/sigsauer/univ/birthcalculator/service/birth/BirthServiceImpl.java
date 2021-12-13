package com.sigsauer.univ.birthcalculator.service.birth;

import com.sigsauer.univ.birthcalculator.service.birth.bean.BirthTimer;
import com.sigsauer.univ.birthcalculator.service.shared.ServiceFactory;
import com.sigsauer.univ.birthcalculator.service.user.UserService;
import com.sigsauer.univ.birthcalculator.utils.DateUtils;
import org.joda.time.*;

import java.util.Date;

public class BirthServiceImpl implements BirthService{
    private final String PRETTY_MESSAGE = "Today is %s. Your next birthday will %s. Left %s months, %s weeks and %s days until you nex birthday.";

    UserService userService = ServiceFactory.getUserService();

    @Override
    public BirthTimer calculateTimeUntilBirthday(Long userId, Date localDate) {
        Date userBirth = userService.getUserBirth(userId);
        LocalDate now = LocalDate.fromDateFields(localDate);
        LocalDate birth = LocalDate.fromDateFields(userBirth).withYear(now.getYear());
        if (birth.isBefore(now)) birth = birth.plusYears(1);

        return calculatePeriods(birth, now);
    }


    private BirthTimer calculatePeriods(LocalDate startDate, LocalDate finalDate) {
        System.out.println("start date: "+ startDate.toString());
        System.out.println("final date: "+ finalDate.toString());

        int months = Math.abs(Months.monthsBetween(finalDate, startDate).getMonths());
        int weeks = Math.abs(Weeks.weeksBetween(finalDate, startDate).getWeeks());
        int days = Math.abs(Days.daysBetween(finalDate, startDate).getDays());
        int hours = Math.abs(Hours.hoursBetween(finalDate, startDate).getHours());
        int minutes = Math.abs(Minutes.minutesBetween(finalDate, startDate).getMinutes());
        int seconds = Math.abs(Seconds.secondsBetween(finalDate, startDate).getSeconds());

        LocalDate dater = finalDate.minusMonths(months);
        int aWeeks = weeks - Math.abs(Weeks.weeksBetween(dater, startDate).getWeeks());
        dater = finalDate.minusWeeks(weeks);
        int aDays = days - Math.abs(Days.daysBetween(dater, startDate).getDays());
        String prettyMessage = String.format(PRETTY_MESSAGE, DateUtils.convert(finalDate), DateUtils.convert(startDate),
                months, aWeeks, aDays);

        return new BirthTimer(prettyMessage, months, weeks, days, hours, minutes, seconds);
    }
}
