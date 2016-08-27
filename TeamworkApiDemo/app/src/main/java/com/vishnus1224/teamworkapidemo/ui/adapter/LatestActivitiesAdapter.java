package com.vishnus1224.teamworkapidemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.delegate.LatestActivityAdapterDelegate;
import com.vishnus1224.teamworkapidemo.manager.LatestActivityImageManager;
import com.vishnus1224.teamworkapidemo.manager.PicassoImageManager;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishnu on 25/08/16.
 */
public class LatestActivitiesAdapter extends RecyclerView.Adapter<LatestActivitiesAdapter.LatestActivityViewHolder> {

    private List<Section<LatestActivityResponse>> sections = new ArrayList<>();

    private LatestActivityAdapterDelegate latestActivityAdapterDelegate;

    public LatestActivitiesAdapter(Context context) {

        latestActivityAdapterDelegate = new LatestActivityAdapterDelegate(sections,
                new LatestActivityImageManager(new PicassoImageManager(context)));

    }

    public void updateData(List<Section<LatestActivityResponse>> sections){

        this.sections.clear();

        this.sections.addAll(sections);

        notifyDataSetChanged();

    }

    @Override
    public LatestActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return latestActivityAdapterDelegate.onCreateViewHolder(parent, viewType);

    }

    @Override
    public void onBindViewHolder(LatestActivityViewHolder holder, int position) {

        latestActivityAdapterDelegate.onBindViewHolder(holder, position);

    }

    @Override
    public int getItemCount() {

        return sections.size();

    }

    public static class LatestActivityViewHolder extends RecyclerView.ViewHolder{

        public TextView titleTextView;
        public LinearLayout itemContainer;

        public LatestActivityViewHolder(View itemView) {
            super(itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.adapterLatestActivitySectionTitle);

            itemContainer = (LinearLayout) itemView.findViewById(R.id.adapterLatestActivityItemContainer);

        }
    }
}
