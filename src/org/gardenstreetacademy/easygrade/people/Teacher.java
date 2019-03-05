package org.gardenstreetacademy.easygrade.people;

import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.init.TeacherInit;

import java.util.ArrayList;

public class Teacher {

    private String name;

    private ArrayList<Classroom> teachersClasses = new ArrayList<Classroom>();

    public Teacher(String name){
        this.name = name;

        TeacherInit.addTeacherToArray(this);
    }


    public String getTeacherName()
    {
        return name;
    }

    public ArrayList<Classroom> getTeachersClasses()
    {
        return teachersClasses;
    }


}
