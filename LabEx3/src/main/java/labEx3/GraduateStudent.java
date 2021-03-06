import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class GraduateStudent extends studentt {
    private String supervisor; 
    private boolean isPhD;
    private String undergraduateSchool;
    private boolean gradStudent; 


    public GraduateStudent(String program, int year, double grade, boolean isPhD){
        this.program = program;
        this.year = year;
        this.grade = grade; 
        this.isPhD = isPhD;
    }


    public GraduateStudent (String program, int year, double grade, String supervisor, boolean isPhD){
        this.program = program;
        this.year = year;
        this.grade = grade; 
        this.supervisor = supervisor;
        this.isPhD = isPhD;

    }

    public GraduateStudent (String program, int year, double grade, String supervisor, boolean isPhD, String undergraduateSchool){
        this.program = program; 
        this.year = year;
        this.grade = grade; 
        this.supervisor = supervisor; 
        this.isPhD = isPhD;
        this.undergraduateSchool = undergraduateSchool; 
    }


    public GraduateStudent (){
        this.program = program;
        this.year = year;
        this.grade = grade; 
        this.isPhD = isPhD;
        this.supervisor = supervisor;
        
    }


    // accessors and mutators
    public void setSupervisor (String supervisor){
        this.supervisor = supervisor;
    }
    public String getSupervisor (){
        return supervisor;
    }


    public void setUndergraduateSchool (String undergraduateSchool){
        this.undergraduateSchool = undergraduateSchool;
    }
    public String getUndergraduateSchool (){
        return undergraduateSchool;
    }


    public void setIsPhD (boolean isPhD){
        this.isPhD = isPhD;
    }

    public boolean getIsPhD (){
        return isPhD;
    }


    // used to print gradstudents in arraylist
    public String toString () {
        String output;
        output = (super.toString() +
                " " +supervisor+
                " " + isPhD+
                " " +undergraduateSchool);
        return output;
    }

    public void gradOption(){
        
    }
}
