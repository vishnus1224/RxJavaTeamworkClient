package com.vishnus1224.rxjavateamworkclient.client;

import com.vishnus1224.rxjavateamworkclient.api.ProjectApi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.junit.Assert.*;

/**
 * Created by Vishnu on 8/28/2016.
 */
public class ProjectApiClientTest extends ApiClientTest {

    @Before
    public void setUp() throws Exception {

        initMockWebServer();
        startMockWebServer();

    }

    @After
    public void tearDown() throws Exception{

        stopMockWebServer();

    }

    @Test
    public void testUpdatedAfterDate() throws Exception {

        ProjectApiClient projectApiClient = new ProjectApiClient(buildFakeApiConfig());

        projectApiClient.updatedAfterDate("20100603");

    }

    @Test(expected = ParseException.class)
    public void testUpdatedDateThrowsException() throws Exception{

        ProjectApiClient projectApiClient = new ProjectApiClient(buildFakeApiConfig());

        projectApiClient.updatedAfterDate("205010");

    }

    @Test
    public void testUpdatedAfterTime() throws Exception {

        ProjectApiClient projectApiClient = new ProjectApiClient(buildFakeApiConfig());

        projectApiClient.updatedAfterTime("10:18");
    }

    @Test(expected = ParseException.class)
    public void testUpdatedAfterTimeThrowsException() throws Exception{

        ProjectApiClient projectApiClient = new ProjectApiClient(buildFakeApiConfig());

        projectApiClient.updatedAfterTime("22");

    }

    @Test
    public void testCreatedAfterDate() throws Exception {

        ProjectApiClient projectApiClient = new ProjectApiClient(buildFakeApiConfig());

        projectApiClient.createdAfterDate("20100603");
    }

    @Test(expected = ParseException.class)
    public void testCreatedAfterDateThrowsException() throws Exception{

        ProjectApiClient projectApiClient = new ProjectApiClient(buildFakeApiConfig());

        projectApiClient.createdAfterDate("201003");


    }

    @Test
    public void testCreatedAfterTime() throws Exception {

        ProjectApiClient projectApiClient = new ProjectApiClient(buildFakeApiConfig());

        projectApiClient.createdAfterTime("10:18");
    }

    @Test(expected = ParseException.class)
    public void testCreatedAfterTimeThrowsException() throws Exception{

        ProjectApiClient projectApiClient = new ProjectApiClient(buildFakeApiConfig());

        projectApiClient.createdAfterTime("802");

    }
}