package com.vishnus1224.teamworkapidemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A list view section that holds data of type.
 * Created by vishnu on 25/08/16.
 */
public class Section<Type> {

    /**
     * Section number.
     */
    private int sectionNumber;

    /**
     * Title of the section.
     */
    private String sectionTitle;

    /**
     * List of elements to be displayed in the section.
     */
    private List<Type> typeList;

    public Section(int sectionNumber, String sectionTitle) {

        this.sectionNumber = sectionNumber;

        this.sectionTitle = sectionTitle;

        typeList = new ArrayList<>();
    }

    public Section(int sectionNumber, String sectionTitle, List<Type> typeList) {
        this.sectionNumber = sectionNumber;
        this.sectionTitle = sectionTitle;
        this.typeList = typeList;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public void addToList(Type type){

        this.typeList.add(type);

    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }
}
