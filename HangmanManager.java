/*
 *@author Aleksand Ivanov
 *@version HangmanManager 2/2/2020
 *This program take the text and a user input and then  delays picking a word until it is forced to. 
 *As a result, the computer is always considering a set of words that could be the answer. 
 *In order to fool the user into thinking it is playing fairly, the computer only considers words with the same letter pattern. 
 *
 *
 */

import java.util.*;



public class HangmanManager 
{
//fields
   private Set<String> text = new TreeSet<String>();//the whole text
   private SortedSet sorted = new TreeSet();
   private int length;
   private int max;

   private String pat = "";



      




/*
*The constructor
*@trows exception if length is less than 1 and max isless than 0
*/

   public HangmanManager(List <String> Dictionary, int length, int max) 
   {
   
   //exception 
      if(length < 1 && max < 0)
      {
         throw new IllegalArgumentException("Length is less than 1. Length: " + length + ". And max is less than 0. max: " + max); 
      }
   
      this.length = length;
      this.max = max;
   
      
      for(int i = 0; i < length; i++)
      {
      
         this.pat+="-";
           
      }
   
   
   
   
      Iterator<String> itr = Dictionary.iterator();//checking length of the word
      while (itr.hasNext())
      {
         String word = itr.next();
         if(word.length()==length)
         {
            text.add(word);
            
         
         }
      
      }
   
   
   
   
   
   
   
   
   
   }//constructor

/*
 *Getters
 *@return text
*/

   public Set<String> words()
   {
   
      return this.text;
   
   }//end of Words

/*
*Getter
*@return max
*/
   public int guessesLeft()
   {
   
      return this.max;
   
   }//end of guesses Left



/*
*The client calls this method to find out the current set of letters that have been guessed by the
user.
*@return sorted 
*/

   public Set<Character> guesses() 
   {
      return sorted;
   
   
   }//end
/*
*This method returns the set of characters. So, it returns the pattern.Also,it add space after each character
*/
   public String pattern()
   {
   //value to return
   
      String space = " ";
      String pater = "";
   
   //exceptions
      if(text.isEmpty())
      {
         throw new IllegalStateException("Your text is empty");
      
      }
     
      
      
      
      for(int i = 0; i < pat.length();i++)//adds space after each letter
      {
         pater += String.valueOf(pat.charAt(i));
         
         if (i != pat.length()-1) 
         {
            pater+=(space);  
         } 
      }
   
      return pater;
   
   }//end

/*
*This method Using this guess decides what set of words to use going forward. 
*It should return the number of occurrences of the guessed letter in the new pattern and 
*it should appropriately update the number of guesses left. 
   *This method should throw an IllegalStateException if the number of guesses left is not at least 1 
   *or if the list of words is empty. It should throw an IllegalArgumentException if 
   *the list of words is nonempty and the character being guessed was guessed previously. 
   */
 

   public int record(char guess) 
   {
      if (max < 1 && text.isEmpty())
      {
         throw new IllegalStateException("number of guesses is less than 1 and list of words is empty");
      }//end of the 1 exception
   
   
      if (!text.isEmpty() && sorted.contains(guess))
      {
         throw new IllegalArgumentException("The text is not empty and you guessed this character");
      }//end of 2 exception
   
      Map<String, List<String>> big = new TreeMap<String, List<String>>();
      Set<String> patterSet = new TreeSet<String>();
      String wordPattern = "";
   
      sorted.add(guess);//add guessed letter to the list
   
      
      for (String word : text) //add pattern and family of words to the set and also add pattern to the set
      {
      
         String returnPat = patternReturn(word, guess);
         putObjects(big, returnPat, word);//add key and value to the list
         patterSet.add(returnPat);
          
         
      
      }
     
      
     
      Iterator<String> itr = patterSet.iterator();
     
      int maxNumber = 0;
      
      List<String> family = new ArrayList<String>();
     
      while(itr.hasNext())
      {
         String key = itr.next();
         List <String> line =  big.get(key);
         if (maxNumber < line.size())//if max less than size of list then max becomes the seize of it and pattern becomes the key
         {
            maxNumber = line.size();
            family.clear();
            family.addAll(line);
            wordPattern = key;
         
         
         
                
         } else if(maxNumber>=line.size()){
         
            big.remove(key);
         
         }             
         
         
        
        
      }//end of while
      
      
     
      
         
             
     
      this.text.retainAll(family);
         
     //check if pattern has the character. If not then decrease the number of guesses
     
      if(countGuess(wordPattern, guess)==0)
      {
         max--;
      
      }
     
    
      this.pat = curPattern(wordPattern, guess);
     
     //then we need to call the method that will count the quantity of the guessed character in the word
      return countGuess(wordPattern, guess);
     
   
   }//end of the record method


/*
*This method adds guesses to the current patter
*/
   private String curPattern(String part,char let)
   {
      
      char[] arr = part.toCharArray();
      Map<Integer, Character> letter = new TreeMap<Integer,Character>();
      
      int count = 0;
      char[] pattern = pat.toCharArray();
      
      for(int i = 0; i < arr.length; i++)
      {
         if(arr[i]!='-')
         {
            letter.put(i, arr[i]);//it puts index of letter and letter to the map
            
            count++;
         
         }          
      
      }
      
      if(count == 0)
      {
         return pat;
      
      }
      for(int key : letter.keySet())
      {
         char value = letter.get(key);
         pattern[key] = value;
      
      }
      
      String string = new String(pattern);
      
      return string;
   
   
   }

/*
*this method put the values for each key into array. I decided to not use MULTIMAP
*/
   private void putObjects (Map<String, List<String>> Elements, String key, String value) {
      List<String> ClassList = Elements.get(key);
      if(ClassList == null) {
         ClassList = new ArrayList<String>();
         Elements.put(key, ClassList);
      }
      ClassList.add(value);
   
   }

     




/*
*this method recieves the word and the character and the returns the number of this character in the word
*/
   private static int countGuess(String word, char letter)
   {
      int quant = 0;//the quantity of times the letter occurs in the word
   
   
      for(int i = 0; i < word.length();i++)//for the length of the word
      {
         if(word.charAt(i)==letter)//if the letter in the word equal the parameter letter
         {
            quant++;
           
         }
        
        
      }//end of for
   
      return quant;
   
   
   }










/*
*this method recieves word and letter and returns the String pattern
*/
   private static String patternReturn(String word, char letter)
   {
      String newWord = "";
   
      for(int i = 0; i < word.length();i++)
      {
         if (word.charAt(i) == letter)
         {
            newWord+=letter;
         } else {
         
            newWord+="-";
         }
      
      }//end of for
      return newWord;
   }//end of the method


































}//end of the class