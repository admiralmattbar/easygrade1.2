package org.gardenstreetacademy.easygrade;

import org.gardenstreetacademy.easygrade.classroom.Classroom;
import org.gardenstreetacademy.easygrade.init.ClassroomsInit;

public class Main
{

    public static void main(String args[])
    {
        Classroom algebra = new Classroom("Algebra", 4);
        Classroom world_history = new Classroom("World History", 1);

        ClassroomsInit.classAdder();

        ClassroomsInit.sortClassesByName();

        for(Classroom c : ClassroomsInit.getClassesArray()){
            System.out.println(c.getClassName());
        }

        ClassroomsInit.sortClassesByPeriod();

        for(Classroom c : ClassroomsInit.getClassesArray()){
            System.out.println(c.getClassPeriod() + ". " + c.getClassName());
        }

        for(Classroom c : ClassroomsInit.findClassByName("World History")){
            System.out.println(c.getClassPeriod() + ". " + c.getClassName());
        }

        System.out.println(ClassroomsInit.findClassByName("World History").size());

        //ClassroomsInit.printClassesWithName("World History");

    }

}
