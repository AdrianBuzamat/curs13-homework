package ro.fasttrackit.curs13.homework;

import java.util.*;

public class DailyPlanner {
    private List<DaySchedule> planner;

    public DailyPlanner(List<DaySchedule> planner) {
        this.planner = planner == null ?
                new ArrayList<>() :
                new ArrayList<>(planner);
        ;
    }

    public void addActivity(DaysOfWeek day, String activity) {
        List<String> activities = new ArrayList<>();
        if (activities == null) {
            throw new NoActivityException("activity not found");
        } else {
            activities.add(activity);
        }

        planner.add(new DaySchedule(day, activities));

    }

    public void removeActivity(DaysOfWeek day, String activity) {
        if (activity == null) {
            throw new NoActivityException("activity not found");
        } else {
            for (DaySchedule daySchedule : planner) {
                if (day == daySchedule.getDay()) {
                    if (daySchedule.getActivities().contains(activity)) {
                        daySchedule.getActivities().remove(activity);
                    }
                }
            }
        }
    }

    public List<String> getActivities(DaysOfWeek day) {
        List<String> result = new ArrayList<>();
        for (DaySchedule activity : planner) {
            if (day.equals(activity.getDay())) {
                result.addAll(activity.getActivities());
            }
        }
        return result;
    }

    public Map<DaysOfWeek, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<DaysOfWeek, List<String>> result = new HashMap<>();
        for (DaySchedule daySchedule : planner) {
            List<String> activities = new ArrayList<>();
            if (daySchedule.getActivities() == null) {
                throw new NoActivitiesForDayException("no activity found");
            } else {
                activities.addAll(daySchedule.getActivities());
                result.put(daySchedule.getDay(), activities);
            }
        }
        return result;
    }
}

class NoActivityException extends RuntimeException {
    public NoActivityException(String msg) {
        super(msg);
    }
}


class NoActivitiesForDayException extends Exception {
    public NoActivitiesForDayException(String msg) {
        super(msg);
    }
}


