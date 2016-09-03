package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishnu on 9/3/2016.
 */
public class ProjectDtoToSectionMapper implements Mapper<List<ProjectDto>, List<Section<ProjectDto>>> {

    @Override
    public List<Section<ProjectDto>> map(List<ProjectDto> projectDtoList) {

        //the sections are made based on the company id.
        String lastCompanyId = "";

        List<Section<ProjectDto>> sectionList = new ArrayList<>();

        Section<ProjectDto> section = null;

        for(int i = 0; i < projectDtoList.size(); i++){

            ProjectDto projectDto = projectDtoList.get(i);

            //if the last company id does not match the project dto company id.
            if(!projectDto.company.id.equalsIgnoreCase(lastCompanyId)){

                lastCompanyId = projectDto.company.id;

                section = new Section<>(i, projectDto.name);

                section.addToList(projectDto);

                sectionList.add(section);

            }else{

                section.addToList(projectDto);

            }

        }

        return sectionList;
    }
}
