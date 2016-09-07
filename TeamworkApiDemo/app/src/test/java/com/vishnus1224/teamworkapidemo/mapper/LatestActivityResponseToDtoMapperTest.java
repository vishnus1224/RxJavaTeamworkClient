package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.TestDataStore;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.util.DateTimeHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Vishnu on 9/7/2016.
 */
public class LatestActivityResponseToDtoMapperTest extends TestDataStore {

    @Mock
    private DateTimeHelper dateTimeHelper;

    private LatestActivityResponseToDtoMapper mapper;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        mapper = new LatestActivityResponseToDtoMapper(dateTimeHelper);
    }

    @Test
    public void testMap() throws Exception {

        when(dateTimeHelper.latestActivityDateTimeToDate(anyString())).thenReturn(null);

        when(dateTimeHelper.latestActivityDueDateToDate(anyString())).thenReturn(null);

        LatestActivityResponse latestActivityResponse = createLatestActivityResponse("xyz", "project", "1");

        LatestActivityDto latestActivityDto = mapper.map(latestActivityResponse);

        assertNotNull(latestActivityDto);

        assertEquals(latestActivityDto.forUsername, "xyz");

        assertEquals(latestActivityDto.activityType, "project");

        assertEquals(latestActivityDto.id, "1");

        assertNull(latestActivityDto.dateTime);

    }
}