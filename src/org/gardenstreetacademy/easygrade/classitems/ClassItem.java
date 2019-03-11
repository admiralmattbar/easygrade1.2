package org.gardenstreetacademy.easygrade.classitems;

public abstract class ClassItem {

    private String name;
    private int unique_number;

    public ClassItem(String name)
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

    public abstract void addToArray(ClassItem ci);
}
