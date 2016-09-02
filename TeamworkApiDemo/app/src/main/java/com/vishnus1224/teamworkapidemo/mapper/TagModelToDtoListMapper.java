package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.TagDto;
import com.vishnus1224.teamworkapidemo.model.TagRealmModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Converts the realm list of tag models to a list of tag dto objects.
 * Created by Vishnu on 9/2/2016.
 */
public class TagModelToDtoListMapper implements Mapper<RealmList<TagRealmModel>, List<TagDto>>{

    @Inject
    public TagModelToDtoListMapper() {
    }

    @Override
    public List<TagDto> map(RealmList<TagRealmModel> tagRealmModels) {

        if(tagRealmModels == null){

            return new ArrayList<>();

        }

        List<TagDto> tagDtoList = new ArrayList<>(tagRealmModels.size());

        for (TagRealmModel tagRealmModel: tagRealmModels) {

            tagDtoList.add(new TagDto(tagRealmModel.name));

        }

        return tagDtoList;
    }
}
