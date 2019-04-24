package org.gardenstreetacademy.easygrade.people;

import org.gardenstreetacademy.easygrade.classitems.Classroom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    protected String name;
    protected LocalDate birthday;

    protected String id;

    protected List<Classroom> classes = new ArrayList<Classroom>();

    public Person(){}

    public String getName()
    {
        return this.name;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId()
    {
        if(!this.name.equals(null) && !this.birthday.equals(null)) this.id = name+"_"+birthday.toString();
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

    public boolean hasId()
    {
        if(this.id.equals(null)){
            return false;
        } else {
            return true;
        }
    }

    public LocalDate getBirthday()
    {
        return birthday;
    }

}
