package org.gardenstreetacademy.easygrade.classitems;

import org.gardenstreetacademy.easygrade.init.Assignments;
import org.gardenstreetacademy.easygrade.init.Classes;
import org.gardenstreetacademy.easygrade.people.Teacher;

import java.util.List;

public class Assignment extends ClassItem{


    private Classroom assignment_class;
    private int unique_assignment_number;
    private int class_period;
    List<Classroom> classWithAssignment;
    private int total_score;

    public Assignment(String name, Classroom classroom)
    {
        super(name);
        this.assignment_class = classroom;
        classroom.addAssignmentToThisClass(this);
    }

    public Assignment(String name, String classname, int period, Teacher teacher)
    {
        super(name);
        this.class_period = period;
        for(Classroom c : Classes.getClassesArray()){
            if(c.getName().equals(classname) && c.getClassPeriod() == period && c.getTeacher().equals(teacher)) {
                c.addAssignmentToThisClass(this);
            }
        }
    }

    public Assignment(String name, String classname, int period, String teachername)
    {
        super(name);
        this.class_period = period;
        for(Classroom c : Classes.getClassesArray()){
            if(c.getName().equals(classname) && c.getClassPeriod() == period && c.getTeacherName().equals(teachername)) {
                c.addAssignmentToThisClass(this);
            }
        }
    }

    public Classroom getAssignmentClass()
    {
        return assignment_class;
    }

    @Override
    public void addToArray(ClassItem ci) {
        Assignments.addAssignmentToArray(this);
    }

    public int getTotalScore()
    {
        return this.total_score;
    }

    public void setTotalScore(int score)
    {
        this.total_score = score;
    }

}
