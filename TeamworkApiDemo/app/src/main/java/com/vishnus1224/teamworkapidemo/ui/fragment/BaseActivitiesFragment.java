package com.vishnus1224.teamworkapidemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vishnus1224.teamworkapidemo.R;

/**
 * Created by Vishnu on 8/14/2016.
 */
public class BaseActivitiesFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_base_activities, container, false);

        return view;

    }
}
