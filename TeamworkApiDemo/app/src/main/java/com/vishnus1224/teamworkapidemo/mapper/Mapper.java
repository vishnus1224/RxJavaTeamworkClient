package com.vishnus1224.teamworkapidemo.mapper;

/**
 * Maps the input type to the output type.
 * Created by vishnu on 25/08/16.
 */
public interface Mapper<Input, Output> {

    /**
     * Convert the input to the output.
     * @param input Input type.
     * @return Output type
     */
    Output map(Input input);

}
