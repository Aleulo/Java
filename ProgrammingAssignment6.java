//Aleksandr Ivanov, cs141, Fall 2019
//Programming Assignment #6, 1/27/2019
//
//This program prints the quadratic roots 
public class ProgrammingAssignment6 
{
public static void main(String[] args) 
{


printQuadratic(1, -7, 12);


}//main

public static void printQuadratic(double a, double b, double c)
{
//define the variables
double firstRoot = 0;
double secondRoot = 0;
int result1 = 0;
int result2 = 0;
double d = 0;

//Get the discriminant
d = b*b-(4*a*c);

firstRoot = (-b+Math.sqrt(d))/(2*a) ;//calculations for the first root

secondRoot = (-b-Math.sqrt(d))/(2*a)  ;//calc for the second root

result1 = (int) firstRoot;
result2 = (int) secondRoot;

//Print the results to the user

System.out.println("X1 root = " + result1);
System.out.println("X2 root = " + result2);

}//end of the method

}//end of the class
