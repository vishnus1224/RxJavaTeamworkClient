package com.vishnus1224.teamworkapidemo;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;

/**
 * Created by Vishnu on 9/7/2016.
 */
public class TestDataStore {

    protected LatestActivityDto createLatestActivityDto(String companyId, String extraDescription,
                                                        String projectName){

        LatestActivityDto latestActivityDto = new LatestActivityDto();

        latestActivityDto.companyId = companyId;

        latestActivityDto.extraDescription = extraDescription;

        latestActivityDto.projectName = projectName;

        return latestActivityDto;
    }
}
