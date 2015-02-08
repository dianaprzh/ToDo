package co.mobilemaker.todo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class CreateTaskFragment extends Fragment {

    public static final String TASK = "TASK";
    EditText mEditTextTitle;

    public CreateTaskFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_task, container, false);
        mEditTextTitle = (EditText)rootView.findViewById(R.id.edit_text_title);
        Button button = (Button)rootView.findViewById(R.id.button_done);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                Intent intent = new Intent();
                intent.putExtra(TASK, mEditTextTitle.getText().toString());
                activity.setResult(Activity.RESULT_OK,intent);
                activity.finish();
            }
        });
        return rootView;
    }
}
