import java.util.*;
/*
*This programm  will construct  an object that contains both a word and its canonical form, and this is a manager class to keep track of an array of these words.   
*Therefore, it will work with Original form of the word and canonical
*
*@author Aleksandr Ivanov
*@version 5/16/2019 Anagram Manager
*
*/

public class AnagramManager
{
private Word[] manager = null;



/*
*
*Constructor
*@throw IllegalArgumentException if the list is null, or empty (size 0).
*/
public AnagramManager(List<String> list)
{
//exception
 if(list == null || list.isEmpty())
      {
         throw new IllegalArgumentException();
      }
 
 //creating new Array of words     
manager = new Word[list.size()];
int count = 0;


//going through the list and filling the array
for(String wordList : list)
   {
      Word string = new Word(wordList);
      manager[count] = string;
      count++;
    } 
      
      

}//end of the constructor



/*
*
*This method sort by the original word
*/
public void sortByWord()
{
/*
    for(int i = 0;i < manager.length-1;i++)
       {
       //find the index of the smallest ellemnet 
       int smallest = i;
       for(int j = i+1;j<manager.length;j++)
           {
           if(manager[j].getWord().compareTo(manager[smallest].getWord())<0)
             {
             smallest = j;
             }
           
           }//end of inner loop
       
            swap(manager, i, smallest);//smallest to the front
       }//end of outer for
*/

mergeSort(manager, 1);

}//end of the sortByWord

/*
*This method sorts the array by canonical form
*/
public void sortByForm()
{
   /* for(int i = 0;i < manager.length-1;i++)
       {
       //find the index of the smallest ellemnet 
       int smallest = i;
       for(int j = i+1;j<manager.length;j++)
           {
           if(manager[j].compareTo(manager[smallest])<0)
             {
             smallest = j;
             }
           
           }//end of inner loop
       
            swap(manager, i, smallest);//smallest to the front
       }//end of outer for*///This algorithm takes much longer
       mergeSort(manager, 0);
       
       
       

}//end of the sortByWord


private static void mergeSort(Word[] man, int number)
{
if(man.length> 1)
{
 
       Word[] left = Arrays.copyOfRange(man, 0, man.length/2);
       Word[] right = Arrays.copyOfRange(man, man.length /2, man.length);
       
       
      mergeSort(left, number);
      mergeSort(right, number);
      
      if(number == 0)
      {
      
      merge(man, left, right);
      } else if(number==1)
      {
      merge1(man, left, right);
      
      }
}

}

/*
*
*This method just change alemnts order
*/
/*
private static void swap(Word[] list, int i, int j)
 {
  Word temp = list[i];
  list[i] = list[j];
  list[j] = temp;
 
 
 }
 */
 
 /*
 *This method retrun randomly the original word that has the same canonical word\
 *@return return a random word from the array that has the same canonical 
 *@param String x that is original form of the word
 */
 public String getAnagram(String x)
 {
 Random r = new Random();
 Word example = new Word(x);
 int count = 0;
 for(int i = 0;i < manager.length; i++)
     {
     
     if (manager[i].compareTo(example)==0)//count how many simmilar canonical words
       {
       
       count++;
       }
     
     
     
     }//end of 1 loop
     
    
     
     if(count == 0)//if no then return empty string
      {
      
      return "";
      
      } else {
      
      Word[] newArr = new Word[count];//create the new array with the size of quantity of same canonical words in array
      int count2 = 0;
         for(int i = 0; i< manager.length; i++)
             {
             if(manager[i].compareTo(example)==0)
               {
               newArr[count2] = manager[i];//fill the array same words
               count2++;
               
               }
             
             }//end of loop
             
          int random = r.nextInt(newArr.length);//randomly choose the word
          return newArr[random].getWord();
      
      }
 
 
 }//end of the getAnagram
 
/*
*This method returns a set of words that has the same canonical form as the word entered
*@return the set of words
*/
 public Set<String> getAnagrams(String x)
 {
 Set<String> set = new TreeSet<String>();
 Word example = new Word(x);
 
  for(int i = 0;i < manager.length; i++)
     {
     
     if (manager[i].compareTo(example)==0)
       {
       
       set.add(manager[i].getWord());
       }

 
 
    }
    
    return set;
 }
 /*
 *This method returns the string of five words in the front and five from the back of the array
 */
public String toString()
{

String result = "";
for(int i = 0; i < 5; i++)
   {
   
   result+=manager[i].toString();
   
   }
   
for(int i = manager.length-6;i<manager.length;i++)
    {
    
    result+=manager[i].toString();
    
    }

return result;

}

/*
*This method does merge sort algorithm like in the book
*/
private static void merge(Word[] result, Word[] left, Word[] right)
{

  int i1 = 0;//index into left Array
  int i2 = 0;//index into right array
  
  for(int i = 0; i < result.length;i++)
     {
     if (i2 >= right.length || (i1 < left.length && left[i1].compareTo(right[i2]) <= 0))
        {
        
        result[i] = left[i1];
        i1++;
        } else {
               result[i] = right[i2];
               i2++;
        
        }
     
     }
}
/*
*This method is the same like the previous one but it compares original words 
*/
private static void merge1(Word[] result, Word[] left, Word[] right)
{

  int i1 = 0;//index into left Array
  int i2 = 0;//index into right array
  
  for(int i = 0; i < result.length;i++)
     {
     if (i2 >= right.length || (i1 < left.length && left[i1].getWord().compareTo(right[i2].getWord()) <= 0))//here is the difference
        {
        
        result[i] = left[i1];
        i1++;
        } else {
               result[i] = right[i2];
               i2++;
        
        }
     
     }



}



}//end of the class