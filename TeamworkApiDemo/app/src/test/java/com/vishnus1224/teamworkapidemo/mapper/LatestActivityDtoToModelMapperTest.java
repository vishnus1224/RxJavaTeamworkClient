package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.TestDataStore;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vishnu on 9/7/2016.
 */
public class LatestActivityDtoToModelMapperTest extends TestDataStore{

    private LatestActivityDtoToModelMapper latestActivityDtoToModelMapper;

    @Before
    public void setUp() throws Exception {

        latestActivityDtoToModelMapper = new LatestActivityDtoToModelMapper();
    }

    @Test
    public void testMap() throws Exception {

        LatestActivityDto latestActivityDto = createLatestActivityDto("1241", "test description", "test project");

        LatestActivityModel latestActivityModel = latestActivityDtoToModelMapper.map(latestActivityDto);

        assertNotNull(latestActivityModel);

        assertEquals(latestActivityModel.companyId, "1241");

        assertEquals(latestActivityModel.extraDescription, "test description");

        assertEquals(latestActivityModel.projectName, "test project");

        assertNull(latestActivityModel.link);

    }
}