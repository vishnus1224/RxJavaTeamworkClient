package com.vishnus1224.rxjavateamworkclient;

import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vishnu on 8/13/2016.
 */
public class TeamworkApiConfigTest {

    private final String nullApiToken = null;

    private final String emptyApiToken = "";

    private final String nullUrl = null;

    private final String emptyUrl = "";

    private final String FAKE_URL = "https://www.xyz.com";

    private final String FAKE_TOKEN = "sdgdgwrtw";

    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullToken(){

        TeamworkApiConfig teamworkApiClient = new TeamworkApiConfig(nullApiToken, FAKE_URL);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyToken(){

        TeamworkApiConfig teamworkApiClient = new TeamworkApiConfig(emptyApiToken, FAKE_URL);

    }

    @Test
    public void testValidToken(){

        TeamworkApiConfig teamworkApiClient = new TeamworkApiConfig(FAKE_TOKEN, FAKE_URL);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUrl(){

        TeamworkApiConfig teamworkApiClient = new TeamworkApiConfig(FAKE_TOKEN, nullUrl);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyUrl(){

        TeamworkApiConfig teamworkApiClient = new TeamworkApiConfig(FAKE_TOKEN, emptyUrl);

    }

    @Test
    public void testValidUrl(){

        TeamworkApiConfig teamworkApiClient = new TeamworkApiConfig(FAKE_TOKEN, FAKE_URL);

    }
}