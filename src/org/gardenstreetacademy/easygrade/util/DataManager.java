package org.gardenstreetacademy.easygrade.util;

import org.gardenstreetacademy.easygrade.classitems.Classroom;
import org.gardenstreetacademy.easygrade.init.Classes;
import org.gardenstreetacademy.easygrade.people.Student;

public class DataManager {

    public static boolean checkTeacherAvailableFlag(Classroom classroom)
    {
        for(Classroom c : Classes.getClassesArray()){
            if(c.getTeacher() != null) {
                if((c.getClassPeriod() == classroom.getClassPeriod()) && (c.getTeacher().equals(classroom.getTeacher()))) return false;
            }
        }
        return true;
    }

    public static boolean checkStudentAvailableFlag(Classroom classroom, Student student)
    {
        for(Classroom c : student.getPersonClasses()){
            if(c.getClassPeriod() == classroom.getClassPeriod()){
                return false;
            }
        }
        return true;
    }

}
