package com.vishnus1224.teamworkapidemo.model;

/**
 * Created by Vishnu on 9/3/2016.
 */
public class CompanyDto {

    public String name;

    public String isOwner;

    public String id;

    public CompanyDto(String name, String isOwner, String id) {
        this.name = name;
        this.isOwner = isOwner;
        this.id = id;
    }
}
