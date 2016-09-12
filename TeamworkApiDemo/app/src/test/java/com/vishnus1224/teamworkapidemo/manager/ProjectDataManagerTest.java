package com.vishnus1224.teamworkapidemo.manager;

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
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by vishnu on 12/09/16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Schedulers.class, AndroidSchedulers.class})
public class ProjectDataManagerTest {

    @Mock
    private BaseRepository cloudRepository;

    @Mock
    private BaseRepository realmRepository;

    private ProjectDataManager projectDataManager;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        projectDataManager = new ProjectDataManager(cloudRepository, realmRepository);

    }

    @Test
    public void testGetAllItems() throws Exception {

        when(cloudRepository.getAllItems()).thenReturn(Observable.error(new UnknownHostException()));

        when(realmRepository.getAllItems()).thenReturn(Observable.empty());

        mockStatic(Schedulers.class);

        mockStatic(AndroidSchedulers.class);

        TestScheduler testScheduler = new TestScheduler();

        //mock the schedulers.
        when(Schedulers.io()).thenReturn(testScheduler);

        when(AndroidSchedulers.mainThread()).thenReturn(testScheduler);

        TestSubscriber databaseSubscriber = new TestSubscriber();

        TestSubscriber cloudSubscriber = new TestSubscriber();

        projectDataManager.getAllItems(databaseSubscriber, cloudSubscriber);

        verify(cloudRepository).getAllItems();

        verify(realmRepository).getAllItems();

        verify(realmRepository, never()).addAll(Mockito.any(List.class));
    }

    @Test
    public void testSearchItems() throws Exception {

    }

    @Test
    public void testUnSubscribe() throws Exception {

    }
}