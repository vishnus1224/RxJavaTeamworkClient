package com.vishnus1224.teamworkapidemo;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * Created by Vishnu on 9/10/2016.
 */
public class RealmMockProvider {

    protected Realm mockRealm(){

        return mock(Realm.class);

    }

    protected <T extends RealmObject> RealmResults<T> mockRealmResults(){

        return mock(RealmResults.class);

    }

    protected <T extends RealmObject> RealmQuery<T> mockRealmQuery(){

        return mock(RealmQuery.class);

    }
}
