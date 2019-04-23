package org.gardenstreetacademy.easygrade.people;

import org.gardenstreetacademy.easygrade.classitems.Classroom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    String name;
    LocalDate birthday;

    private String id;

    private List<Classroom> classes = new ArrayList<Classroom>();

    public Person(String name)
    {
        this.name = name;
        addToArray(this);
    }

    public Person(String name, LocalDate birthday)
    {
        this(name);
        this.birthday = birthday;

    }

    public Person(String name, int year, short month, short day)
    {
        this(name);
        this.birthday = LocalDate.of(year, month, day);

    }


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

}
