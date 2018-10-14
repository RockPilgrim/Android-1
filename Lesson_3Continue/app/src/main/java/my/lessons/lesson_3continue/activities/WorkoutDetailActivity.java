package my.lessons.lesson_3continue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
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
/**
 * Android-1 Lesson-4
 *
 * @dated 14.10.18
 *
 * @author Timofei Tokarev
 * @link https://github.com/RockPilgrim
 */

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
    public static final String LOG_TAG="WorkoutDetailActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);   // Get out focus from edit text

        workout = new Workout(String.valueOf(getIntent().getExtras().getSerializable(WorkoutListActivity.WORKOUT)));

        initGUI();
        Log.d(LOG_TAG,"OnCreate");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public Object onRetainCustomNonConfigurationInstance() {    // Save workout settings
        Log.d(LOG_TAG,"OnSave Workout");
        return workout;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {   // Restore workout
        super.onRestoreInstanceState(savedInstanceState);
        workout = (Workout) getLastCustomNonConfigurationInstance();
        initGUI();                                                       // Redraw GUI
        Log.d(LOG_TAG,"OnRestore");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");

    }
}

