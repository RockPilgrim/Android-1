package my.lessons.lesson_3continue.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import my.lessons.lesson_3continue.R;

public class WorkoutList  {

    private static final WorkoutList ourInstance = new WorkoutList();
    private Map<Integer,Workout> workouts;
    private final String[] descriptions={"Rowing","Hugging","Sleeping"};

    public static WorkoutList getInstance() {
        return ourInstance;
    }

    public Workout getWorkout(int index){
        return workouts.get(index);
    }

    public Map<Integer,Workout> getWorkouts() {
        return workouts;
    }

    private WorkoutList() {
        workouts = new ArrayMap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Workout workout = new Workout("Approach",i);
            workout.setRecordDate(Calendar.getInstance());
            workout.setRecordWeight(random.nextInt(61));
            workout.setRecordRepsCount(random.nextInt(101));
            int index=random.nextInt(descriptions.length);
            workout.setDescription(descriptions[index]);
            workouts.put(i,workout);
        }
    }
    public void addWorkout(int index,Workout workout){
        workouts.put(index,workout);
    }
    public void addWorkout(Workout workout){
        workouts.put(workouts.size(),workout);
    }

    public void removeWorkout(int index){
//        workouts.put(index,null);
        workouts.remove(index);
    }
}
