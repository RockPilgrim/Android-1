package my.lessons.lesson_3continue.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import my.lessons.lesson_3continue.R;
import my.lessons.lesson_3continue.fragments.WorkoutDetailFragment;
import my.lessons.lesson_3continue.fragments.WorkoutListFragment;
import my.lessons.lesson_3continue.interfaces.OnListItemClickListener;

public class MainActivity extends AppCompatActivity implements OnListItemClickListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkoutListFragment listFragment = new WorkoutListFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container,listFragment);
        transaction.commit();
    }

    @Override
    public void onListItemClickListener(int index) {
        WorkoutDetailFragment detailFragment=WorkoutDetailFragment.initFragment(index);
        fragmentManager.beginTransaction()
                .replace(R.id.container, detailFragment)
                .addToBackStack("")
                .commit();
    }
}
