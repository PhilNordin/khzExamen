package com.philip.khzExamen.models;

public class Day {

    private final int dayOfMonth;
    private final boolean today;

    public Day(int dayOfMonth, boolean today) {
        this.dayOfMonth = dayOfMonth;
        this.today = today;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public boolean isToday() {
        return today;
    }
}
