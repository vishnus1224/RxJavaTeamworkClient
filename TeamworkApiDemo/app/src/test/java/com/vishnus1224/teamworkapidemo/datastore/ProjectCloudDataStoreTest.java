package com.vishnus1224.teamworkapidemo.datastore;

import com.vishnus1224.rxjavateamworkclient.client.ProjectApiClient;
import com.vishnus1224.rxjavateamworkclient.model.ProjectResponse;
import com.vishnus1224.rxjavateamworkclient.model.ProjectResponseWrapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.UnknownHostException;
import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vishnu on 07/09/16.
 */
public class ProjectCloudDataStoreTest {

    @Mock
    private ProjectApiClient projectApiClient;

    private ProjectCloudDataStore projectCloudDataStore;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        projectCloudDataStore = new ProjectCloudDataStore(projectApiClient);

    }

    @Test
    public void testGetAllItems() throws Exception {

        when(projectApiClient.getAllProjects()).thenReturn(Observable.<ProjectResponseWrapper>empty());

        Observable<List<ProjectResponse>> observable = projectCloudDataStore.getAllItems();

        TestSubscriber testSubscriber = new TestSubscriber();

        observable.subscribe(testSubscriber);

        testSubscriber.assertCompleted();
        testSubscriber.assertNoErrors();
        testSubscriber.assertTerminalEvent();

        verify(projectApiClient).getAllProjects();

    }

    @Test
    public void testGetAllItemsThrowsUnknownHostException() throws Exception{

        when(projectApiClient.getAllProjects()).thenReturn(Observable.<ProjectResponseWrapper>error(new UnknownHostException()));

        Observable<List<ProjectResponse>> observable = projectCloudDataStore.getAllItems();

        TestSubscriber testSubscriber = new TestSubscriber();

        observable.subscribe(testSubscriber);

        testSubscriber.assertError(UnknownHostException.class);
        testSubscriber.assertTerminalEvent();

        verify(projectApiClient).getAllProjects();


    }


}