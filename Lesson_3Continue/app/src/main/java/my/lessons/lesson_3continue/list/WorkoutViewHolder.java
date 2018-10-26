package my.lessons.lesson_3continue.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import my.lessons.lesson_3continue.R;
import my.lessons.lesson_3continue.interfaces.OnListItemClickListener;
import my.lessons.lesson_3continue.model.Workout;
import my.lessons.lesson_3continue.model.WorkoutList;
import my.lessons.lesson_3continue.utils.TagContainer;

public class WorkoutViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTextView;
    private TextView descriptionTextView;
    private TextView recordWeight;
    private TextView recordRepsCount;
    private TextView recordDate;
    private ImageView imageWorkout;
    private ImageView clearButton;
    private CardView cardView;


    public WorkoutViewHolder(@NonNull final View itemView) {
        super(itemView);

        cardView = itemView.findViewById(R.id.list_item_card_view);
        clearButton = itemView.findViewById(R.id.list_item_clear);
        titleTextView = itemView.findViewById(R.id.list_item_title);
        descriptionTextView = itemView.findViewById(R.id.list_item_description);
        recordWeight = itemView.findViewById(R.id.list_item_weight);
        recordRepsCount = itemView.findViewById(R.id.list_item_reps);
        recordDate = itemView.findViewById(R.id.list_item_date);
        imageWorkout = itemView.findViewById(R.id.list_item_image_view);
    }


    public void bindView(final Workout workout, OnListItemClickListener listener) {
        titleTextView.setText(workout.getTitle());
        descriptionTextView.setText(workout.getDescription());
        recordWeight.setText(String.valueOf(workout.getRecordWeight()));
        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
        recordDate.setText(workout.getRecordDate());

        listener(workout,listener);
        Picasso
                .get()
                .load("http://i.imgur.com/DvpvklR.png").placeholder(R.drawable.ic_clear).into(imageWorkout);
    }
    private void listener(final Workout workout, final OnListItemClickListener listener){
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutList.getInstance().removeWorkout(workout.getIndexArr());
                destroy();
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.FadeIn)
                        .duration(700)
                        .playOn(cardView);
                Log.d(TagContainer.LOGCAT_TAG, "#" + workout.getIndexArr());
                Toast toast=Toast.makeText(itemView.getContext(), "#" + (workout.getIndexArr()-1), Toast.LENGTH_SHORT);
                toast.show();

                listener.onListItemClickListener(workout.getIndexArr());
            }
        });
    }
    private void destroy(){
        cardView.removeAllViews();
    }
}
