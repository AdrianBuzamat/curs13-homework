package ro.fasttrackit.curs13.homework;

import java.util.List;

import static ro.fasttrackit.curs13.homework.DaysOfWeek.*;

public class Main {
    public static void main(String[] args) throws NoActivitiesForDayException {
        DailyPlanner planner = new DailyPlanner(List.of(
                new DaySchedule(MONDAY, List.of("Take breakfast", "Meet Kevin")),
                new DaySchedule(THURSDAY, List.of("Go to gym at 6AM", "")),
                new DaySchedule(FRIDAY, List.of("Go to dentist"))
        ));

        planner.addActivity(SATURDAY, "watch football");
        System.out.println(planner.getActivities(SATURDAY));
        planner.removeActivity(MONDAY, "Meet Kevin");
        System.out.println(planner.getActivities(MONDAY));
        System.out.println(planner.endPlanning());
        planner.addActivity(THURSDAY, "zoom call");
        planner.addActivity(SUNDAY, "meet Ana");
        System.out.println(planner.endPlanning());

    }
}
