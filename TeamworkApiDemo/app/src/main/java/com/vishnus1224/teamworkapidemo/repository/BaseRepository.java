package com.vishnus1224.teamworkapidemo.repository;

import java.util.List;

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
     * Remove an item from the repository.
     * @return The type of the removed item.
     */
    Type removeItem();

    /**
     * Get a single item from the repository.
     * @return Instance of type.
     */
    Type getItem();

    /**
     * Get all items from the repository.
     * @return List of all items.
     */
    List<Type> getAllItems();
}
