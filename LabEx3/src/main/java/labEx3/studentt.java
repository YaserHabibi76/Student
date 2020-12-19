import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.io.PrintWriter; // write to text file
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class studentt {
    // protected to give access to GraduateStudent.java
    protected int year;
    protected double grade; 
    protected String program; 
    public static String studentInfoArr[];


    public studentt(String program, int year, double grade){
        this.program = program;
        this.year = year;
        this.grade = grade; 
    }


    public studentt(){

    }

    // getters and setters

    public void setProgram (String program){
        this.program = program;
    }
    public String getProgram (){
        return program;
    }


    public void setYear (int year){
        this.year = year;
    }
    public int getYear (){
        return year;
    }


    public void setGrade (double grade){
        this.grade = grade;
    }
    public double getGrade (){
        return grade;
    }


    // used to print students in arraylist
    public String toString () {
                
        return (program +
                " " +year +
                " " +grade);

    }



    public static boolean checkGradeInput(String str){
        try{
            Double.parseDouble(str);
            return true;
        } catch( Exception e){
            return false;
        }
    }

    

    public static void main (String [] args){
        String studentInfo;
        Scanner scan = new Scanner(System.in);
        int size;  
        ArrayList <studentt> stu = new ArrayList <studentt>();
        String program;
        int year;
        double grade; 
        boolean continueQuestions = true; 
        int option; 
        boolean gradStudent = false;
        String enterProgram;


        // System.out.println ("Please enter your program, year of study, and average grade (optional)");  

        // studentInfo = scan.nextLine();
        // studentInfoArr = studentInfo.split("[, ]+");
 
        // size = studentInfoArr.length;
        // System.out.println(size);

        // // adding to arraylist based on size of input

        // if (size < 2) {
        //     System.out.println("Incorrect Input. Note: Program name and year of study is required! Please Try Again");
        // }
        // else if (size ==2){
        //     program = studentInfoArr[0];
        //     year = Integer.parseInt(studentInfoArr[1]);
        //     grade = 0.0;

        //     studentt temp = new studentt(program, year, grade);
        //     stu.add(temp);
        // }
        // else if (size ==3){
        //     program = studentInfoArr[0];
        //     year = Integer.parseInt(studentInfoArr[1]);
        //     grade = Double.parseDouble(studentInfoArr[2]);

        //     studentt temp2 = new studentt(program, year, grade);
        //     stu.add(temp2);
        // }
        // else {
        //     System.out.println("Incorrect Input. Terminating program");
        //     System.exit(0);
        // }


        // repeated questions

        while (continueQuestions) {

            System.out.println();            
            System.out.println("Choose one of the following options...(1,2,3,4, or 5)");
            System.out.println("(1) Enter information for a new student");
            System.out.println("(2) Enter information for a new GraduateStudent");
            System.out.println("(3) Show all student information with each attribute on a seperate line");
            System.out.println("(4) Print the average of the average grades for class, as well as the total number of students");
            System.out.println("(5) Enter a specific program and show all student information for that program");
            System.out.println("(6) Load student information from an input file");
            System.out.println("(7) Save all student information to an output file");
            System.out.println("(8) End program.");

            option = scan.nextInt();
            scan.nextLine();

            //student option
            if (option ==1){

                System.out.println ("(Student) Please enter your program, year of study, and average grade (optional)");


                studentInfo = scan.nextLine();
                studentInfoArr = studentInfo.split("[, ]+");
        
                size = studentInfoArr.length;
                System.out.println(size);


                if (size < 2) {
                    System.out.println("Incorrect Input. Note: Program name and year of study is required! Please Try Again");
                    System.exit(0);
                }
                else if (size ==2){
                    program = studentInfoArr[0];
                    year = Integer.parseInt(studentInfoArr[1]);
                    grade = 0.0;
                    studentt temp = new studentt(program, year, grade);
                    stu.add(temp);
                }
                else if (size ==3){
                    program = studentInfoArr[0];
                    year = Integer.parseInt(studentInfoArr[1]);
                    grade = Double.parseDouble(studentInfoArr[2]);
                    studentt temp2 = new studentt(program, year, grade);
                    stu.add(temp2);
                }
                else {  
                    System.out.println("Incorrect Input");
                    System.exit(0);
                }   
            } 



            //GraduateStudent option 
            else if (option ==2){


                GraduateStudent gradStdt = new GraduateStudent();
                gradStdt.gradOption();
                boolean isPhdboolean;

                System.out.println ("(GraduateStudent) Please enter your program, year of study, and average grade (optional), supervisor (mandatory), isPhD (mandatory), undergradSchool ");


                studentInfo = scan.nextLine();
                studentInfoArr = studentInfo.split("[, ]+");
        
                size = studentInfoArr.length;
                System.out.println(size);

                //adding to arraylist based on size of userinput

                if (size < 4) {
                    System.out.println("Incorrect Input. Note: Program name, year of study, supervisor, and isPhD(1 or 0) is required!");
                    System.exit(0);
                }
                else if (size ==4){
                    program = studentInfoArr[0];
                    year = Integer.parseInt(studentInfoArr[1]);
                    grade = 0.0;
                    // setSupervisor(studentInfoArr[2]);
                    // String sprVisor = getSupervisor();
                    gradStdt.setSupervisor(studentInfoArr[2]);

                    if (studentInfoArr[3].equals ("1")){
                        gradStdt.setIsPhD(true);
                    }
                    else if (studentInfoArr[3].equals ("0")){
                        gradStdt.setIsPhD(false);
                    }

                    GraduateStudent temp = new GraduateStudent(program, year, grade, gradStdt.getSupervisor(), gradStdt.getIsPhD());
                    stu.add(temp);
                }

                //Checking if the grade was entered by the user
                boolean grdInput = checkGradeInput(studentInfoArr[2]);
                //System.out.println("It returned : "+ grdInput);


                if ((size ==5) && (grdInput == true)){
                    program = studentInfoArr[0];
                    year = Integer.parseInt(studentInfoArr[1]);
                    grade = Double.parseDouble(studentInfoArr[2]); 
                    gradStdt.setSupervisor(studentInfoArr[3]);

                    if (studentInfoArr[4].equals ("1")){
                        gradStdt.setIsPhD(true);
                    }
                    else {
                        gradStdt.setIsPhD(false);
                    }
                    GraduateStudent temp3 = new GraduateStudent(program, year, grade, gradStdt.getSupervisor(), gradStdt.getIsPhD());
                    stu.add(temp3); 

                }
                else if ((size ==5) && (grdInput == false)){
                    grade = 0.0;
                    program = studentInfoArr[0];
                    year = Integer.parseInt(studentInfoArr[1]);
                    gradStdt.setSupervisor(studentInfoArr[3]);
                    if (studentInfoArr[4].equals ("1")){
                        gradStdt.setIsPhD(true);
                    }
                    else {
                        gradStdt.setIsPhD(false);
                    }


                    GraduateStudent temp4 = new GraduateStudent(program, year, grade, gradStdt.getSupervisor(), gradStdt.getIsPhD());
                    stu.add(temp4);
                }


                // if all possible options are entered by the user
                else if ((size ==6) && (grdInput == true)){
                    program = studentInfoArr[0];
                    year = Integer.parseInt(studentInfoArr[1]);
                    grade = Double.parseDouble (studentInfoArr[2]);
                    gradStdt.setSupervisor(studentInfoArr[3]);
                    if (studentInfoArr[4].equals ("1")){
                        gradStdt.setIsPhD(true);
                    }
                    else {
                        gradStdt.setIsPhD(false);
                    }
                    gradStdt.setUndergraduateSchool(studentInfoArr[5]);

                    GraduateStudent temp5 = new GraduateStudent (program, year, grade, gradStdt.getSupervisor(), gradStdt.getIsPhD(), gradStdt.getUndergraduateSchool());
                    stu.add(temp5);

                }

                else {
                    System.out.println("Incorrect Input");
                    System.exit(0);
                }   
            } 













            // print everything stored in arraylist
            else if (option ==3){
  
                GraduateStudent test = new GraduateStudent();
                studentt sss = new studentt();


                // int count =0;
                System.out.println("Printing all students and gradStudents entered thus far... \n");
                int studentCounter =0;

                for (int j=0; j< stu.size(); j++){

                    studentCounter ++;
                    System.out.println("Student/ GradStudent Number: " + studentCounter);

                    System.out.println(stu.get(j).toString());
                    System.out.println("\n");
            
                }
            }


            //printing total number of students and the average grades amongst all the students added to the arraylist
            else if (option ==4){
                double averageGrade = 0.0;
                int i=0;
                int counter =0;
                System.out.println("Total number of students thus far: "+stu.size());

                studentt avg = new studentt();
                for (i=0; i< stu.size(); i++){
                    avg = stu.get(i);
                    counter++;
                    System.out.println(avg.getGrade());
                    averageGrade += avg.getGrade(); 
                }
                averageGrade = averageGrade / counter; 
                System.out.println("Average of the average grades for class is: "+averageGrade);


            }
            //get user to enter a specific program and show all information for that student
            else if (option ==5){
                int m =0;
                String specProgram; 
                boolean specprog;
                studentt specificProgram = new studentt();
                String equalChecker; 

                System.out.println("Please enter a specific program: ");
                specProgram = scan.nextLine();
                System.out.println();
                System.out.println("Showing all student information for that program");

                for (m=0; m< stu.size(); m++){
                    specificProgram = stu.get(m);

                    equalChecker = specificProgram.getProgram();

                    if (specProgram.equalsIgnoreCase(equalChecker)){
                        System.out.println();

                        System.out.println(stu.get(m).toString());
                        System.out.println("\n");
                    }
                }
          
            }




            // reads and parses a file into the arraylist
            else if (option ==6){
                String fileInput;
                String spt[]; 
                System.out.println("Please enter the name of the input file: ");
                fileInput = scan.nextLine(); 

                Scanner inputStream = null; 

                try 
                {
                    inputStream = 
                        new Scanner (new FileInputStream (fileInput));
                    
                    //looping through the entire file
                    while (inputStream.hasNextLine()){

                        String data = inputStream.nextLine();

                        studentInfoArr = data.split("[, ]+");

                        boolean grdInput = checkGradeInput(studentInfoArr[2]);

                        GraduateStudent gradStdt = new GraduateStudent();
                        gradStdt.gradOption();
                        boolean isPhdboolean;
                
                        size = studentInfoArr.length;
                        System.out.println(size);

                        // checking the size of data in textfile
                        if (size < 2) {
                            System.out.println("Incorrect Input. Note: Program name and year of study is required! Please Try Again");
                            System.exit(0);
                        }
                        else if (size ==2){
                            program = studentInfoArr[0];
                            year = Integer.parseInt(studentInfoArr[1]);
                            grade = 0.0;
                            studentt tempp = new studentt(program, year, grade);
                            stu.add(tempp);
                        }
                        else if (size ==3){
                            program = studentInfoArr[0];
                            year = Integer.parseInt(studentInfoArr[1]);
                            grade = Double.parseDouble(studentInfoArr[2]);
                            studentt tempa = new studentt(program, year, grade);
                            stu.add(tempa);
                        }


                        else if (size ==4){
                            program = studentInfoArr[0];
                            year = Integer.parseInt(studentInfoArr[1]);
                            grade = 0.0;

                            gradStdt.setSupervisor(studentInfoArr[2]);

                            if (studentInfoArr[3].equals ("1")){
                                gradStdt.setIsPhD(true);
                            }
                            else if (studentInfoArr[3].equals ("0")){
                                gradStdt.setIsPhD(false);
                            }

                            GraduateStudent temp = new GraduateStudent(program, year, grade, gradStdt.getSupervisor(), gradStdt.getIsPhD());
                            stu.add(temp);
                        }


                        else if ((size ==5) && (grdInput == false)){
                            grade = 0.0;
                            program = studentInfoArr[0];
                            year = Integer.parseInt(studentInfoArr[1]);
                            gradStdt.setSupervisor(studentInfoArr[3]);
                            if (studentInfoArr[4].equals ("1")){
                                gradStdt.setIsPhD(true);
                            }
                            else {
                                gradStdt.setIsPhD(false);
                            }


                            GraduateStudent temp4 = new GraduateStudent(program, year, grade, gradStdt.getSupervisor(), gradStdt.getIsPhD());
                            stu.add(temp4);
                        }


                        else if ((size ==6) && (grdInput == true)){
                            program = studentInfoArr[0];
                            year = Integer.parseInt(studentInfoArr[1]);
                            grade = Double.parseDouble (studentInfoArr[2]);
                            gradStdt.setSupervisor(studentInfoArr[3]);
                            if (studentInfoArr[4].equals ("1")){
                                gradStdt.setIsPhD(true);
                            }
                            else {
                                gradStdt.setIsPhD(false);
                            }
                            gradStdt.setUndergraduateSchool(studentInfoArr[5]);

                            GraduateStudent temp5 = new GraduateStudent (program, year, grade, gradStdt.getSupervisor(), gradStdt.getIsPhD(), gradStdt.getUndergraduateSchool());
                            stu.add(temp5);

                        }

                    }
                }
                catch (FileNotFoundException e)
                {
                    System.out.println("The file: "+ fileInput+" was not found");
                    System.out.println("or could not be opened.");
                    System.exit(0);
                }


            }

            //get the user to enter a file name... enter all data stored in arraylist into the file.
            else if (option ==7){
                String fileOption;
                System.out.println("Please enter a file name to enter data into..");
                fileOption = scan.nextLine();

                try{

                    FileWriter myWriter = new FileWriter (fileOption);
                    for (int j=0; j< stu.size(); j++){
  
                        myWriter.write ((stu.get(j).toString()));
                        myWriter.write("\n");     
            
                    }

                    myWriter.close();

                } catch (FileNotFoundException e){
                    System.out.println("Error opening/ writing to the file");
                    System.exit(0);
                }
                catch (IOException i ){
                    System.out.println("IO exception error: terminating program");
                    System.exit(0);
                }
            }


            // if user chooses to terminate the program
            else if (option ==8){
                System.out.println ("Thank You for coming! Bye now!!!!");
                continueQuestions = false;
                System.exit(0);
            }

            else{
                System.out.println("Incorrect Input, terminating program. BYE NOW!");
                System.exit(0);
            }

        }


    
    }
}
