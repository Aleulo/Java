/**
Final Exam
CS 141 Green River College

@author PutYourName
@version 0.1

This version has just the empty test cases or functions written. 
Read your way through the program, and fix it accordingly. 
To make them work you should include proper Java "import statements".

*/
import java.io.*;
import java.util.*;

public class Payroll_Solution
{
   // These are private fields
   private String EmployeeName;  
   private int IDnumber;
   
   // These are Getters/Accessors
   public String getName()
   {
      return EmployeeName;
   }
   public int getID()
   {
      return IDnumber;
   }
   
   // These are setter (mutator method)
   public void setName(String name1)
   {
      this.EmployeeName = name1;
   }
   public void setID(int ID1)
   {
      this.IDnumber = ID1;
   }
   // Cnstructor to accept employee's ID and employee name
   public Payroll_Solution(String name, int ID)
   {
      this.EmployeeName = name; 
      this.IDnumber = ID;
   }
   public Payroll_Solution() // Also a blank constructor
   {
      this.EmployeeName = "";// A blank string
      this.IDnumber = 0;     // zero as starting ID 
   }
   // =================================
   // write a "toString" method that will print out employee's name and ID
   // this "toString" method should not print out any payment information
   // for example "toString" should return value as: Juan Smith - (345678)
   public String toString()
   {
      return getName() + " - (" + getID() + ")";
   }
   // ==================================
   // Write the main function here that asks the users to enter
   // Employee Name 
   // Employee ID number
   // Sort employee IDs in an array and print all records using "toString"  
   // method in file name "HR.txt"

   public static void main(String args[]) throws FileNotFoundException
   {
      Scanner UserIn = new Scanner(System.in);
      PrintStream oFile = new PrintStream(new File("D:\\HR.txt"));
      PrintStream oFileID = new PrintStream(new File("D:\\ID.txt"));      
      Payroll_Solution xyz = new Payroll_Solution();

      System.out.println("Please enter how many records do you want, or enter 0 to exit");
      int r1 = UserIn.nextInt();
      if (r1 != 0)
      {
         int[] inID = new int[r1];
         
         for(int i = 0;i<r1;i++)
         {
            System.out.println("Please enter Employee Name: ");
            String toBeIn1 = UserIn.next();
            xyz.setName(toBeIn1);
            
            System.out.println("Please enter Employee ID: ");
            int toBeIn2 = UserIn.nextInt();
            xyz.setID(toBeIn2);
            inID[i] = toBeIn2; 
            oFile.println(xyz.toString());
         }
         Arrays.sort(inID);

         for (int j = 0; j < r1;j++)
         {
            oFileID.println(inID[j]);
         }
      }  
   }
}