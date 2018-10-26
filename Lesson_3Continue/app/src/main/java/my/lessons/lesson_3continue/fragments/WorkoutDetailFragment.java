package my.lessons.lesson_3continue.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Calendar;

import my.lessons.lesson_3continue.R;
import my.lessons.lesson_3continue.model.Workout;
import my.lessons.lesson_3continue.model.WorkoutList;
import my.lessons.lesson_3continue.utils.TagContainer;

/**
 * Android-1 Lesson-4
 *
 * @author Timofei Tokarev
 * @dated 14.10.18
 * @link https://github.com/RockPilgrim
 */

public class WorkoutDetailFragment extends Fragment {

    private static final String WORKOUT_INDEX = "workoutIndex";
    private TextView title;
    private TextView recordDate;
    private TextView recordRepsCount;
    private TextView recordWeight;
    private TextView description;
    private TextView weight;
    private ImageButton shareButton;
    private LinearLayout recordsLayout;
    private SeekBar weightSeekBar;
    private EditText repsCountEditText;
    private Button saveRecordButton;
    private WorkoutList workoutList;
    private Workout workout;
    public static final String LOG_TAG = TagContainer.LOGCAT_TAG;


    public static WorkoutDetailFragment initFragment(int index){
        WorkoutDetailFragment fragment = new WorkoutDetailFragment();
        Bundle arguments= new Bundle();
        arguments.putInt(WORKOUT_INDEX,index);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_workout_detail,container,false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);   // Get out focus from edit text


        workoutList=WorkoutList.getInstance();
        workout = workoutList.getWorkout(getArguments().getInt(WORKOUT_INDEX));
        initGUI(root);
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, "OnCreate");
    }

    private void checkRecord(String w, String reps) {
        try {
            int weightNew = Integer.parseInt(w);
            int weightOld = Integer.parseInt(recordWeight.getText().toString());

            int repsNew = Integer.parseInt(reps);
            int repsOld = Integer.parseInt(recordRepsCount.getText().toString());

            if (weightNew >= weightOld && repsNew >= repsOld) {
                YoYo.with(Techniques.FadeIn)
                        .duration(700)
                        .playOn(saveRecordButton);
                workout.setRecordWeight(weightNew);
                workout.setRecordRepsCount(repsNew);
                workout.setRecordDate(Calendar.getInstance());
                recordWeight.setText(String.valueOf(weightNew));
                recordRepsCount.setText(String.valueOf(repsNew));
                recordDate.setText(workout.getRecordDate());

                workoutList.addWorkout(workout.getIndexArr(),workout);
            }else
                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .playOn(saveRecordButton);

        } catch (NumberFormatException e) {
            YoYo.with(Techniques.Shake)
                    .duration(700)
                    .playOn(saveRecordButton);
            e.printStackTrace();
        }
        repsCountEditText.setText("");

        weightSeekBar.setProgress(0);
    }

    private void addRecord() {

    }

    private String recordText() {   // toString doesn't work in onClick method
        return "Title " + title.getText().toString() +
                "\nrecordDate: " + recordDate.getText().toString() +
                "\nrecordRepsCount: " + recordRepsCount.getText().toString() +
                "\nrecordWeight: " + recordWeight.getText().toString();
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }*/

    private void addListeners() {
        shareButton.setOnClickListener(new View.OnClickListener() {   // Share record with friends
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.FadeIn)
                        .duration(300)
                        .playOn(shareButton);
                String record = recordText();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, record);
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
        saveRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRecord(String.valueOf(weight.getText()), String.valueOf(repsCountEditText.getText()));
            }
        });
        weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                weight.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initGUI(View view) {
        title = view.findViewById(R.id.workout_detail_title);
        title.setText(workout.getTitle());

        recordDate = view.findViewById(R.id.workout_detail_record_date);
        recordDate.setText(workout.getRecordDate());

        recordRepsCount = view.findViewById(R.id.workout_detail_record_reps_count);
        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));

        recordWeight = view.findViewById(R.id.workout_detail_record_weight);
        recordWeight.setText(String.valueOf(workout.getRecordWeight()));

        description = view.findViewById(R.id.workout_detail_description);
        recordsLayout = view.findViewById(R.id.records_layout);

        shareButton = view.findViewById(R.id.workout_detail_share_button);

        weight = view.findViewById(R.id.workout_detail_weight);

        weightSeekBar =view.findViewById(R.id.workout_detail_weight_seek_bar);

        repsCountEditText = view.findViewById(R.id.workout_detail_reps_count_edit_text);

        saveRecordButton = view.findViewById(R.id.workout_detail_save_button);

        addListeners();
    }

/*    @Override
    public Object onRetainCustomNonConfigurationInstance() {    // Save workout settings
        Log.d(LOG_TAG, "OnSave Workout");
        return workout;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {   // Restore workout
        super.onRestoreInstanceState(savedInstanceState);
        workout = (Workout) getLastCustomNonConfigurationInstance();
        initGUI();                                                       // Redraw GUI
        Log.d(LOG_TAG, "OnRestore");
    }*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");

    }
}

