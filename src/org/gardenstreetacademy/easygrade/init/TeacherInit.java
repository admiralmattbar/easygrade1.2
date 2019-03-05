package org.gardenstreetacademy.easygrade.init;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.gardenstreetacademy.easygrade.people.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TeacherInit {

    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static ArrayList<Teacher> getTeachers()
    {
        return teachers;
    }

    public static void createTeacher(String name)
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

    public static void addTeacherToArray(Teacher teacher)
    {
        Boolean inSystem = false;
        for(Teacher t : teachers){
            if(t.getTeacherName().equals(teacher.getTeacherName())){
                System.out.println("This teacher already exists in the system.");
                inSystem = true;
            }
        }

        if(inSystem == false) {
            teachers.add(teacher);
        } else {
            teacher = null;
        }
    }


    public static void sortTeachersByName()
    {
        Collections.sort(teachers, Comparator.comparing(Teacher::getTeacherName));
    }


    public static void printTeacherList()
    {
        sortTeachersByName();
        for(Teacher t : getTeachers()){
            System.out.println(t.getTeacherName());
        }
    }

    public static Teacher getTeacherObjectFromName(String name)
    {
        Teacher teacher = null;
        for(Teacher t : TeacherInit.getTeachers()){
            if(t.getTeacherName().equals(name)){
                teacher = t;
                return teacher;
            }
        }
        if(teacher == null){
            Scanner addTeacherReader = new Scanner(System.in);
            System.out.println("This teacher '" + name + "' does not exist in the system, would you like to add them? (y/n)");
            String userAddTeacher = addTeacherReader.nextLine();

            if(userAddTeacher == "y"){
                System.out.println("Adding teacher to database.");
                return new Teacher(name);

            }

        }

        return null;
    }



}
