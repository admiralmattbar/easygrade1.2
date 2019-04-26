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

    private int max_score;

    public Assignment(String name, Classroom classroom)
    {
        super(name);
        this.assignment_class = classroom;
        classroom.addAssignmentToArrayForClassroom(this);
    }

    public Assignment(String name, String classname, int period, Teacher teacher)
    {
        super(name);
        this.class_period = period;
        for(Classroom c : Classes.getClassesArray()){
            if(c.getName().equals(classname) && c.getClassPeriod() == period && c.getTeacher().equals(teacher)) {
                c.addAssignmentToArrayForClassroom(this);
            }
        }
    }


    public Assignment(String name, String classname, int period, String teachername)
    {
        super(name);
        this.class_period = period;
        for(Classroom c : Classes.getClassesArray()){
            if(c.getName().equals(classname) && c.getClassPeriod() == period && c.getTeacherName().equals(teachername)) {
                c.addAssignmentToArrayForClassroom(this);
            }
        }
    }


    public Classroom getAssignmentClassroom()
    {
        return assignment_class;
    }

    @Override
    public void addToArray(ClassItem ci) {
        Assignments.addAssignmentToArray(this);
    }

    public int getMaxScore()
    {
        return this.max_score;
    }

    public void setMaxScore(int score)
    {
        this.max_score = score;
    }

}
