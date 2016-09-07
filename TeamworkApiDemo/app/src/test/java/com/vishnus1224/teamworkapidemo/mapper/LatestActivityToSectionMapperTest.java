package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.TestDataStore;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.Section;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vishnu on 9/7/2016.
 */
public class LatestActivityToSectionMapperTest extends TestDataStore {

    private LatestActivityToSectionMapper mapper;

    @Before
    public void setUp() throws Exception {

        mapper = new LatestActivityToSectionMapper();

    }

    @Test
    public void testMap() throws Exception {

        List<LatestActivityDto> latestActivityDtoList = new ArrayList<>();

        LatestActivityDto latestActivityDto = createLatestActivityDto("4676", "test", "my project");

        latestActivityDto.companyName = "abc";

        latestActivityDtoList.add(latestActivityDto);

        List<Section<LatestActivityDto>> sectionList = mapper.map(latestActivityDtoList);

        assertNotNull(sectionList);

        assertEquals(sectionList.size(), 1);

        assertEquals(sectionList.get(0).getSectionNumber(), 0);

        assertEquals(sectionList.get(0).getSectionTitle(), "my project : abc");

    }
}