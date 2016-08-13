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

    private final String FAKE_TOKEN = "sdgdgwrtw";

    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullToken(){

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(nullApiToken);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyToken(){

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(emptyApiToken);

    }

    @Test
    public void testValidToken(){

        TeamworkApiClient teamworkApiClient = new TeamworkApiClient(FAKE_TOKEN);


    }
}