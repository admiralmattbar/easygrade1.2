package org.gardenstreetacademy.easygrade.people;


import org.gardenstreetacademy.easygrade.classitems.Assignment;
import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.init.People;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Student extends Person
{
    private Map<Assignment, Integer> assignment_grades = new HashMap<Assignment, Integer>();

    public Student(String name)
    {
        this.name = name;
        addToArray(this);
    }

    public Student(String name, LocalDate birthday)
    {
        this(name);
        this.birthday = birthday;
        this.setId();
    }

    public Student(String name, int birthyear, int birthmonth, int birthday)
    {
        this(name);
        if(birthmonth < 13 && birthday < 32 && birthyear > 1900 && birthyear < LocalDate.now().getYear()){
            this.birthday = LocalDate.of(birthyear, (short) birthmonth, (short) birthday);
        } else {
            System.out.println("Please enter a valid date.");
        }
        this.setId();
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
        for(Assignment a : this.assignment_grades.keySet()){
            if(a.getAssignmentClassroom().equals(c)){
                assignment_grades_in_class.put(a, this.assignment_grades.get(a));
            }
        }
        return assignment_grades_in_class;
    }

    public void gradeStudentAssignment(Assignment a, Integer grade)
    {
        this.assignment_grades.put(a, grade);
    }
}
