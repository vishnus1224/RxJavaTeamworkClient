package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.PeopleDto;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by vishnu on 02/09/16.
 */
public class PeopleIdToPeopleDtoListMapper implements Mapper<String[], List<PeopleDto>> {

    @Inject
    public PeopleIdToPeopleDtoListMapper() {

    }

    @Override
    public List<PeopleDto> map(String[] peopleIdArray) {

        if(peopleIdArray == null){

            return new ArrayList<>();

        }

        List<PeopleDto> peopleDtoList = new ArrayList<>(peopleIdArray.length);

        for(String personId : peopleIdArray){

            peopleDtoList.add(new PeopleDto(personId));

        }

        return peopleDtoList;
    }
}
