package com.vishnus1224.rxjavateamworkclient.client;

/**
 * Allows for specifying the page param as a query param.
 * Created by Vishnu on 8/27/2016.
 */
interface Paginated<Type> {

    /**
     * Set the page as a query param.
     * @param pageNumber page number to get the results from.
     * @return the implementing type.
     */
    Type page(int pageNumber);
}
