package org.gardenstreetacademy.easygrade.people;


import org.gardenstreetacademy.easygrade.classitems.Assignment;
import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.init.People;

import java.util.HashMap;
import java.util.Map;


public class Student extends Person
{

    private Map<Assignment, Integer> assignment_grades = new HashMap<Assignment, Integer>();



    public Student(String name) {
        super(name);
        addToArray(this);
    }

    @Override
    public void addToArray(Person ci) {
        People.addStudentToArray((Student)ci);
    }

    public Map getGrades(){
        return assignment_grades;
    }

    public Map getGradesByClass(Classroom c)
    {
        Map assignment_grades_in_class = new HashMap<Assignment, Integer>();
        for(Assignment a : assignment_grades.keySet()){
            if(a.getAssignmentClassroom().equals(c)){
                assignment_grades_in_class.put(a, assignment_grades.get(a));
            }
        }
        return assignment_grades_in_class;
    }

    public void gradeStudentAssignment(Assignment a, Integer grade)
    {
        assignment_grades.put(a, grade);
    }
}
