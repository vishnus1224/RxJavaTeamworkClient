package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.PeopleDto;
import com.vishnus1224.teamworkapidemo.model.PeopleRealmModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Converts a realm list to an array list of dto objects.
 * Created by Vishnu on 9/2/2016.
 */
public class PeopleModelToDtoListMapper implements Mapper<RealmList<PeopleRealmModel>, List<PeopleDto>>{

    @Inject
    public PeopleModelToDtoListMapper() {
    }

    @Override
    public List<PeopleDto> map(RealmList<PeopleRealmModel> peopleRealmModels) {

        if(peopleRealmModels == null){

            return new ArrayList<>();

        }

        List<PeopleDto> peopleDtoList = new ArrayList<>(peopleRealmModels.size());

        for (PeopleRealmModel peopleRealmModel : peopleRealmModels){

            peopleDtoList.add(new PeopleDto(peopleRealmModel.id));

        }

        return peopleDtoList;
    }
}
