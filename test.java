import java.util.*;
public class test
{

public static void main(String[] args)
{
Map<String, String> tree = new HashMap<String, String>();

tree.put("2","k");
tree.put("3","k");
tree.put("4", "k");

tree.put("e", "ow");
tree.put("-w" , "aw");
Set<String> r= new TreeSet<String>(tree.keySet());

System.out.println(r);


}




}