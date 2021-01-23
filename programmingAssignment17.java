import java.util.*;
// Aleksandr Ivanov
//Computer science Java 141
//ProgrammingAssignment 17
//3/12/2019
//This program accepts a String as a parameter 
//and produces/returns an array of integers 
//representing the count of each vowel in the String.

public class programmingAssignment17
{

public static void main(String[] args)//a e i o u
{
//define the string 
String answer = ""; 
//define the array 
int[] result;
//create the scanner
Scanner console = new Scanner(System.in);
System.out.println("Please enter the String: ");
answer = console.nextLine();//get the first answer


while(!(answer.equals("STOP")))//while it does not equa stop
{
answer = answer.toLowerCase();//to make all we characters lower case

result = vowelCount(answer);//call the method
System.out.println(Arrays.toString(result));//make array to string 


System.out.println("Please enter another String: ");//get another line
answer = console.nextLine();
}

}//end of the main

public static int[] vowelCount(String sentence) 
{




//the array for the result
int[] result = new int[5];


for(int i = 0; i < sentence.length(); i++)//to go through all the length of the string
{
switch(sentence.charAt(i))//to check each character if it equals to one of the vowels we are searching for
{
case 'a':
result[0]++;
break;
            
case 'e':;
result[1]++;
break;
            
case 'i':;
result[2]++;
break;
            
case 'o':
result[3]++;
break;
            
case 'u':
result[4]++;
break;
}//end of the switch
}//end of the for loop

    
return result;

}//end of the method





} //end of the class