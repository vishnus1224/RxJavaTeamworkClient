package com.vishnus1224.rxjavateamworkclient;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vishnu on 8/13/2016.
 */
public class TeamworkApiClientTest {

    private final String nullApiToken = null;

    private final String emptyApiToken = "";

    private final String nullUrl = null;

    private final String emptyUrl = "";

    private final String FAKE_URL = "s3efaahh";

    private final String FAKE_TOKEN = "sdgdgwrtw";

    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullToken(){

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(nullApiToken, FAKE_URL);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyToken(){

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(emptyApiToken, FAKE_URL);

    }

    @Test
    public void testValidToken(){

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(FAKE_TOKEN, FAKE_URL);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUrl(){

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(FAKE_TOKEN, nullUrl);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyUrl(){

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(FAKE_TOKEN, emptyUrl);

    }

    @Test
    public void testValidUrl(){

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(FAKE_TOKEN, FAKE_URL);

    }
}