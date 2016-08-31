package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by vishnu on 25/08/16.
 */
public class LatestActivityToSectionMapper implements Mapper<List<LatestActivityModel>, List<Section<LatestActivityModel>>> {


    @Inject
    public LatestActivityToSectionMapper() {

    }

    @Override
    public List<Section<LatestActivityModel>> map(List<LatestActivityModel> latestActivityModels) {

        //The id of the previous project for comparing.
        String previousProjectId = "";

        Section<LatestActivityModel> section = null;

        List<Section<LatestActivityModel>> sections = new ArrayList<>();

        for(int i = 0; i < latestActivityModels.size(); i++){

            LatestActivityModel latestActivityModel = latestActivityModels.get(i);

            //compare the previous project id to the project id of the latestActivity
            if(!previousProjectId.equals(latestActivityModel.projectId)){

                previousProjectId = latestActivityModel.projectId;

                section = new Section<>(i, formatTitle(latestActivityModel));

                section.addToList(latestActivityModel);

                sections.add(section);


            }else{

                section.addToList(latestActivityModel);


            }

        }

        return sections;
    }


    private String formatTitle(LatestActivityModel latestActivityModel){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(latestActivityModel.projectName);

        //if the company name is not self, then append it to the project name.
        if(!latestActivityModel.companyName.equals("Self")){

            stringBuilder.append(" : ");

            stringBuilder.append(latestActivityModel.companyName);
        }

        return stringBuilder.toString();

    }
}
