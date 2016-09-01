package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by vishnu on 25/08/16.
 */
public class LatestActivityToSectionMapper implements Mapper<List<LatestActivityDto>, List<Section<LatestActivityDto>>> {


    @Inject
    public LatestActivityToSectionMapper() {

    }

    @Override
    public List<Section<LatestActivityDto>> map(List<LatestActivityDto> latestActivityDtoList) {

        //The id of the previous project for comparing.
        String previousProjectId = "";

        Section<LatestActivityDto> section = null;

        List<Section<LatestActivityDto>> sections = new ArrayList<>();

        for(int i = 0; i < latestActivityDtoList.size(); i++){

            LatestActivityDto latestActivityDto = latestActivityDtoList.get(i);

            //compare the previous project id to the project id of the latestActivity
            if(!previousProjectId.equals(latestActivityDto.projectId)){

                previousProjectId = latestActivityDto.projectId;

                section = new Section<>(i, formatTitle(latestActivityDto));

                section.addToList(latestActivityDto);

                sections.add(section);


            }else{

                section.addToList(latestActivityDto);


            }

        }

        return sections;
    }


    private String formatTitle(LatestActivityDto latestActivityDto){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(latestActivityDto.projectName);

        //if the company name is not self, then append it to the project name.
        if(!latestActivityDto.companyName.equals("Self")){

            stringBuilder.append(" : ");

            stringBuilder.append(latestActivityDto.companyName);
        }

        return stringBuilder.toString();

    }
}
