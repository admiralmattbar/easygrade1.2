package org.gardenstreetacademy.easygrade.people;

import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.init.People;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends PeopleItem {

    private List<Classroom> teachersClasses = new ArrayList<Classroom>();

    public Teacher(String name) {
        super(name);
    }

    public List<Classroom> getTeachersClasses()
    {
        return teachersClasses;
    }

    public void addToArray(PeopleItem pi)
    {
        People.addTeacherToArray((Teacher) pi);
    }
}
