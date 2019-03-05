package org.gardenstreetacademy.easygrade.classitems;

import org.gardenstreetacademy.easygrade.init.ClassroomsInit;
import org.gardenstreetacademy.easygrade.init.TeacherInit;
import org.gardenstreetacademy.easygrade.people.Teacher;
import org.gardenstreetacademy.easygrade.util.DataManager;

import java.util.ArrayList;

public class Classroom
{

    private String class_name;
    private Teacher teacher;
    private int class_period;
    private int unique_number;
    private ArrayList<Assignment> assignments_for_class = new ArrayList<Assignment>();


    public Classroom(String name, int period, Teacher teacher)
    {
        this.class_name = name;
        this. class_period = period;
        this.teacher = teacher;

        if(DataManager.isTeacherFreePeriodFlag(this)) {
            ClassroomsInit.addClassToArray(this);
        } else {
            System.out.println("This teacher is booked that period in another class. Please try again.");
            this.equals(null);
        }
    }

    public Classroom(String name, int period, String teacher)
    {
        this.class_name = name;
        this. class_period = period;
        this.teacher = TeacherInit.getTeacherObjectFromName(teacher);


        if(DataManager.isTeacherFreePeriodFlag(this)) {
            ClassroomsInit.addClassToArray(this);
        } else {
            System.out.println("This teacher is booked that period in another class. Please try again.");
            this.equals(null);
        }
    }

    public int getClassPeriod()
    {
        return class_period;
    }

    public String getClassName()
    {
        return class_name;
    }

    public void setUniqueNum(int num){
        unique_number = num;
    }

    public void addAssignmentToThisClass(Assignment assignment)
    {
        for(Assignment a : this.assignments_for_class){
            if(a.getAssignmentName().equals(assignment.getAssignmentName())){
                System.out.println("Already an assignment in this class with this name. Please choose a new, unique assignment name.");
                return;
            }
        }
        assignments_for_class.add(assignment);
    }

    public Assignment findAssignmentInThisClass(String assignment_name)
    {
        Assignment assign = null;
        for(Assignment a : this.assignments_for_class){
            if(a.getAssignmentName().equals(assignment_name)){
                assign = a;
            }
        }
        return assign;
    }

    public ArrayList<Assignment> getAssignmentsForClass()
    {
        return assignments_for_class;
    }

    public void printAssignmentsForClass()
    {
        System.out.println(this.class_name + "  Period: " + this.getClassPeriod());
        for(Assignment a : this.assignments_for_class){
            System.out.println("    -" + a.getAssignmentName());
        }
    }

    public String getTeacherName()
    {
        return teacher.getTeacherName();
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

}
