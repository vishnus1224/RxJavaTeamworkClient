package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Vishnu on 9/3/2016.
 */
public class ProjectDtoToSectionMapper implements Mapper<List<ProjectDto>, List<Section<ProjectDto>>> {

    @Inject
    public ProjectDtoToSectionMapper() {
    }

    @Override
    public List<Section<ProjectDto>> map(List<ProjectDto> projectDtoList) {

        //the sections are made based on the company id.
        String lastCompanyId = "";

        final List<Section<ProjectDto>> sectionList = new ArrayList<>();

        Section<ProjectDto> section = null;

        //make a section from starred projects first.
        Observable.from(projectDtoList).filter(new Func1<ProjectDto, Boolean>() {
            @Override
            public Boolean call(ProjectDto projectDto) {
                return projectDto.starred;
            }
        }).toList().subscribe(new Action1<List<ProjectDto>>() {
            @Override
            public void call(List<ProjectDto> projectDtoList) {

                if(!projectDtoList.isEmpty()){

                    Section<ProjectDto> section = new Section<>(0, "Starred Projects", projectDtoList);

                    sectionList.add(section);
                }
            }
        });


        for(int i = 1; i < projectDtoList.size(); i++){

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
