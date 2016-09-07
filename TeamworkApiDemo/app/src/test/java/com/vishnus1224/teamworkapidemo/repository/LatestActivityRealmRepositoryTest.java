package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.teamworkapidemo.manager.RealmManager;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityDtoToModelMapper;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityModelToDtoMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vishnu on 07/09/16.
 */
public class LatestActivityRealmRepositoryTest {

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


    }

    @Test
    public void testSearchItems() throws Exception {

    }
}