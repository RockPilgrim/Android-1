package my.lessons.lesson_3continue.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import my.lessons.lesson_3continue.R;
import my.lessons.lesson_3continue.interfaces.OnListItemClickListener;
import my.lessons.lesson_3continue.list.WorkoutAdapter;
import my.lessons.lesson_3continue.utils.TagContainer;


public class WorkoutListFragment extends Fragment {

    private RecyclerView recyclerView;
    private WorkoutAdapter adapter;

    private OnListItemClickListener listener;

    @Override
    public void onAttach(Context context) {
        if (context instanceof OnListItemClickListener)
            listener=(OnListItemClickListener) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_workout_list,container,false);
        recyclerView= root.findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new WorkoutAdapter(listener);
        recyclerView.setAdapter(adapter);

        Toast.makeText(getContext(),"onCreate: WorkoutList",Toast.LENGTH_SHORT).show();

        return root;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TagContainer.LOGCAT_TAG, "OnCreate: LA");
    }
    @Override
    public void onResume() {
        super.onResume();
//        adapter.notifyDataSetChanged();
        Log.d(TagContainer.LOGCAT_TAG, "OnResume: LA");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TagContainer.LOGCAT_TAG, "OnPause: LA");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TagContainer.LOGCAT_TAG, "onDestroy: LA");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TagContainer.LOGCAT_TAG, "onStop: LA");

    }
}
