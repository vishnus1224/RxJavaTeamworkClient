package com.vishnus1224.rxjavateamworkclient.client;

/**
 * Used for limiting the number of items to be fetched in the query.
 * Created by Vishnu on 8/22/2016.
 */
interface Limitable {

    void maxItems(int count);

}
