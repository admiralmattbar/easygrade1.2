package org.gardenstreetacademy.easygrade.people;

import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.init.TeacherInit;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends PeopleItem {

    private String name;

    private List<Classroom> teachersClasses = new ArrayList<Classroom>();

    public Teacher(String name){
        this.name = name;

        TeacherInit.addTeacherToArray(this);
    }


    public String getTeacherName()
    {
        return name;
    }

    public List<Classroom> getTeachersClasses()
    {
        return teachersClasses;
    }


}
