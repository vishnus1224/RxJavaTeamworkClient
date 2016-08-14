package com.vishnus1224.teamworkapidemo.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.vishnus1224.teamworkapidemo.R;

public class MainActivity extends BaseActivity {

    private FrameLayout contentFrameLayout;

    private ListView drawerItemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        setDrawerListAdapter();

    }

    private void setupViews() {

        contentFrameLayout = (FrameLayout) findViewById(R.id.drawerContentFrame);

        drawerItemsListView = (ListView) findViewById(R.id.drawerItemListView);

    }

    private void setDrawerListAdapter() {

        String[] items = getResources().getStringArray(R.array.drawer_items);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, items);

        drawerItemsListView.setAdapter(arrayAdapter);
    }

}
