package com.vishnus1224.teamworkapidemo.repository;

import java.util.List;

import rx.Observable;

/**
 * Created by vishnu on 24/08/16.
 */
public interface BaseRepository<Type> {

    /**
     * Add an item to the repository.
     * @param type Instance of type.
     */
    void add(Type type);

    /**
     * Add all items contained in the list.
     * @param typeList The data type to hold in the list.
     */
    void addAll(List<Type> typeList);

    /**
     * Remove an item from the repository.
     * @return The type of the removed item.
     */
    Type removeItem();

    /**
     * Get a single item from the repository.
     * @return Instance of type.
     */
    Observable<Type> getItem();

    /**
     * Get all items from the repository.
     * @return List of all items.
     */
    Observable<List<Type>> getAllItems();

    /**
     * Search and return items that match the search string.
     * @param searchString The string to search for.
     * @return List of matching items.
     */
    Observable<List<Type>> searchItems(String searchString);
}
