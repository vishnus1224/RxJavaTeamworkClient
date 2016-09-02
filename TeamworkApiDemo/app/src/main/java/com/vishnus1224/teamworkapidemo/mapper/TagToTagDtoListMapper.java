package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.TagDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by vishnu on 02/09/16.
 */
public class TagToTagDtoListMapper implements Mapper<String[], List<TagDto>> {

    @Inject
    public TagToTagDtoListMapper() {

    }

    @Override
    public List<TagDto> map(String[] tags) {

        if(tags == null){

            return new ArrayList<>();

        }

        List<TagDto> tagDtoList = new ArrayList<>(tags.length);

        for(String tag : tags){

            tagDtoList.add(new TagDto(tag));

        }


        return tagDtoList;
    }
}
