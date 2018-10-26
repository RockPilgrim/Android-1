package my.lessons.lesson_3continue.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Map;

import my.lessons.lesson_3continue.R;
import my.lessons.lesson_3continue.interfaces.OnListItemClickListener;
import my.lessons.lesson_3continue.model.Workout;
import my.lessons.lesson_3continue.model.WorkoutList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutViewHolder> {

    private Map<Integer,Workout> workoutList=WorkoutList.getInstance().getWorkouts();
    private OnListItemClickListener itemClickListener;

    public WorkoutAdapter(OnListItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.list_item,
                viewGroup,
                false
        );
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder workoutViewHolder, int index) {
        if (workoutList.get(index)!=null)
            workoutViewHolder.bindView(workoutList.get(index),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return workoutList!=null ? workoutList.size():0;
    }
}
