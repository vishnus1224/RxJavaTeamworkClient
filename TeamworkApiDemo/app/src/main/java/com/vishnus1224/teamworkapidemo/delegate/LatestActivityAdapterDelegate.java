package com.vishnus1224.teamworkapidemo.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.listener.LatestActivityItemClickListener;
import com.vishnus1224.teamworkapidemo.manager.LatestActivityImageManager;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.Section;
import com.vishnus1224.teamworkapidemo.ui.adapter.LatestActivitiesAdapter;
import com.vishnus1224.teamworkapidemo.util.DateTimeHelper;

import java.util.List;


/**
 * Created by vishnu on 25/08/16.
 */
public class LatestActivityAdapterDelegate implements AdapterDelegate<LatestActivitiesAdapter.LatestActivityViewHolder> {

    private List<Section<LatestActivityDto>> sections;

    private StringBuilder stringBuilder;

    private LatestActivityImageManager latestActivityImageManager;

    private LatestActivityItemClickListener latestActivityItemClickListener;

    public LatestActivityAdapterDelegate(List<Section<LatestActivityDto>> sections, LatestActivityImageManager
            latestActivityImageManager, LatestActivityItemClickListener latestActivityItemClickListener) {

        this.sections = sections;

        this.latestActivityImageManager = latestActivityImageManager;

        this.latestActivityItemClickListener = latestActivityItemClickListener;

        stringBuilder = new StringBuilder();


    }

    @Override
    public LatestActivitiesAdapter.LatestActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_latest_activity, parent, false);

        LatestActivitiesAdapter.LatestActivityViewHolder latestActivityViewHolder = new LatestActivitiesAdapter.LatestActivityViewHolder(view);

        return latestActivityViewHolder;
    }

    @Override
    public void onBindViewHolder(LatestActivitiesAdapter.LatestActivityViewHolder holder, int position) {

        Section<LatestActivityDto> section = sections.get(position);

        //add views to the container, based on the number of items in the section.
        List<LatestActivityDto> latestActivityDtoList = section.getTypeList();

        holder.titleTextView.setText(section.getSectionTitle());

        //remove existing views from the container.
        holder.itemContainer.removeAllViews();

        for (int i = 0; i < latestActivityDtoList.size(); i++) {

            final LatestActivityDto latestActivityDto = latestActivityDtoList.get(i);

            View view = LayoutInflater.from(holder.itemContainer.getContext()).inflate(R.layout.adapter_latest_activity_container_row, holder.itemContainer, false);

            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.adapterLatestActivityRowTypeContainer);

            TextView rowTitleTextView = (TextView) view.findViewById(R.id.adapterLatestActivityRowTitle);

            TextView rowDescriptionTextView = (TextView) view.findViewById(R.id.adapterLatestActivityRowDescription);

            ImageView activityTypeImageView = (ImageView) view.findViewById(R.id.adapterLatestActivityRowTypeImage);

            activityTypeImageView.setImageResource(latestActivityImageManager.
                    getIconForLatestActivity(latestActivityDto.type));

            ImageView userAvatarImageView = (ImageView) view.findViewById(R.id.adapterLatestActivityRowAvatar);

            latestActivityImageManager.loadImage(latestActivityDto.fromUserAvatarUrl, userAvatarImageView);

            rowTitleTextView.setText(latestActivityDto.description);

            String formattedDescription = formatDescription(latestActivityDto);

            rowDescriptionTextView.setText(formattedDescription);

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (latestActivityItemClickListener != null) {

                        handleItemClick(latestActivityDto);

                    }

                }
            });

            userAvatarImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (latestActivityItemClickListener != null) {

                        latestActivityItemClickListener.onAvatarClicked(latestActivityDto);

                    }

                }
            });

            holder.itemContainer.addView(view);

        }

    }

    private void handleItemClick(LatestActivityDto latestActivityModel) {

        if (latestActivityModel.type.equalsIgnoreCase("project")) {

            latestActivityItemClickListener.onProjectClicked(latestActivityModel);

        } else if (latestActivityModel.type.equalsIgnoreCase("task")) {

            latestActivityItemClickListener.onTaskClicked(latestActivityModel);

        }

    }


    private String formatDescription(LatestActivityDto latestActivityModel) {

        stringBuilder.setLength(0);

        stringBuilder.append("added by ");

        stringBuilder.append(latestActivityModel.fromUsername);

        DateTimeHelper dateTimeHelper = new DateTimeHelper();

        String dateToDisplay = dateTimeHelper.extractDayAndTimeFromDate(latestActivityModel.dateTime);

        stringBuilder.append(dateToDisplay);


        return stringBuilder.toString();
    }
}
