package org.gardenstreetacademy.easygrade.init;

import org.gardenstreetacademy.easygrade.classitems.Assignment;
import org.gardenstreetacademy.easygrade.classitems.Classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AssignmentInit {

    private static ArrayList<Assignment> assignments = new ArrayList<Assignment>();

    public static ArrayList<Assignment> getAssignmentsArray()
    {
        return assignments;
    }

    public static void sortAssignmentsByName()
    {
        Collections.sort(assignments, Comparator.comparing(Assignment::getAssignmentName));
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
            for(Classroom c : ClassroomsInit.getClassesArray()){
                if(c.getClassName().equals(className)){
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
            for (Classroom c : ClassroomsInit.getClassesArray()) {
                if (c.getClassName().equals(className)) {
                    new Assignment(assignmentName, c);
                }
            }

        }
    }

    /*
    public static ArrayList<Assignment> findAssignmentByClass(String assignment_name, String class_name, int period)
    {
        ArrayList<Assignment> assignmentWithName = new ArrayList<Assignment>();

        int i;
        for(i=0; i<ClassroomsInit.getClassesArray().size(); i++) {
            if(assignments.get(i).getAssignmentName().equals(assignment_name) && ){
                assignmentWithName.add(assignments.get(i));
            }
        }

        Collections.sort(assignmentWithName, Comparator.comparing(Assignment::getAssignmentName));

        return assignmentWithName;
    }
    */

    public static ArrayList<Assignment> findAssignmentByName(String name)
    {
        ArrayList<Assignment> assignmentWithName = new ArrayList<Assignment>();
        for(Assignment a : assignments){
            if(a.getAssignmentName().equals(name)){
                assignmentWithName.add(a);
            }
        }

        return assignmentWithName;
    }

    public static void printAssignmentsWithName(String name)
    {
        ArrayList<Assignment> assignWithName = new ArrayList<Assignment>();
        assignWithName = findAssignmentByName(name);
        for(Assignment a : assignWithName){
            System.out.println("Period " + a.getAssignmentClass().getClassName() + ".  " + a.getAssignmentName());
        }
    }
}
