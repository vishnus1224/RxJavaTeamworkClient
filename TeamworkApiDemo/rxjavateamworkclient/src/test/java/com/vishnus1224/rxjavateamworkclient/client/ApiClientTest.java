package com.vishnus1224.rxjavateamworkclient.client;

import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;

import java.io.IOException;

import okhttp3.mockwebserver.MockWebServer;

/**
 * Created by Vishnu on 8/28/2016.
 */
public class ApiClientTest {

    private final String FAKE_TOKEN = "sdgdgwrtw";

    protected MockWebServer mockWebServer;

    protected void initMockWebServer(){

        mockWebServer = new MockWebServer();

    }

    protected void startMockWebServer(){

        try {
            mockWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void stopMockWebServer(){

        try {
            mockWebServer.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected TeamworkApiConfig buildFakeApiConfig(){

        return new TeamworkApiConfig(FAKE_TOKEN, mockWebServer.url("/").toString());

    }
}
