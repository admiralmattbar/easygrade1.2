package org.gardenstreetacademy.easygrade.init;

import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.people.Teacher;

import java.util.*;

public class ClassroomsInit
{
    public static ArrayList<Classroom> classes = new ArrayList<Classroom>();

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
        c.setUniqueNum(classes.indexOf(c));
    }

    public static void classAdder()
    {
        Scanner readerName = new Scanner(System.in);

        System.out.println("Enter class name.");

        String className = null;
        if(readerName.hasNextLine()) className = readerName.nextLine();

        Scanner readerPeriod = new Scanner(System.in);

        System.out.println("Enter class period.");

        int per = 0;
        per = readerPeriod.nextInt();

        Scanner readerTeacher = new Scanner(System.in);

        System.out.println("Who is teaching this class?");

        String teacherName = null;
        if(readerTeacher.hasNextLine()) teacherName = readerTeacher.nextLine();

        if (className != null && !className.equals("")) {

            if(teacherName != null && !teacherName.equals("")){
                new Classroom(className, per, (Teacher) null); //TODO: handle teacher name in this function.
            }


        } else {
            System.out.println("Please give your new classitems a name.");
            readerName.nextLine();
            classAdder();
        }

    }

    public static ArrayList<Classroom> findClassByName(String name)
    {
        ArrayList<Classroom> classWithName = new ArrayList<Classroom>();

        int i;
        for(i=0; i<classes.size(); i++) {
        //for(Classroom c : classes){
            if(classes.get(i).getClassName().equals(name)){
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
