// Aleksandr Ivanov
//Computer science Java 141
//Array practice 1
//3/11/2019
//This program accepts an integer x and an array a of integers as its parameters.   
//It should then return the elements that that k elements of greater or equal value.  
public class ArrayPractice1
{

public static void main(String[] args)
{
int[] array1 = {6, 8, 2, 3, 5, 12, 16, 1, 7, 4, 21, 19};
int answer = kthLargest(0,array1);
 System.out.println(answer);
 
 answer = kthLargest(1,array1);
 System.out.println(answer);
 
 answer = kthLargest(2,array1);
 System.out.println(answer);
 
 answer = kthLargest(10,array1);
 System.out.println(answer);
 
 answer = kthLargest(11,array1);
 System.out.println(answer);
 
 answer = kthLargest(-1,array1);
 System.out.println(answer); 
 
 answer = kthLargest(20,array1);
 System.out.println(answer); 
 



}//End of the main method


public static int kthLargest(int x, int a[])
{
//Create a new array that will have sorted values(Copy)
final int SIZE = a.length;
int b[] = a.clone();//copy of the array


if (x < 0 || x >= SIZE)//checking if x is an appropriate parameter
{
return -9999;
}

int temporary = 0;
		
for(int i=0; i < SIZE; i++)//to sort the array
{
for(int j=1; j < (SIZE-i); j++)
{
				
if(b[j-1] < b[j])
{
					
temporary = b[j-1];
b[j-1] = b[j];
b[j] = temporary;
}
				
}
       
}



return b[x];//the value that is needed


}//End of the method




















}//End of the class