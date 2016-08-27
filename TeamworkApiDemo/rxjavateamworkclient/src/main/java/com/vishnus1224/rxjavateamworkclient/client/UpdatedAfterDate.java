package com.vishnus1224.rxjavateamworkclient.client;

import java.text.ParseException;

/**
 * Allows for passing the updatedAfterDate param to a query.
 * Created by Vishnu on 8/27/2016.
 */
interface UpdatedAfterDate<Type> {

    /**
     * If set then query will return results that are updated only after the specified date.
     * @param date date string in YYYYMMDDHHMMSS format.
     * @return object type that implements this interface.
     * @throws ParseException if the date is in the wrong format.
     */
    Type updatedAfterDate(String date) throws ParseException;
}
