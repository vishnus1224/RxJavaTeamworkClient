package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.teamworkapidemo.manager.RealmManager;
import com.vishnus1224.teamworkapidemo.mapper.ProjectDtoToModelMapper;
import com.vishnus1224.teamworkapidemo.mapper.ProjectModelToDtoMapper;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.model.ProjectRealmModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by Vishnu on 9/3/2016.
 */
public class ProjectRealmRepository implements BaseRepository<ProjectDto> {

    private RealmManager realmManager;

    private ProjectModelToDtoMapper projectModelToDtoMapper;

    private ProjectDtoToModelMapper projectDtoToModelMapper;

    @Inject
    public ProjectRealmRepository(RealmManager realmManager, ProjectModelToDtoMapper projectModelToDtoMapper, ProjectDtoToModelMapper projectDtoToModelMapper) {
        this.realmManager = realmManager;
        this.projectModelToDtoMapper = projectModelToDtoMapper;
        this.projectDtoToModelMapper = projectDtoToModelMapper;
    }

    @Override
    public void add(ProjectDto projectDto) {

        realmManager.addToRealm(projectDtoToModelMapper.map(projectDto));

    }

    @Override
    public void addAll(List<ProjectDto> projectDtoList) {

        List<ProjectRealmModel> projectRealmModels = new ArrayList<>(projectDtoList.size());

        for(ProjectDto projectDto : projectDtoList){

            projectRealmModels.add(projectDtoToModelMapper.map(projectDto));

        }

        realmManager.addAllToRealm(projectRealmModels);

    }

    @Override
    public ProjectDto removeItem() {
        return null;
    }

    @Override
    public Observable<ProjectDto> getItem() {
        return null;
    }

    @Override
    public Observable<List<ProjectDto>> getAllItems() {

        Realm realm = realmManager.newRealm();

        RealmResults<ProjectRealmModel> realmModelList = realm.where(ProjectRealmModel.class).findAll();

        List<ProjectDto> projectDtoList = new ArrayList<>(realmModelList.size());

        for(ProjectRealmModel projectRealmModel : realmModelList){

            projectDtoList.add(projectModelToDtoMapper.map(projectRealmModel));

        }

        realm.close();

        return Observable.just(projectDtoList);
    }

    @Override
    public Observable<List<ProjectDto>> searchItems(String searchString) {
        return null;
    }
}
