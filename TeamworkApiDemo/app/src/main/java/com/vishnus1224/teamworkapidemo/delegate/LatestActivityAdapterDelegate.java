package com.vishnus1224.teamworkapidemo.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.model.Section;
import com.vishnus1224.teamworkapidemo.ui.adapter.LatestActivitiesAdapter;

import java.util.List;

/**
 * Created by vishnu on 25/08/16.
 */
public class LatestActivityAdapterDelegate implements AdapterDelegate<LatestActivitiesAdapter.LatestActivityViewHolder> {

    private List<Section<LatestActivityResponse>> sections;

    public LatestActivityAdapterDelegate(List<Section<LatestActivityResponse>> sections) {

        this.sections = sections;

    }

    @Override
    public LatestActivitiesAdapter.LatestActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_latest_activity, parent, false);

        LatestActivitiesAdapter.LatestActivityViewHolder latestActivityViewHolder = new LatestActivitiesAdapter.LatestActivityViewHolder(view);

        return latestActivityViewHolder;
    }

    @Override
    public void onBindViewHolder(LatestActivitiesAdapter.LatestActivityViewHolder holder, int position) {

        Section<LatestActivityResponse> section = sections.get(position);

        //add views to the container, based on the number of items in the section.
        List<LatestActivityResponse> latestActivityResponses = section.getTypeList();

        holder.titleTextView.setText(section.getSectionTitle());

        //remove existing views from the container.
        holder.itemContainer.removeAllViews();

        for(int i = 0; i < latestActivityResponses.size(); i++){

            LatestActivityResponse latestActivityResponse = latestActivityResponses.get(i);

            View view = LayoutInflater.from(holder.itemContainer.getContext()).inflate(R.layout.adapter_latest_activity_container_row, holder.itemContainer, false);

            TextView rowTitleTextView = (TextView) view.findViewById(R.id.adapterLatestActivityRowTitle);

            TextView rowDescriptionTextView = (TextView) view.findViewById(R.id.adapterLatestActivityRowDescription);

            ImageView userAvatarImageView = (ImageView) view.findViewById(R.id.adapterLatestActivityRowAvatar);

            rowTitleTextView.setText(latestActivityResponse.getDescription());

            rowDescriptionTextView.setText(latestActivityResponse.getFromUsername());

            holder.itemContainer.addView(view);

        }

    }
}
