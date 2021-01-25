import java.util.*;
/*
*This programm generates random sentence with the given grammar
*
*
*@author Aleksandr Ivanov
*@version 2/14/2020 Grammar Solver
*
*/
public class GrammarSolver
{
//fields
   private Map<String, Set<String>> grammar = new TreeMap<String, Set<String>>();
   private Set<String> unique = new HashSet<String>();
     
/*
*
*Constructor
*@throw IllegalArgumentException if the list is null, or empty (size 0)
*@throw IllegalArgumentException if the grammar contains more than one line 
for the same non-terminal. 
*/



   public GrammarSolver(List<String> text)
   {
       //exceptions
      if(text == null || text.isEmpty())
      {
         throw new IllegalArgumentException();
      }
         
         
      for(String line: text)
      {
         String[] part = line.split("::=");//separete non-terminal and terminals
         part[0] = part[0].trim();//delete spaces in front of the word and after
         if(grammar.keySet().contains(part[0]))
         {
            throw new IllegalArgumentException("Your non-terminal set has this word");
         
         }
         
         part[1] = part[1].trim();
         String[] newArr = part[1].split("[|]"); //separaate terminal tab
         for(int i = 0; i< newArr.length;i++)
         {
          
            newArr[i] = newArr[i].trim();
         }
         
         Set set = new HashSet(Arrays.asList(newArr));//set for terminals
         
                  
         grammar.put(part[0], set);//connect non terminal and rules putting set
        
         
         for(String rule: newArr)
         {
            String[] uniqueWord = rule.split(" ");
            for(String uWord : uniqueWord)
            {
               unique.add(uWord);
            }
         
         }
      
      
      }
      
      
      
   
   
   
   }//End of the contructor

/*
*
*This method checks if grammar has givven terminal or not
*@return true if the given symbol is a non-terminal in the grammar and false otherwise
*@throws  IllegalArgumentException if the string is null or has a length of 0. 
*/
   public boolean contains(String symbol)
   {     //exception
      if(symbol == null || symbol.isEmpty())
      {
         throw new IllegalArgumentException("Your string is null or empty");
      }
        
        
      if(grammar.keySet().contains(symbol)||unique.contains(symbol))//if non-terminals contain the symbol
      {
      
         return true;
      
      } else {
      
         return false;
      }
   
   
   
   
   
   }//end of the class

/*
*@return  all non-terminal symbols of your grammar as a sorted set of strings. 
*/
   public Set<String> getSymbols()
   {
   
      return grammar.keySet();
   
   
   }//end of getSymbols

/*
*This mehod generate  uses the grammar to generate a random occurrence of the given symbol 
*@return String of  random occurrence of the given symbol 
*@throw IllegalArgumentException if the string is null or has a length of 0. 
*@return the String of random sentence 
*/
   public String generate(String symbol)
   {
      Random rand = new Random();//create random
   
   
     //exception
      if(symbol == null || symbol.isEmpty())
      {
         throw new IllegalArgumentException("Your string is null or empty");
      }
      
      String result = "";
      
      if(!grammar.keySet().contains(symbol))//if the symbol is non-terminal
      {
         String end = symbol + " ";
         result+=end;
      
         return result;
      
      
      } else {
      
      //Random object
         List<String> l = new ArrayList(grammar.get(symbol));
         int rNumber = rand.nextInt(l.size());//chose the roole
         String rule = l.get(rNumber);
      
         List<String> ll = new ArrayList<String>(Arrays.asList(rule.trim().split("[\\s*,\\s*]+")));//separate the rule by space or comma 
      
      
         for(String word: ll)
         {  
            word = word.trim();
            String midle = "";
         
          
         
         
            midle = generate(word);
          
          
         
            if(!grammar.keySet().contains(midle))  
            {
               result+=midle;
            
            }
                       
         }
      
         return result; 
      
      }
      
      
   
   
   
   
   
   
   
   }//end of generate method



















}//end of the class