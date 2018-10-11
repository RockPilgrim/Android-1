package my.lessons.lesson_3continue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Calendar;
import my.lessons.lesson_3continue.R;
import my.lessons.lesson_3continue.model.Workout;


public class WorkoutDetailActivity extends AppCompatActivity {

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
    private Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        workout = new Workout(String.valueOf(getIntent().getExtras().getSerializable(WorkoutListActivity.WORKOUT)));//, "Подтягивания на перекладине", 0, Calendar.getInstance(), 0);
        initGUI();
        baseSettings();
    }

    private void baseSettings() {

    }

    private void saveRecord() {

    }

    private void checkRecord(String w, String reps) {

        try {
            int weightNew = Integer.parseInt(w);
            int weightOld = Integer.parseInt(recordWeight.getText().toString());

            int repsNew = Integer.parseInt(reps);
            int repsOld = Integer.parseInt(recordRepsCount.getText().toString());

            if (weightNew >= weightOld && repsNew >= repsOld) {
                workout.setRecordWeight(weightNew);
                workout.setRecordRepsCount(repsNew);
                workout.setRecordDate(Calendar.getInstance());
                recordWeight.setText(String.valueOf(weightNew));
                recordRepsCount.setText(String.valueOf(repsNew));
                recordDate.setText(workout.getRecordDate());
            }
        } catch (NumberFormatException e) {
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

    private void addListeners() {
        shareButton.setOnClickListener(new View.OnClickListener() {   // Share record with friends
            @Override
            public void onClick(View v) {
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

    private void initGUI() {
        title = findViewById(R.id.workout_detail_title);
        title.setText(workout.getTitle());

        recordDate = findViewById(R.id.workout_detail_record_date);
        recordDate.setText(workout.getRecordDate());

        recordRepsCount = findViewById(R.id.workout_detail_record_reps_count);
        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));

        recordWeight = findViewById(R.id.workout_detail_record_weight);
        recordWeight.setText(String.valueOf(workout.getRecordWeight()));

        description = findViewById(R.id.workout_detail_description);
        recordsLayout = findViewById(R.id.records_layout);
        description.setText(workout.getDescription());

        shareButton = findViewById(R.id.workout_detail_share_button);

        weight = findViewById(R.id.workout_detail_weight);

        weightSeekBar = findViewById(R.id.workout_detail_weight_seek_bar);

        repsCountEditText = findViewById(R.id.workout_detail_reps_count_edit_text);

        saveRecordButton = findViewById(R.id.workout_detail_save_button);

        addListeners();
    }


}

