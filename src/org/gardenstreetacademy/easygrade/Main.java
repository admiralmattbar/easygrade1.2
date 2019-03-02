package org.gardenstreetacademy.easygrade;

import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.init.AssignmentInit;

public class Main
{

    public static void main(String args[])
    {

        Classroom algebra = new Classroom("Algebra", 4, "Matt");
        Classroom world_history = new Classroom("World History", 1, "Matt");
        Classroom world_history2 = new Classroom("World History", 2, "Matt");
        Classroom government = new Classroom("Government", 4, "Matt");

        AssignmentInit.addAssignmentToAllClassesByName();

        world_history.printAssignmentsForClass();
        world_history2.printAssignmentsForClass();



    }

}
