package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.rxjavateamworkclient.model.ProjectResponse;
import com.vishnus1224.teamworkapidemo.datastore.DataStore;
import com.vishnus1224.teamworkapidemo.mapper.ProjectResponseToDtoMapper;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import rx.Observable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vishnu on 07/09/16.
 */
public class ProjectCloudRepositoryTest {

    @Mock
    private DataStore dataStore;

    @Mock
    private ProjectResponseToDtoMapper projectResponseToDtoMapper;

    private ProjectCloudRepository projectCloudRepository;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        projectCloudRepository = new ProjectCloudRepository(dataStore, projectResponseToDtoMapper);

    }

    @Test
    public void testGetAllItems() throws Exception {

        when(dataStore.getAllItems()).thenReturn(Observable.empty());

        projectCloudRepository.getAllItems();

        verify(dataStore).getAllItems();

        verify(projectResponseToDtoMapper, never()).map(new ProjectResponse());

    }

    @Test
    public void testSearchItems() throws Exception {

        Observable<List<ProjectDto>> observable = projectCloudRepository.searchItems("");

        assertNull(observable);

    }
}