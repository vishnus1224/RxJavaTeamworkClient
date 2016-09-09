package com.vishnus1224.teamworkapidemo.usecase;

import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;

/**
 * Created by Vishnu on 9/9/2016.
 */
public class UseCaseTest {

    private UseCase useCase;

    @Before
    public void setUp() throws Exception {

        useCase = new TestUseCase();
    }

    @Test
    public void testUnSubscribe() throws Exception {

        TestSubscriber testSubscriber = new TestSubscriber();

        useCase.buildUseCase().subscribe(testSubscriber);

        useCase.unSubscribe();

        assertTrue(testSubscriber.isUnsubscribed());
    }

    private class TestUseCase extends UseCase {

        @Override
        Observable buildUseCase() {
            return Observable.empty();
        }
    }
}