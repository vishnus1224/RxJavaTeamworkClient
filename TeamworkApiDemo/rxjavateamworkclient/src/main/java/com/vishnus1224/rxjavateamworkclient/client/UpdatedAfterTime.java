package com.vishnus1224.rxjavateamworkclient.client;

/**
 * Allows for passing the updatedAfterTime param to a query.
 * Created by Vishnu on 8/27/2016.
 */
interface UpdatedAfterTime<Type> {

    /**
     * Sets the updatedAfterTime query param.
     * @param timeString time string in HH:MM format.
     * @return type instance that implements the interface.
     */
    Type updatedAfterTime(String timeString);
}
