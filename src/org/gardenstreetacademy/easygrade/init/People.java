package org.gardenstreetacademy.easygrade.init;

import org.gardenstreetacademy.easygrade.people.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class People {

    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static ArrayList<Teacher> getTeachers()
    {
        return teachers;
    }

    public static void createTeacher(String name)
    {
        for(Teacher t : teachers) {
            if(t.getName().equals(name)){
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
            if(t.getName().equals(teacher.getName())){
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
        Collections.sort(teachers, Comparator.comparing(Teacher::getName));
    }


    public static void printTeacherList()
    {
        sortTeachersByName();
        for(Teacher t : getTeachers()){
            System.out.println(t.getName());
        }
    }

    public static Teacher getTeacherObjectFromName(String name)
    {
        Teacher teacher = null;
        for(Teacher t : People.getTeachers()){
            if(t.getName().equals(name)){
                teacher = t;
                return teacher;
            }
        }
        if(teacher == null){
            Scanner addTeacherReader = new Scanner(System.in);
            System.out.println("This teacher '" + name + "' does not exist in the system, would you like to add them? (y/n)");
            String userAddTeacher = addTeacherReader.nextLine();

            if(userAddTeacher.equals("y")){
                System.out.println("Adding teacher '" + name + "' to database.");
                return new Teacher(name);

            }

        }

        return null;
    }



}
