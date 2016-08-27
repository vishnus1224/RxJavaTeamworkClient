package com.vishnus1224.rxjavateamworkclient.client;

import java.text.ParseException;

/**
 * Allows for passing the createdAfterTime param to a query.
 * Created by Vishnu on 8/27/2016.
 */
interface CreatedAfterTime<Type> {

    /**
     * Sets the createdAfterTime query param.
     * @param timeString time string in HH:MM format.
     * @return type instance that implements the interface.
     * @throws ParseException if the time is in the wrong format.
     */
    Type createdAfterTime(String timeString) throws ParseException;
}
