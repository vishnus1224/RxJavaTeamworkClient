package com.vishnus1224.teamworkapidemo.ui.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Vishnu on 8/14/2016.
 */
public class BaseFragment extends Fragment {

    protected void hideSoftKeyboard(View view){

        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

}
