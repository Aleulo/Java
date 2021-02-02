//Aleksandr Ivanov, cs141, Fall 2019
//Programming Assignment #8, 1/30/2019
//
//This program takes the string and the number and then gives new string with stars
/*

I really apologize for late submit since I did it but I forgot to send it.


*/
public class ProgrammingAssignment8 
{
public static void main(String[] args) {

//Testing the result

String result1 = padStrings("Hello", 3);

String result2 = padStrings("JavaProgramms", 1);

String result3 = padStrings("Hello", 10);

String result4 = padStrings("Hello", 12);

String result5 = padStrings("Hello", 5);

String result6 = padStrings("Hello", 0);


//Print the result
System.out.println("#1 "+result1);
System.out.println("#2 "+result2);
System.out.println("#3 "+result3);
System.out.println("#4 "+result4);
System.out.println("#5 "+result5);
System.out.println("#6 "+result6);




}//End of main method



public static String padStrings(String word, int length)
{
int stars = length - word.length();//to find the correct ammount of stars

for(int i = 0; i < stars; i++) // to add the stars to the new string
{

word += "*";



}//for loop end

return word;//To return the String to main





}//End of the method





}//End of the class 