package my.lessons.lesson_3continue.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import my.lessons.lesson_3continue.R;

public class WorkoutList  {

    private static final WorkoutList ourInstance = new WorkoutList();
    private List<Workout> workouts;
    private final String[] descriptions={"Rowing","Hugging","Sleeping"};

    public static WorkoutList getInstance() {
        return ourInstance;
    }

    public Workout getWorkout(int index){
        return workouts.get(index);
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    private WorkoutList() {
        workouts = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Workout workout = new Workout("Approach",i+1);
            workout.setRecordDate(Calendar.getInstance());
            workout.setRecordWeight(random.nextInt(61));
            workout.setRecordRepsCount(random.nextInt(101));
            int index=random.nextInt(descriptions.length);
            workout.setDescription(descriptions[index]);
            workouts.add(workout);
        }
    }
    public void addWorkout(int index,Workout workout){
        workouts.add(index,workout);
    }
    public void addWorkout(Workout workout){
        workouts.add(workout);
    }

    public void removeWorkout(int index){
        workouts.remove(index-1);
    }
}
