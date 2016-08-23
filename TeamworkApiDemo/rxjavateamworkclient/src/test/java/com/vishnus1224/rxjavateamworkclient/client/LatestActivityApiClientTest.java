package com.vishnus1224.rxjavateamworkclient.client;

import com.vishnus1224.rxjavateamworkclient.api.AuthenticationApi;
import com.vishnus1224.rxjavateamworkclient.api.LatestActivityApi;
import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponseWrapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;

/**
 * Created by Vishnu on 8/22/2016.
 */
public class LatestActivityApiClientTest {

    private final String FAKE_URL = "https://www.xyz.com";

    private final String FAKE_TOKEN = "sdgdgwrtw";


    @Mock
    private LatestActivityApi latestActivityApi;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void testGetLatestActivity() throws Exception {

        MockWebServer mockWebServer = new MockWebServer();

        MockResponse mk = new MockResponse();

        mk.setResponseCode(200);
        mockWebServer.enqueue(mk);
        mockWebServer.start();

        TeamworkApiConfig teamworkApiConfig = new TeamworkApiConfig(FAKE_TOKEN,
                mockWebServer.url("/").toString());

        LatestActivityApiClient latestActivityApiClient = new LatestActivityApiClient(teamworkApiConfig)
                .maxItems(100).onlyStarred(true);

        Observable<LatestActivityResponseWrapper> observable = latestActivityApiClient.getLatestActivity();

        TestSubscriber<LatestActivityResponseWrapper> testSubscriber = new TestSubscriber();

        observable.subscribe(testSubscriber);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();

        assertThat(recordedRequest.getPath(), containsString("maxItems=100"));
        assertThat(recordedRequest.getPath(), containsString("onlyStarred=true"));


        mockWebServer.shutdown();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxItems() throws Exception {

        MockWebServer mockWebServer = new MockWebServer();
        mockWebServer.start();

        TeamworkApiConfig teamworkApiConfig = new TeamworkApiConfig(FAKE_TOKEN,
                mockWebServer.url("/").toString());

        LatestActivityApiClient latestActivityApiClient = new LatestActivityApiClient(teamworkApiConfig);

        latestActivityApiClient.maxItems(-20);

        mockWebServer.shutdown();

    }

    private LatestActivityResponseWrapper mockWrapper(){

        LatestActivityResponseWrapper latestActivityResponseWrapper = new LatestActivityResponseWrapper();

        latestActivityResponseWrapper.setLatestActivityResponseList(mockLatestActivity());

        return latestActivityResponseWrapper;

    }

    private List<LatestActivityResponse> mockLatestActivity(){

        List<LatestActivityResponse> latestActivityResponses = new ArrayList<>();

        latestActivityResponses.add(mockLatestActivityResponse());

        return latestActivityResponses;
    }

    private LatestActivityResponse mockLatestActivityResponse(){

        LatestActivityResponse latestActivityResponse = new LatestActivityResponse();

        latestActivityResponse.setCompanyId("qwerty");

        latestActivityResponse.setForUsername("test");

        return latestActivityResponse;

    }

}