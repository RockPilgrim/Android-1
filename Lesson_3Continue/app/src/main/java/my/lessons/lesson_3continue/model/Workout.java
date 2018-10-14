package my.lessons.lesson_3continue.model;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Workout {

    private String title;
    private String description;
    private String imageUrl;
    private String recordDate;
    private Calendar recordDateCalendar;
    private int recordRepsCount;
    private int recordWeight;

    public Workout(String title) {
        this.title = title;
        description="";
        recordRepsCount=0;
        recordWeight=0;
        recordDate="";
    }

    /*    public Workout(String title) {
            this.title = title;

    */
    public Workout(String title, String description, int recordRepsCount, String recordDate, int recordWeight) {
        this.title = title;
        this.description = description;
        this.recordRepsCount = recordRepsCount;
        this.recordDate = recordDate;
        this.recordWeight = recordWeight;
    }

    private void formateRecordDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        recordDate= dateFormat.format(recordDateCalendar.getTime());
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
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
