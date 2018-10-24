package my.lessons.lesson_3continue.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import my.lessons.lesson_3continue.R;
import my.lessons.lesson_3continue.list.WorkoutAdapter;
import my.lessons.lesson_3continue.utils.TagContainer;


public class WorkoutListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WorkoutAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        recyclerView= findViewById(R.id.recycler_view);
        adapter=new WorkoutAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        Toast.makeText(this,"onCreate: WorkoutList",Toast.LENGTH_SHORT).show();
        Log.d(TagContainer.LOGCAT_TAG, "OnCreate: LA");
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();

        Log.d(TagContainer.LOGCAT_TAG, "OnResume: LA");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TagContainer.LOGCAT_TAG, "OnPause: LA");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TagContainer.LOGCAT_TAG, "onDestroy: LA");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TagContainer.LOGCAT_TAG, "onStop: LA");

    }
}
