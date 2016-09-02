package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.PeopleDto;
import com.vishnus1224.teamworkapidemo.model.PeopleRealmModel;

import java.util.List;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by vishnu on 02/09/16.
 */
public class PeopleDtoToModelListMapper implements Mapper<List<PeopleDto>, RealmList<PeopleRealmModel>> {

    @Inject
    public PeopleDtoToModelListMapper() {
    }

    @Override
    public RealmList<PeopleRealmModel> map(List<PeopleDto> peopleDtoList) {

        if(peopleDtoList == null){

            return new RealmList<>();

        }

        RealmList<PeopleRealmModel> peopleRealmModels = new RealmList<>();

        for(PeopleDto peopleDto : peopleDtoList){

            peopleRealmModels.add(new PeopleRealmModel(peopleDto.id));

        }

        return peopleRealmModels;
    }
}
