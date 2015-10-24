import java.util.*;
import java.util.Scanner;
public class stringscan
{
public static void main (String args[])
{
 
String testi;
Scanner scan = new Scanner(System.in);
 
System.out.println("Testing Scanner, write something: ");
testi = scan.nextString(); 
System.out.println(testi);
}
}