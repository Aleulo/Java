import java.util.*;
public class Word implements Comparable<Word>
{
//fields
private String original;
private String canonical;
/*
*
*constructor
*/
public Word(String x)
{
this.original = x.toLowerCase();
 

char[] arr = x.toLowerCase().toCharArray();//put everything in the aray to sort it

Arrays.sort(arr);

String string = new String(arr);

this.canonical = string;


}//end of the constructor

//getters

public String getWord()
{
return original;

}//end of the getWord


public String getForm()
{
return canonical;

}//end of the getForm

/*
*getter
*@return String original and canonical
*/
public String toString()
{
return "[" + getWord() + "=" + getForm() + "]";

}//end of toString

/*
*This method uses overrides compareTo interface and compare canonical forms
*@return integer depends what is bigger
*/
public int compareTo(Word x)
{
 
 return canonical.compareTo(x.getForm());


}//end of compareTo













}//end of the class