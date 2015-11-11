/*
(a) Write a pseudo-code description of an efficient algorithm, utilizing recursion, for finding the
mean of an n-element unsorted linked list. (b) Estimate the time complexity of the algorithm. (c)
Implement the algorithm then compare the expected time complexity to the actual empirical
results obtained from the implementation; explain any discrepancies. [30]

L
Add number and divide by N neach time , should be On compelxity
*/
import java.util.Scanner;
// Linked List skeleton from Lafore
class Link
{ // data item (key)
    public double dData; // data item
    public Link next; // next link in list
    // -------------------------------------------------------------
    public Link(double dd) // constructor
    { // initialize data
        dData = dd; // (‘next’ is automatically
    } // set to null)
    // -------------------------------------------------------------
    public void displayLink() // display ourself
    {
        System.out.print("{ " + dData + "} ");
    }
} // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
    private Link first; // ref to first link on list
    private double size;
    // -------------------------------------------------------------
    public LinkList() // constructor
    {
        first = null; // no items on list yet
    }
    // -------------------------------------------------------------
    public boolean isEmpty() // true if list is empty
    {
        return (first==null);
    }
    // -------------------------------------------------------------
    // insert at start of list
    public void insertFirst(double dd)
    { // make new link
        Link newLink = new Link(dd);
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
        size++;
    }
    // -------------------------------------------------------------
    public Link deleteFirst() // delete first item
    { // (assumes list not empty)
        Link temp = first; // save reference to link
        first = first.next; // delete it: first-->old next
        size--;
        return temp; // return deleted link
    }
    // -------------------------------------------------------------
    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while(current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println();
    }
    
    // recursively calculate the mean
    public double Mean()
    {
        // store current link to iterate!
        Link current = first;
        // call the recursive funtion
        return recMean(current);
    }
    // recursive mean
    public double recMean(Link current){
        //  divide value of current link by total size of linked list
        double temp = current.dData/size;
        // if the end of the LL is reached, break recursion
        if (current.next == null){
            return (temp);
        } else { // otherwise
            current = current.next; // increment link
            return (temp + recMean(current)); // add value to the rest of the recursion
        }
    }
// -------------------------------------------------------------
} // end class LinkList
////////////////////////////////////////////////////////////////
class LinkListApp
{
    public static void main(String[] args)
    {
        
        
        Scanner reader = new Scanner(System.in);
        // prompt user for size of the array
        System.out.print("How many elements do you want in the Linked List? : ");
        int numberOfLinks = reader.nextInt();
        LinkList theList = new LinkList();
        // enter all values of the array
        for (int i = 0; i < numberOfLinks ; i++){
           //System.out.print("Enter a floating point or int, " + (numberOfLinks - i) + " remaining : ");
           double newNumber = (int)(Math.random() * (5000)); // could randomly generate : (int)(Math.random() * (100000));
           theList.insertFirst(newNumber); // insert user prompted value!
       }
        
        // theList.displayList(); // display list
        long startTime = System.nanoTime();
        System.out.println("Mean is : " + theList.Mean()); // display list
        long estimatedTime = System.nanoTime() - startTime;
        // output time of computation and printing
        System.out.println(estimatedTime/1000000000.0000 + " Seconds to calculate mean");
    } // end main()
} // end class LinkListApp