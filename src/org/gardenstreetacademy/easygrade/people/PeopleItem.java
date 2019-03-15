package org.gardenstreetacademy.easygrade.people;

import org.gardenstreetacademy.easygrade.classitems.ClassItem;

public abstract class PeopleItem {

    String name;
    private int unique_number;

    public PeopleItem(String name)
    {
        this.name = name;

        addToArray(this);
    }

    public void setUniqueNum(int num){
        unique_number = num;
    }

    public String getName()
    {
        return this.name;
    }

    public int getUniqueNumber()
    {
        return this.unique_number;
    }

    public void setUniqueNumber(int num)
    {
        this.unique_number = num;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public abstract void addToArray(PeopleItem ci);

}
