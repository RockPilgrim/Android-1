package my.lessons.lesson_3continue.model;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import my.lessons.lesson_3continue.R;


public class Workout {

    private String title;
    private String description;
    private Drawable imageUrl;
    private String recordDate;
    private Calendar recordDateCalendar;
    private int recordRepsCount;
    private int recordWeight;
    private int index;

    public Workout(String title,int index) {
        this.index=index;
        this.title = title+" #"+index;
        recordRepsCount=0;
        recordWeight=0;
        recordDate="";
    }

    public Workout(String title,int index, int recordRepsCount, Calendar recordDate, int recordWeight) {
        this.title = title+" #"+index;
        this.recordRepsCount = recordRepsCount;
        recordDateCalendar = recordDate;
        formateRecordDate();
        this.recordWeight = recordWeight;
        this.index=index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private void formateRecordDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        recordDate= dateFormat.format(recordDateCalendar.getTime());
    }
    public int getIndex() {
        return index;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Drawable imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getRecordRepsCount() {
        return recordRepsCount;
    }

    public void setRecordRepsCount(int recordRepsCount) {
        this.recordRepsCount = recordRepsCount;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Calendar recordDate) {
        recordDateCalendar = recordDate;
        formateRecordDate();
    }

    public int getRecordWeight() {
        return recordWeight;
    }

    public void setRecordWeight(int recordWeight) {
        this.recordWeight = recordWeight;
    }
}
