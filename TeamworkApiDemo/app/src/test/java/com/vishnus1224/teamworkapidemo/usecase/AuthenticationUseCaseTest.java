package com.vishnus1224.teamworkapidemo.usecase;

import com.vishnus1224.rxjavateamworkclient.client.AuthenticationApiClient;
import com.vishnus1224.rxjavateamworkclient.model.AccountResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Provider;

import rx.Observable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Vishnu on 9/9/2016.
 */
public class AuthenticationUseCaseTest {

    @Mock
    private Provider provider;

    @Mock
    private AuthenticationApiClient authenticationApiClient;

    private AuthenticationUseCase authenticationUseCase;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        authenticationUseCase = new AuthenticationUseCase(provider);

    }

    @Test
    public void testBuildUseCase() throws Exception {

        when(provider.get()).thenReturn(authenticationApiClient);

        when(authenticationApiClient.authenticate()).thenReturn(Observable.<AccountResponse>empty());

        authenticationUseCase.buildUseCase();

        verify(provider).get();
        verify(authenticationApiClient).authenticate();

    }
}