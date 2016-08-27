package com.vishnus1224.rxjavateamworkclient.client;

/**
 * Implementing type will be able to set the orderBy query param.
 * Created by Vishnu on 8/27/2016.
 */
interface OrderBy<Type> {

    /**
     * Set the orderBy param.
     * @param orderBy value that will be used to order the results.
     * @return the implementing type.
     */
    Type orderBy(String orderBy);

}

