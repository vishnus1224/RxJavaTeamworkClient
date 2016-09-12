package com.vishnus1224.teamworkapidemo.manager;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.repository.BaseRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.UnknownHostException;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;
import rx.schedulers.TestScheduler;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by vishnu on 12/09/16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Schedulers.class, AndroidSchedulers.class})
public class LatestActivityDataManagerTest {

    @Mock
    private BaseRepository latestActivityCloudRepository;

    @Mock
    private BaseRepository latestActivityRealmRepository;

    private LatestActivityDataManager latestActivityDataManager;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        mockStatic(Schedulers.class);

        mockStatic(AndroidSchedulers.class);

        latestActivityDataManager = new LatestActivityDataManager(latestActivityCloudRepository, latestActivityRealmRepository);

    }

    @Test
    public void testGetAllItems() throws Exception {

        when(latestActivityCloudRepository.getAllItems()).thenReturn(Observable.empty());

        when(latestActivityRealmRepository.getAllItems()).thenReturn(Observable.empty());

        TestScheduler testScheduler = new TestScheduler();

        //mock the schedulers.
        when(Schedulers.io()).thenReturn(testScheduler);

        when(AndroidSchedulers.mainThread()).thenReturn(testScheduler);

        TestSubscriber databaseSubscriber = new TestSubscriber();

        TestSubscriber cloudSubscriber = new TestSubscriber();

        latestActivityDataManager.getAllItems(databaseSubscriber, cloudSubscriber);

        verify(latestActivityCloudRepository).getAllItems();

        verify(latestActivityRealmRepository).getAllItems();

        verify(latestActivityRealmRepository, never()).addAll(Mockito.any(List.class));

    }

    @Test
    public void testSearchItems() throws Exception {

        when(latestActivityRealmRepository.searchItems(anyString())).thenReturn(Observable.empty());

        latestActivityDataManager.searchItems("eew", new TestSubscriber<List<LatestActivityDto>>());

        verify(latestActivityRealmRepository).searchItems(anyString());


    }
}