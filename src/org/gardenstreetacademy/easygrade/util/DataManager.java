package org.gardenstreetacademy.easygrade.util;

import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.init.ClassroomsInit;

public class DataManager {

    public static boolean isTeacherFreePeriodFlag(Classroom classroom)
    {
        for(Classroom c : ClassroomsInit.getClassesArray()){
            if((c.getClassPeriod() == classroom.getClassPeriod()) && (c.getTeacher().equals(classroom.getTeacher()))) return false;
        }
        return true;
    }

}