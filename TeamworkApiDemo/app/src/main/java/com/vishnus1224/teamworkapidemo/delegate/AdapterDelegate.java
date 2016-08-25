package com.vishnus1224.teamworkapidemo.delegate;


import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by vishnu on 25/08/16.
 */
public interface AdapterDelegate<VH extends RecyclerView.ViewHolder> {

    VH onCreateViewHolder(ViewGroup parent, int viewType);

    void onBindViewHolder(VH holder, int position);

}
