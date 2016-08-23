package com.vishnus1224.rxjavateamworkclient.client;

import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;

import org.junit.Before;
import org.junit.Test;

import retrofit2.Retrofit;

import static org.junit.Assert.*;

/**
 * Created by Vishnu on 8/13/2016.
 */
public class TeamworkApiClientTest {

    private final String FAKE_URL_1 = "https://www.xyz.com";

    private final String FAKE_URL_2 = "https://www.xyz.co.nt";

    private final String FAKE_TOKEN = "sdgdgwrtw";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testDifferentRetrofitInstances(){

        TeamworkApiConfig config1 = new TeamworkApiConfig(FAKE_TOKEN, FAKE_URL_1);
        TeamworkApiConfig config2 = new TeamworkApiConfig(FAKE_TOKEN, FAKE_URL_2);

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(config1);

        Retrofit retrofit1 = teamworkApiClient.getRetrofit();

        teamworkApiClient = new TeamworkApiClient(config2);

        Retrofit retrofit2 = teamworkApiClient.getRetrofit();

        assertNotEquals(retrofit1, retrofit2);
    }

    @Test
    public void testSameRetrofitInstances(){

        TeamworkApiConfig config = new TeamworkApiConfig(FAKE_TOKEN, FAKE_URL_1);

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(config);

        Retrofit retrofit1 = teamworkApiClient.getRetrofit();

        teamworkApiClient = new TeamworkApiClient(config);

        Retrofit retrofit2 = teamworkApiClient.getRetrofit();

        assertEquals(retrofit1, retrofit2);

    }
}