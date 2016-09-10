package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.teamworkapidemo.RealmMockProvider;
import com.vishnus1224.teamworkapidemo.manager.RealmManager;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityDtoToModelMapper;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityModelToDtoMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vishnu on 07/09/16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Realm.class, RealmResults.class, RealmQuery.class})
public class LatestActivityRealmRepositoryTest extends RealmMockProvider {

    @Mock
    private RealmManager realmManager;

    @Mock
    private LatestActivityModelToDtoMapper latestActivityModelToDtoMapper;

    @Mock
    private LatestActivityDtoToModelMapper latestActivityDtoToModelMapper;

    private LatestActivityRealmRepository latestActivityRealmRepository;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        latestActivityRealmRepository = new LatestActivityRealmRepository(realmManager, latestActivityModelToDtoMapper, latestActivityDtoToModelMapper);

    }

    @Test
    public void testAdd() throws Exception {

        LatestActivityDto latestActivityDto = new LatestActivityDto();

        LatestActivityModel latestActivityModel = new LatestActivityModel();

        when(latestActivityDtoToModelMapper.map(latestActivityDto)).thenReturn(latestActivityModel);

        latestActivityRealmRepository.add(latestActivityDto);

        verify(latestActivityDtoToModelMapper).map(latestActivityDto);

        verify(realmManager).addToRealm(latestActivityModel);

    }

    @Test
    public void testAddAll() throws Exception {

        List<LatestActivityDto> latestActivityDtoList = new ArrayList<>();

        List<LatestActivityModel> latestActivityModelList = new ArrayList<>(latestActivityDtoList.size());

        latestActivityRealmRepository.addAll(latestActivityDtoList);

        verify(realmManager).addAllToRealm(latestActivityModelList);

        verify(latestActivityDtoToModelMapper, never()).map(new LatestActivityDto());

    }

    @Test
    public void testGetAllItems() throws Exception {

        Realm realm = mockRealm();

        RealmResults<LatestActivityModel> results = mockRealmResults();

        RealmQuery<LatestActivityModel> realmQuery = mockRealmQuery();

        when(realmManager.newRealm()).thenReturn(realm);

        when(realm.where(LatestActivityModel.class)).thenReturn(realmQuery);

        when(realmQuery.findAll()).thenReturn(results);

        when(latestActivityModelToDtoMapper.map(results)).thenReturn(new ArrayList<LatestActivityDto>());

        Observable<List<LatestActivityDto>> observable = latestActivityRealmRepository.getAllItems();

        TestSubscriber testSubscriber = new TestSubscriber();

        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();

        verify(realmManager).newRealm();

        verify(latestActivityModelToDtoMapper).map(results);

        verify(realm).close();
    }

    @Test
    public void testSearchItems() throws Exception {

        Realm realm = mockRealm();

        RealmResults<LatestActivityModel> realmResults = mockRealmResults();

        RealmQuery<LatestActivityModel> realmQuery = mockRealmQuery();

        when(realmManager.newRealm()).thenReturn(realm);

        when(realm.where(LatestActivityModel.class)).thenReturn(realmQuery);

        when(realmQuery.contains("description", "zyx", Case.INSENSITIVE)).thenReturn(realmQuery);

        when(realmQuery.contains("fromUsername", "zyx", Case.INSENSITIVE)).thenReturn(realmQuery);

        when(realmQuery.contains("formattedDescription", "zyx", Case.INSENSITIVE)).thenReturn(realmQuery);

        when(realmQuery.or()).thenReturn(realmQuery);

        when(realmQuery.findAll()).thenReturn(realmResults);

        when(latestActivityModelToDtoMapper.map(realmResults)).thenReturn(new ArrayList<LatestActivityDto>());

        Observable<List<LatestActivityDto>> observable = latestActivityRealmRepository.searchItems("zyx");

        TestSubscriber testSubscriber = new TestSubscriber();

        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

        testSubscriber.assertCompleted();

        verify(realmManager).newRealm();

        verify(latestActivityModelToDtoMapper).map(realmResults);

        verify(realm).close();
    }


}