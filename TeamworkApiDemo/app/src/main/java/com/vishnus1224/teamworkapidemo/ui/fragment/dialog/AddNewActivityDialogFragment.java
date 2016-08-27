package com.vishnus1224.teamworkapidemo.ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.vishnus1224.teamworkapidemo.R;

/**
 * Created by Vishnu on 8/27/2016.
 */
public class AddNewActivityDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {

    private ListView addNewActivityListView;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_add_new_activity, container, false);

        addNewActivityListView = (ListView) view.findViewById(R.id.addNewActivityListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.add_new_activity_items));

        addNewActivityListView.setAdapter(adapter);

        addNewActivityListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(getActivity(), "" + i, Toast.LENGTH_SHORT).show();

    }
}
