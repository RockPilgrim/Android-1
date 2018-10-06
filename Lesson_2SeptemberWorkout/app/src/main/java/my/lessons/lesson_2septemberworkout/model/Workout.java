package my.lessons.lesson_2septemberworkout.model;

import java.util.Date;

public class Workout {

    private String title;
    private String description;
    Date date;
    int weigth;
    int repsCount;
    // Time
    // Difficult
    // Status
    // Type

    public Workout(String title, String description, int repsCount, Date date, int weigth) {
        this.title = title;
        this.description = description;
        this.repsCount = repsCount;
        this.date = date;
        this.weigth = weigth;
    }

    public Workout(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRepsCount() {
        return repsCount;
    }

    public void setRepsCount(int repsCount) {
        this.repsCount = repsCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }
}
