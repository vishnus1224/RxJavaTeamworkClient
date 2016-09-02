package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.TagDto;
import com.vishnus1224.teamworkapidemo.model.TagRealmModel;

import java.util.List;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by vishnu on 02/09/16.
 */
public class TagDtoToModelListMapper implements Mapper<List<TagDto>, RealmList<TagRealmModel>> {

    @Inject
    public TagDtoToModelListMapper() {
    }

    @Override
    public RealmList<TagRealmModel> map(List<TagDto> tagDtoList) {

        if(tagDtoList == null){

            return new RealmList<>();

        }

        RealmList<TagRealmModel> tagRealmModels = new RealmList<>();

        for(TagDto tagDto : tagDtoList){

            TagRealmModel tagRealmModel = new TagRealmModel(tagDto.name);

            tagRealmModels.add(tagRealmModel);

        }

        return tagRealmModels;
    }
}
