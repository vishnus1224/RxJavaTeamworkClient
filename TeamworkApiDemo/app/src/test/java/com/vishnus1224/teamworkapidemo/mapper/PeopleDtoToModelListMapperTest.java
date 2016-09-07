package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.TestDataStore;
import com.vishnus1224.teamworkapidemo.model.PeopleDto;
import com.vishnus1224.teamworkapidemo.model.PeopleRealmModel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

import static org.junit.Assert.*;

/**
 * Created by Vishnu on 9/7/2016.
 */
public class PeopleDtoToModelListMapperTest extends TestDataStore{

    private PeopleDtoToModelListMapper mapper;

    @Before
    public void setUp() throws Exception {

        mapper = new PeopleDtoToModelListMapper();

    }

    @Test
    public void testMap() throws Exception {

        List<PeopleDto> peopleDtoList = new ArrayList<>();

        peopleDtoList.add(createPeopleDto("1"));
        peopleDtoList.add(createPeopleDto("2"));

        RealmList<PeopleRealmModel> peopleDtoRealmList = mapper.map(peopleDtoList);

        assertNotNull(peopleDtoRealmList);

        assertEquals(peopleDtoRealmList.size(), 2);

        assertEquals(peopleDtoRealmList.get(1).id, "2");
    }
}