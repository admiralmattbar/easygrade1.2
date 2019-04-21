package org.gardenstreetacademy.easygrade.people;

import org.gardenstreetacademy.easygrade.classitems.Classroom;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    String name;
    private int unique_number;

    private List<Classroom> classes = new ArrayList<Classroom>();

    public Person(String name)
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

    public abstract void addToArray(Person ci);

    public List<Classroom> getPersonClasses()
    {
        return classes;
    }

    public void addClassToPerson(Classroom c)
    {
        classes.add(c);
    }

}
