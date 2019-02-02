package org.gardenstreetacademy.easygrade.classroom;

import org.gardenstreetacademy.easygrade.init.ClassroomsInit;

public class Classroom
{

    private String class_name;
    private int class_period;


    public Classroom(String name, int period)
    {
        this.class_name = name;
        this. class_period = period;

        ClassroomsInit.addClassToArray(this);
    }

    public int getClassPeriod()
    {
        return class_period;
    }

    public String getClassName()
    {
        return class_name;
    }

}
