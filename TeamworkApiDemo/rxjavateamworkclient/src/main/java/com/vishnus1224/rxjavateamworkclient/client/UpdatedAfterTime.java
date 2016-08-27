package com.vishnus1224.rxjavateamworkclient.client;

import java.text.ParseException;

/**
 * Allows for passing the updatedAfterTime param to a query.
 * Created by Vishnu on 8/27/2016.
 */
interface UpdatedAfterTime<Type> {

    /**
     * Sets the updatedAfterTime query param.
     * @param timeString time string in HH:MM format.
     * @return type instance that implements the interface.
     * @throws ParseException if the time is in the wrong format.
     */
    Type updatedAfterTime(String timeString) throws ParseException;
}
