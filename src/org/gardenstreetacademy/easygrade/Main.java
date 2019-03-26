package org.gardenstreetacademy.easygrade;

import org.gardenstreetacademy.easygrade.classitems.Assignment;
import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.init.Assignments;
import org.gardenstreetacademy.easygrade.init.People;
import org.gardenstreetacademy.easygrade.people.Teacher;

public class Main
{

    public static void main(String args[])
    {

        Teacher matt = new Teacher("Matt");
        Teacher arnold = new Teacher("Arnold");

        Classroom algebra = new Classroom("Algebra", 4, arnold);
        Classroom world_history = new Classroom("World History", 1, "Matt");
        Classroom world_history2 = new Classroom("World History", 2, "Matt");
        Classroom government = new Classroom("Government", 4, "Octavian");

        Assignments.addAssignmentToAllClassesByName("Notebook", "World History");


        for(Assignment a : Assignments.getAssignmentsArray()){
            System.out.println(a.getAssignmentClass().getName() + " Period " + a.getAssignmentClass().getClassPeriod() + ": " + a.getName());
        }

        People.printTeacherList();



    }

}
