package org.gardenstreetacademy.easygrade.people;

import org.gardenstreetacademy.easygrade.classitems.Classroom;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<Classroom> teachersClasses = new ArrayList<Classroom>();

    public Teacher(String name) {
        super(name);
    }

    public List<Classroom> getTeachersClasses()
    {
        return teachersClasses;
    }

    public void addToArray(Person pi)
    {
        org.gardenstreetacademy.easygrade.init.People.addTeacherToArray((Teacher) pi);
    }
}
