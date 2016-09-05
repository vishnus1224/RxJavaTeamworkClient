package com.vishnus1224.teamworkapidemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.delegate.ProjectListAdapterDelegate;
import com.vishnus1224.teamworkapidemo.listener.ProjectListItemClickListener;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishnu on 9/5/2016.
 */
public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectListViewHolder> {

    private List<Section<ProjectDto>> projectSectionList = new ArrayList<>();

    private ProjectListAdapterDelegate projectListAdapterDelegate;

    public ProjectListAdapter(Context context, ProjectListItemClickListener projectListItemClickListener){

        projectListAdapterDelegate = new ProjectListAdapterDelegate(context, projectSectionList, projectListItemClickListener);

    }

    public void updateData(List<Section<ProjectDto>> projectSectionList){

        this.projectSectionList.clear();

        this.projectSectionList.addAll(projectSectionList);

        notifyDataSetChanged();

    }

    @Override
    public ProjectListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return projectListAdapterDelegate.onCreateViewHolder(parent, viewType);

    }

    @Override
    public void onBindViewHolder(ProjectListViewHolder holder, int position) {

        projectListAdapterDelegate.onBindViewHolder(holder, position);

    }

    @Override
    public int getItemCount() {

        return projectSectionList.size();

    }

    public static class ProjectListViewHolder extends RecyclerView.ViewHolder{

        public TextView sectionTitleTextView;

        public LinearLayout itemContainer;

        public ProjectListViewHolder(View itemView) {
            super(itemView);

            sectionTitleTextView = (TextView) itemView.findViewById(R.id.adapterProjectListSectionTitle);

            itemContainer = (LinearLayout) itemView.findViewById(R.id.adapterProjectListItemContainer);
        }
    }
}
