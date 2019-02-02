package org.gardenstreetacademy.easygrade.init;

import org.gardenstreetacademy.easygrade.classroom.Classroom;

import java.util.*;

public class ClassroomsInit
{
    private static ArrayList<Classroom> classes = new ArrayList<Classroom>();

    public static ArrayList<Classroom> getClassesArray()
    {
        return classes;
    }

    public static void sortClassesByPeriod()
    {
        Collections.sort(classes, Comparator.comparing(Classroom::getClassPeriod));
    }

    public static void sortClassesByName()
    {
        Collections.sort(classes, Comparator.comparing(Classroom::getClassName));
    }

    public static void addClassToArray(Classroom c)
    {
        classes.add(c);
    }

    public static void classAdder()
    {
        Scanner readerName = new Scanner(System.in);
        System.out.println("Enter class name.");
        String className = readerName.nextLine();
        Scanner readerPeriod = new Scanner(System.in);
        System.out.println("Enter class period.");
        int per = readerPeriod.nextInt();
        readerName.close();
        readerPeriod.close();

        new Classroom(className, per);
    }

    public static ArrayList<Classroom> findClassByName(String name)
    {
        ArrayList<Classroom> classWithName = new ArrayList<Classroom>();

        int i;
        for(i=0; i<classes.size(); i++) {
        //for(Classroom c : classes){
            if(classes.get(i).getClassName() == name){
                classWithName.add(classes.get(i));
            }
        }

        Collections.sort(classWithName, Comparator.comparing(Classroom::getClassPeriod));

        return classWithName;
    }

    public static void printClassesWithName(String name)
    {
        ArrayList<Classroom> classWithName = new ArrayList<Classroom>();
        classWithName = findClassByName(name);
        for(Classroom c : classWithName){
            System.out.println("Period " + c.getClassPeriod() + ".  " + c.getClassName());
        }
    }
}
