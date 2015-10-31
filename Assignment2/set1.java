// Q1. Implement a deque using a double-linked list.
import java.util.Scanner;
class Link{
    public long dData;
    public Link next;
    public Link previous;
    
    public Link(long dd){
        dData = dd;
    }
    
    public void displayLink(){
        System.out.print(dData + " ");
    }
}

class DoublyLinkedList{
    
    // a list need two reference links the first and the last
    private Link first;
    private Link last;
    
    // initialize the frist and last links to null
    public DoublyLinkedList(){
        first = null;
        last = null;
    }
    
    // boolean to false if the first link is pointing to null
    public boolean isEmpty(){
        return (first == null);
    }
    
    // given a value, insert a link of that value at the beginning of the linked list
    public void insertFirst(long dd){
        // make link with given value
        Link newLink = new Link(dd);
        
        // if the link is empty, give the link first and last
        if (isEmpty()){
            last = newLink;
        } else { // otherwise, just first
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }
    
    // given a value, insert a link of that value at the end of the linked list
    public void insertLast(long dd){
        Link newLink = new Link(dd);
        
        if (isEmpty()){
            first = newLink;
        } else {
            //last.previous = last;
            last.next = newLink;
            newLink.previous = last; 
        }
        last = newLink;
    }
    
    // delete the first link on the linked list
    public Link deleteFirst(){
        // put first in a temporary link
        Link temp = first;
        
        // if there is only one link, reassign last to null as well
        if (first.next == null){
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }
    
    // delete the last link on the linked list
    public Link deleteLast(){
        // assign last to a temporary link
        Link temp = last;
        
        // if there is only one link, assign null to first as well
        if (first.next == null){
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }
    
    // given a key and a value, insert a link of that value after the link at the given key
    public boolean insertAfter(long key, long dd){
        
        // create 'current' link to iterate through list
        Link current = first;
        
        // iterate until we arive at the given key
        while ( current.dData != key ){
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        
        // create new link with given value
        Link newLink = new Link(dd);
        
        // if the given key was the last link, next should be null
        if ( current == last ){
            newLink.next = null;
            last = newLink;
        } else { // otherwise next is the following link
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        
        // do the exachange!
        newLink.previous = current;
        current.next = newLink;
        return true;
    }
    
    // given a key (position of a link) delete that link
    public Link deleteKey(long key){
        // create 'current' link to iterate through the list
        Link current = first;
        // iterate through list until we find the given value
        while ( current.dData != key ){
            current = current.next;
            if(current == null)
                { return null; }
        }
        
        // if the value is in the first link, we do not bother about previous
        if (current == first){
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        // if last we do not bother about next
        if (current == last){
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }
    
    // display the list from the first link to the last link
    public void displayForward(){
        // create 'current' link to iterate through the list
        Link current = first;
        // itereate forward and print each 'current'
        while ( current != null ){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
    
    // display the list from the last link to the first link
    public void displayBackward(){
        // create 'current' link to iterate through the list
        Link current = last;
        // itereate backwards and print each 'current'
        while ( current != null){
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }
}

class DoublyLinkedApp{
    public static void main(String [] args){
        DoublyLinkedList theList = new DoublyLinkedList();

        Scanner reader = new Scanner(System.in);
        System.out.print("How many numbers will you input at the beginning? : ");
        int start = reader.nextInt(); 

        int toInsertFirst[] = new int[start];

        System.out.print("How many numbers will you input at the end? : ");
        int finish = reader.nextInt(); 

        int toInsertLast[] = new int[finish];

        System.out.print("How many numbers will you pop from beginning? : ");
        int popFromFirst = reader.nextInt(); 

        System.out.print("How many numbers will you pop from end? : ");
        int popFromLast = reader.nextInt(); 

        for (int i = 0; i < start ; i++){
           System.out.print("Enter a number to insert at the beginning, " + (start - i) + " remaining : ");
           int newNumber = reader.nextInt(); 
           toInsertFirst[i] = newNumber;
        }
        for (int i = 0; i < finish ; i++){
           System.out.print("Enter a number to insert at then ending, " + (finish - i) + " remaining : ");
           int newNumber = reader.nextInt(); 
           toInsertLast[i] = newNumber;
        }


        System.out.println("Inserting toInsertFirst array at the beginning : ");
        for ( int i = 0; i < toInsertFirst.length; i++){
            theList.insertFirst(toInsertFirst[i]);
        }
        
        theList.displayForward();
        
        System.out.println("Inserting toInsertLast array at the end : ");
        for ( int i = 0; i < toInsertLast.length; i++){
            theList.insertLast(toInsertLast[i]);
        }
        
        theList.displayForward();
        
        System.out.println("Removing " + popFromFirst + " items from beginning : ");
        for ( int i = 0; i < popFromFirst; i++){
            theList.deleteFirst();
        }
        
        theList.displayForward();
        
        System.out.println("Removing " + popFromLast + " items from end : ");
        for ( int i = 0; i < popFromLast; i++){
            theList.deleteLast();
        }
        
        theList.displayForward();
    }
}