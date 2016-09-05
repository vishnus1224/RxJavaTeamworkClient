package com.vishnus1224.teamworkapidemo.delegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.listener.ProjectListItemClickListener;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.model.Section;
import com.vishnus1224.teamworkapidemo.ui.adapter.ProjectListAdapter;
import com.vishnus1224.teamworkapidemo.ui.customview.OneLetterImageView;

import java.util.List;

/**
 * Created by Vishnu on 9/5/2016.
 */
public class ProjectListAdapterDelegate implements AdapterDelegate<ProjectListAdapter.ProjectListViewHolder> {

    private List<Section<ProjectDto>> sectionList;

    private ProjectListItemClickListener listItemClickListener;

    private Context context;

    public ProjectListAdapterDelegate(Context context, List<Section<ProjectDto>> sectionList, ProjectListItemClickListener listItemClickListener) {

        this.context = context;

        this.sectionList = sectionList;

        this.listItemClickListener = listItemClickListener;
    }

    @Override
    public ProjectListAdapter.ProjectListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_project_list, parent, false);

        return new ProjectListAdapter.ProjectListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ProjectListAdapter.ProjectListViewHolder holder, int position) {

        Section<ProjectDto> section = sectionList.get(position);

        holder.sectionTitleTextView.setText(section.getSectionTitle());

        holder.itemContainer.removeAllViews();

        List<ProjectDto> projectDtoList = section.getTypeList();

        for(final ProjectDto projectDto : projectDtoList){

            View view = LayoutInflater.from(context).inflate(R.layout.adapter_project_list_container_row, holder.itemContainer, false);

            LinearLayout container = (LinearLayout) view.findViewById(R.id.adapterProjectRowDetailContainer);

            OneLetterImageView firstLetterImageView = (OneLetterImageView) view.findViewById(R.id.adapterProjectsRowImageFirstLetter);

            firstLetterImageView.setText(projectDto.name.substring(0,1));

            TextView titleTextView = (TextView) view.findViewById(R.id.adapterProjectsRowTitle);

            final CheckBox starredCheckBox = (CheckBox) view.findViewById(R.id.adapterProjectRowStar);

            titleTextView.setText(projectDto.name);

            starredCheckBox.setChecked(projectDto.starred);

            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(listItemClickListener != null){

                        listItemClickListener.onProjectClicked(projectDto);

                    }
                }
            });

            starredCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                    starredCheckBox.setChecked(checked);

                    if(listItemClickListener != null) {

                        if (checked) {

                            listItemClickListener.onProjectStarred(projectDto);

                        } else {

                            listItemClickListener.onProjectUnStarred(projectDto);

                        }

                    }

                }
            });


            holder.itemContainer.addView(view);

        }

    }
}
