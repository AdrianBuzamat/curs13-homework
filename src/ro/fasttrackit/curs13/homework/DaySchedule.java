package ro.fasttrackit.curs13.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaySchedule {
    private final DaysOfWeek day;
    private List<String> activities;
    public DaySchedule(DaysOfWeek day, List<String> activities) {
        this.day = day;
        this.activities = activities == null ?
                new ArrayList<>() :
                new ArrayList<>(activities);
    }

    public DaysOfWeek getDay() {
        return day;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaySchedule that = (DaySchedule) o;
        return day == that.day && Objects.equals(activities, that.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, activities);
    }

}
