package com.sigsauer.univ.birthcalculator.service.birth.bean;

public class BirthTimer {

    private String pretty;
    private int months;
    private int weeks;
    private int days;
    private int hours;
    private int minutes;
    private int seconds;



    public BirthTimer() {
    }

    public BirthTimer(String pretty, int months, int weeks, int days, int hours, int minutes, int seconds) {
        this.pretty = pretty;
        this.months = months;
        this.weeks = weeks;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getPretty() {
        return pretty;
    }

    public void setPretty(String pretty) {
        this.pretty = pretty;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "BirthTimer{" +
                "pretty='" + pretty + '\'' +
                ", months=" + months +
                ", weeks=" + weeks +
                ", days=" + days +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
