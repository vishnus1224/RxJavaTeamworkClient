package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by vishnu on 24/08/16.
 */
public class LatestActivityRepository implements BaseRepository<LatestActivityResponse> {

    @Inject
    public LatestActivityRepository() {
    }

    @Override
    public void add(LatestActivityResponse latestActivityResponse) {

    }

    @Override
    public LatestActivityResponse removeItem() {
        return null;
    }

    @Override
    public LatestActivityResponse getItem() {
        return null;
    }

    @Override
    public List<LatestActivityResponse> getAllItems() {
        return null;
    }
}
