package com.vishnus1224.teamworkapidemo.manager;

import com.vishnus1224.teamworkapidemo.RealmMockProvider;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;
import com.vishnus1224.teamworkapidemo.model.ProjectRealmModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by vishnu on 12/09/16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Realm.class, RealmConfiguration.class})
public class RealmManagerTest extends RealmMockProvider{

    private RealmConfiguration realmConfiguration;

    private Realm realm;

    private RealmManager realmManager;

    @Before
    public void setUp() throws Exception {

        mockStatic(Realm.class);
        mockStatic(RealmConfiguration.class);

        realm = mockRealm();

        realmConfiguration = mockRealmConfiguration();

        realmManager = new RealmManager(realmConfiguration);
    }

    @Test
    public void testNewRealm() throws Exception {


        when(Realm.getInstance(realmConfiguration)).thenReturn(realm);

        RealmManager realmManager = new RealmManager(realmConfiguration);

        realmManager.newRealm();

        PowerMockito.verifyStatic();

        Realm.getInstance(Mockito.any(RealmConfiguration.class));

    }

    @Test
    public void testAddToRealm() throws Exception {

        when(realmManager.newRealm()).thenReturn(realm);

        realmManager.addToRealm(new ProjectRealmModel());

        verify(realm).executeTransaction(Mockito.any(Realm.Transaction.class));

        verify(realm).close();

    }

    @Test
    public void testAddAllToRealm() throws Exception {

        when(realmManager.newRealm()).thenReturn(realm);

        realmManager.addAllToRealm(new ArrayList<LatestActivityModel>());

        verify(realm).executeTransaction(Mockito.any(Realm.Transaction.class));

        verify(realm).close();

    }
}