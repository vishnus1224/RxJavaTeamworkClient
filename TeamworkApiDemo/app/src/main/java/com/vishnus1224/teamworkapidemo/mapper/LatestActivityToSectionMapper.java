package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by vishnu on 25/08/16.
 */
public class LatestActivityToSectionMapper implements Mapper<List<LatestActivityResponse>, List<Section<LatestActivityResponse>>> {


    @Inject
    public LatestActivityToSectionMapper() {

    }

    @Override
    public List<Section<LatestActivityResponse>> map(List<LatestActivityResponse> latestActivityResponses) {

        //The id of the previous project for comparing.
        String previousProjectId = "";

        Section<LatestActivityResponse> section = null;

        List<Section<LatestActivityResponse>> sections = new ArrayList<>();

        for(int i = 0; i < latestActivityResponses.size(); i++){

            LatestActivityResponse latestActivityResponse = latestActivityResponses.get(i);

            //compare the previous project id to the project id of the latestActivity
            if(!previousProjectId.equals(latestActivityResponse.getProjectId())){

                previousProjectId = latestActivityResponse.getProjectId();

                section = new Section<>(i);

                section.addToList(latestActivityResponse);

                sections.add(section);


            }else{

                section.addToList(latestActivityResponse);


            }

        }

        return sections;
    }
}
