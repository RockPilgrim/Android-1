package my.lessons.lesson_3continue.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import my.lessons.lesson_3continue.R;



public class WorkoutListActivity extends AppCompatActivity {

    public static final String WORKOUT="workout";
    private Button buttonRowing;
    private Button buttonHugging;
    private Button buttonSleeping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        initGUI();
    }

    private void initGUI() {
        buttonRowing = findViewById(R.id.button_rowing);
        buttonHugging = findViewById(R.id.button_hugging);
        buttonSleeping = findViewById(R.id.button_sleeping);

        addListeners();
    }

    private void addListeners() {
        buttonRowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
                intent.putExtra(WORKOUT,getString(R.string.rowing_text));  // Send message to activity
                startActivity(intent);
            }
        });
        buttonHugging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
                intent.putExtra(WORKOUT,getString(R.string.hugging_text));
                startActivity(intent);
            }
        });
        buttonSleeping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
                intent.putExtra(WORKOUT,getString(R.string.sleeping_text));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

}
