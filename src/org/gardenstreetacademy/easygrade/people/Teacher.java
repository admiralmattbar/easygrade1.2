package org.gardenstreetacademy.easygrade.people;

public class Teacher {

    String firstName;
    String lastName;
    private String name;

    public Teacher(String name){
        this.name = name;
    }


    public String getTeacherName()
    {
        return name;
    }


}
