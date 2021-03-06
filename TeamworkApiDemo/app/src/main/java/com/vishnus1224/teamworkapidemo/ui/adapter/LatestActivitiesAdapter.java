package com.vishnus1224.teamworkapidemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.delegate.LatestActivityAdapterDelegate;
import com.vishnus1224.teamworkapidemo.listener.LatestActivityItemClickListener;
import com.vishnus1224.teamworkapidemo.manager.LatestActivityImageManager;
import com.vishnus1224.teamworkapidemo.manager.PicassoImageManager;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishnu on 25/08/16.
 */
public class LatestActivitiesAdapter extends RecyclerView.Adapter<LatestActivitiesAdapter.LatestActivityViewHolder> {

    private List<Section<LatestActivityDto>> sections = new ArrayList<>();

    private LatestActivityAdapterDelegate latestActivityAdapterDelegate;


    public LatestActivitiesAdapter(Context context, LatestActivityItemClickListener latestActivityItemClickListener) {

        latestActivityAdapterDelegate = new LatestActivityAdapterDelegate(sections,
                new LatestActivityImageManager(new PicassoImageManager(context)), latestActivityItemClickListener);

    }

    public void updateData(List<Section<LatestActivityDto>> sections){

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
