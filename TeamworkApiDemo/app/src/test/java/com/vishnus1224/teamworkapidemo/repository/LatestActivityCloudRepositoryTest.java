package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.teamworkapidemo.datastore.DataStore;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityResponseToDtoMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vishnu on 07/09/16.
 */
public class LatestActivityCloudRepositoryTest {

    @Mock
    private DataStore dataStore;

    @Mock
    private LatestActivityResponseToDtoMapper latestActivityResponseToDtoMapper;

    private LatestActivityCloudRepository latestActivityCloudRepository;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        latestActivityCloudRepository = new LatestActivityCloudRepository(dataStore, latestActivityResponseToDtoMapper);

    }

    @Test
    public void testGetAllItems() throws Exception {

        when(dataStore.getAllItems()).thenReturn(Observable.empty());

        Observable<List<LatestActivityDto>> observable = latestActivityCloudRepository.getAllItems();

        TestSubscriber testSubscriber = new TestSubscriber();

        observable.subscribe(testSubscriber);

        testSubscriber.assertNoValues();
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();

        verify(dataStore).getAllItems();

    }

    @Test
    public void testSearchItems() throws Exception {

        Observable<List<LatestActivityDto>> observable = latestActivityCloudRepository.searchItems("");

        assertNull(observable);

    }
}