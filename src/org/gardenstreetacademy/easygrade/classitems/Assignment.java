package org.gardenstreetacademy.easygrade.classitems;

import org.gardenstreetacademy.easygrade.init.AssignmentInit;
import org.gardenstreetacademy.easygrade.init.ClassroomsInit;

import java.util.ArrayList;

public class Assignment {

    private String assignment_name;
    private Classroom assignment_class;
    private int unique_assignment_number;
    private int class_period;
    ArrayList<Classroom> classWithAssignment;

    public Assignment(String name, Classroom classroom)
    {
        this.assignment_name = name;
        this.assignment_class = classroom;

        classroom.addAssignmentToThisClass(this);
        AssignmentInit.addAssignmentToArray(this);
    }

    public Assignment(String name, String classname, int period)
    {
        this.assignment_name = name;
        for(Classroom c : ClassroomsInit.getClassesArray()){
            if(c.getClassName().equals(classname)){
                c.addAssignmentToThisClass(this);
            }
        }

        AssignmentInit.addAssignmentToArray(this);
    }

    public Classroom getAssignmentClass()
    {
        return assignment_class;
    }

    public String getAssignmentName()
    {
        return assignment_name;
    }

    public void setUniqueNum(int num){
        unique_assignment_number = num;
    }
}
