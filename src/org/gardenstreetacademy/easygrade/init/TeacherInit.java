package org.gardenstreetacademy.easygrade.init;

import org.gardenstreetacademy.easygrade.people.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherInit {

    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public ArrayList<Teacher> getTeachers()
    {
        return teachers;
    }

    public void addTeacher(String name)
    {
        for(Teacher t : teachers) {
            if(t.getTeacherName().equals(name)){
                System.out.println("This teacher is already in the system.");
                return;
            } else {
                teachers.add(new Teacher(name));
            }
        }
    }

    public void addTeacherFromUser()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println();
    }

}
