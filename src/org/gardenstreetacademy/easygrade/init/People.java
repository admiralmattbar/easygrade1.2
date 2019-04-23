package org.gardenstreetacademy.easygrade.init;

import org.gardenstreetacademy.easygrade.people.Student;
import org.gardenstreetacademy.easygrade.people.Teacher;

import java.util.*;

//TODO Make the teacher and student stuff more generic.

public class People {

    private static List<Teacher> teachers = new ArrayList<Teacher>();

    private static List<Student> students = new ArrayList<Student>();

    public static List<Teacher> getTeachers()
    {
        return teachers;
    }

    public static List<Student> getStudents()
    {
        return students;
    }

    public static void createStudent(String name)
    {
        for(Student s : students) {
            if(s.getName().equals(name)){
                System.out.print("This student is already in the system.");
                return;
            } else {
                students.add(new Student(name));
            }
        }
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

    public static void addStudentToArray(Student student)
    {
        Boolean inSystem = false;
        for(Student s : students) {
            if(s.getName().equals(student.getName())){
                System.out.println("This student already exists in the system.");
                inSystem = true;
            }
        }
        if(inSystem == false) {
            students.add(student);
        } else {
            student = null;
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

    public static void sortStudentsByName()
    {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }


    public static void printTeacherList()
    {
        sortTeachersByName();
        for(Teacher t : getTeachers()){
            System.out.println(t.getName());
        }
    }

    public static void printStudentList()
    {
        sortStudentsByName();
        for(Student s : getStudents()){
            System.out.println(s.getName());
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

    public static Student getStudentObjectFromName(String name)
    {
        Student student = null;
        for(Student s : People.getStudents()){
            if(s.getName().equals(name)){
                student = s;
                return student;
            }
        }
        if(student == null){
            Scanner addStudentReader = new Scanner(System.in);
            System.out.println("This student '" + name + "' does not exist in the system, would you like to add them? (y/n)");
            String userAddStudent = addStudentReader.nextLine();

            if(userAddStudent.toLowerCase().equals("y")){
                System.out.println("Adding teacher '" + name + "' to database.");
                return new Student(name);

            } else if (userAddStudent.toLowerCase().equals("n")){
                System.out.println("They will not be added to the database.");
                return null;
            } else {
                System.out.println("Press 'y' for yes or 'n' for no.");
                getStudentObjectFromName(name);
            }

        }

        return null;
    }

}
