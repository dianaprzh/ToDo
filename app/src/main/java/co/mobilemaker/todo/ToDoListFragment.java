package co.mobilemaker.todo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ToDoListFragment extends ListFragment {

    ArrayList<String> mTasks;
    ArrayAdapter<String> mAdapter;
    public ToDoListFragment() {
        mTasks = new ArrayList<>();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_item_to_do, R.id.text_view_title, mTasks);
        setListAdapter(mAdapter);
        if(mTasks.isEmpty()){
            TextView textView = (TextView)getActivity().findViewById(R.id.text_view_empty);
            textView.setText("You haven't added anything yet.");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment_to_do_list, menu);
    }

    public void addTask(String task){
        mAdapter.add(task);
        TextView textView = (TextView)getActivity().findViewById(R.id.text_view_empty);
        textView.setText("");
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
