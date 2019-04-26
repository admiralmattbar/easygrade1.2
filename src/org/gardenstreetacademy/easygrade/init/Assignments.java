package org.gardenstreetacademy.easygrade.init;

import org.gardenstreetacademy.easygrade.classitems.Assignment;
import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.people.Student;

import java.util.*;

public class Assignments {

    private static List<Assignment> assignments = new ArrayList<>();

    public static List<Assignment> getAssignmentsArray()
    {
        return assignments;
    }

    public static void sortAssignmentsByName()
    {
        Collections.sort(assignments, Comparator.comparing(Assignment::getName));
    }

    public static void addAssignmentToArray(Assignment a)
    {
        assignments.add(a);
        a.setUniqueNum(assignments.indexOf(a));
    }

    public static void addAssignmentToAllClassesByNameUserInput()
    {
        Scanner readerAssignmentName = new Scanner(System.in);

        System.out.println("Enter assignment name.");

        String assignmentName = null;
        if(readerAssignmentName.hasNextLine()) assignmentName = readerAssignmentName.nextLine();

        Scanner readerAssignmentClass = new Scanner(System.in);
        System.out.println("Enter name of class(es) its in.");
        String className = null;
        if(readerAssignmentClass.hasNextLine())className = readerAssignmentClass.nextLine();

        if (assignmentName != null && !assignmentName.equals("")) {
            for(Classroom c : Classes.getClassesArray()){
                if(c.getName().equals(className)){
                    new Assignment(assignmentName, c);
                }
            }

        } else {
            System.out.println("Please give your new assignment a name.");
            addAssignmentToAllClassesByNameUserInput();
        }

    }

    public static void addAssignmentToAllClassesByName(String assignmentName, String className)
    {
        if (assignmentName != null && !assignmentName.equals("")) {
            for (Classroom c : Classes.getClassesArray()) {
                if (c.getName().equals(className)) {
                    new Assignment(assignmentName, c);
                }
            }
        }
    }

    public float getIndividualGradePercent(Student s, Assignment a)
    {
        int max_score = a.getMaxScore();
        Float student_score = (Float)s.getGrades().get(a);
        return (student_score/(float)max_score);
    }

    /*
    public static ArrayList<Assignment> findAssignmentByClass(String assignment_name, String class_name, int period)
    {
        ArrayList<Assignment> assignmentWithName = new ArrayList<Assignment>();

        int i;
        for(i=0; i<Classes.getClassesArray().size(); i++) {
            if(assignments.get(i).getAssignmentName().equals(assignment_name) && ){
                assignmentWithName.add(assignments.get(i));
            }
        }

        Collections.sort(assignmentWithName, Comparator.comparing(Assignment::getAssignmentName));

        return assignmentWithName;
    }
    */

    public static ArrayList<Assignment> findAssignmentsWithName(String name)
    {
        ArrayList<Assignment> assignmentWithName = new ArrayList<Assignment>();
        for(Assignment a : assignments){
            if(a.getName().equals(name)){
                assignmentWithName.add(a);
            }
        }

        return assignmentWithName;
    }

    public static Assignment findUniqueAssignmentWithStrings(String name, String classname, int period, String teacher)
    {
        int i = 0;
        for(Assignment a : assignments){
            if(a.getName().equals(name)
                    && a.getAssignmentClassroom().getName().equals(classname)
                    && a.getAssignmentClassroom().getClassPeriod() == period
                    && a.getAssignmentClassroom().getTeacher().getName().equals(teacher)){
                i = assignments.indexOf(a);
            }
        }

        return assignments.get(i);
    }

    public static void printAssignmentsWithName(String name)
    {
        ArrayList<Assignment> assignWithName = new ArrayList<Assignment>();
        assignWithName = findAssignmentsWithName(name);
        for(Assignment a : assignWithName){
            System.out.println("Period " + a.getAssignmentClassroom().getName() + ".  " + a.getName());
        }
    }
}
