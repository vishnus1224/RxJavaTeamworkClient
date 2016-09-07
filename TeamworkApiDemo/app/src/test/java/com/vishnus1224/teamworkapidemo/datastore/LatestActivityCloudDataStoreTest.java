package com.vishnus1224.teamworkapidemo.datastore;

import com.vishnus1224.rxjavateamworkclient.client.LatestActivityApiClient;
import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponseWrapper;

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
public class LatestActivityCloudDataStoreTest {

    @Mock
    private LatestActivityApiClient latestActivityApiClient;

    private LatestActivityCloudDataStore latestActivityCloudDataStore;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        latestActivityCloudDataStore = new LatestActivityCloudDataStore(latestActivityApiClient);

    }

    @Test
    public void testGetAllItems() throws Exception {

        when(latestActivityApiClient.getLatestActivity()).thenReturn(Observable.<LatestActivityResponseWrapper>empty());

        Observable<List<LatestActivityResponse>> observable = latestActivityCloudDataStore.getAllItems();

        TestSubscriber testSubscriber = new TestSubscriber();

        observable.subscribe(testSubscriber);

        testSubscriber.assertCompleted();
        testSubscriber.assertNoErrors();

        verify(latestActivityApiClient).getLatestActivity();


    }

    @Test
    public void testGetAllItemsThrowsUnknownHostException() throws Exception {

        when(latestActivityApiClient.getLatestActivity()).thenReturn(Observable.<LatestActivityResponseWrapper>error(new UnknownHostException()));

        Observable<List<LatestActivityResponse>> observable = latestActivityCloudDataStore.getAllItems();

        TestSubscriber testSubscriber = new TestSubscriber();

        observable.subscribe(testSubscriber);

        testSubscriber.assertError(UnknownHostException.class);
        testSubscriber.assertTerminalEvent();

        verify(latestActivityApiClient).getLatestActivity();

    }
}