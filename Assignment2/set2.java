import java.util.Scanner;
class Link {
    public int iData;
    
    public Link next;
    public Link (int id){
        iData = id;
    }
    
    public void displayLink(){
        System.out.print(iData +",");
    }
}

class LinkList{
    // a list need one reference links the first
    private Link first;
    
    // initialize the frist and last links to null
    public void LinkList() {
        first = null;
    }
    
    // boolean to false if the first link is pointing to null
    public boolean isEmpty(){
        return (first == null);
    }
    
     // given a value, insert a link of that value at the beginning of the linked list
    public void insertFirst(int id){
        
        Link newLink = new Link(id);
        newLink.next = first;
        first = newLink;
    }
    
    // on singly linked list we need to itereate all the way through to delete the last link
    public void insertLast(int id){
        // create 'current' link to iterate through list
        Link current = first;
        Link newLink = new Link(id);
        // iterate until we arive at the last link
        while(current.next != null){
            current = current.next;
        }
        // make the pointer switches
        newLink.next = null;
        current.next = newLink;
        current = newLink; 
        
        
    }
    
    // counting sort
    public int[] counter(){
        // we only need 4 positions, because there are only 4 possible values
        int[] ZeroToThreeArray = {0,0,0,0};
        // create 'current' link to iterate through list
        Link current = first;
        
        // iterate through the list, and increment the arrays indeces when we fin 0,1,2,3
        while (current != null){
            
            switch(current.iData){
                
                case 0: ZeroToThreeArray[0] += 1;
                        break;
                case 1: ZeroToThreeArray[1] += 1;
                        break;
                case 2: ZeroToThreeArray[2] += 1;
                        break;
                case 3: ZeroToThreeArray[3] += 1;
                        break;
            }
            current = current.next;
        }
        return ZeroToThreeArray;
    }
    
    // given a key, search if it exists in the list
    public void find(int id) {
        // create 'current' link to iterate through the list
        Link current = first;
        // iterate until the key is found, if so print that it was found
        while(current != null){
            if (current.iData == id) {
                System.out.println("Found!");
                return;
            }
            current = current.next;
        }
        // if the key was not found, print not found
        System.out.println("Not Found!");
        
    }
    
    // delete the last link on the linked list
    public Link delete(int id){
        // create 'current' link to iterate through the list
        Link current = first;
        // create 'previous' link to keep track of last value, needed for replacement
        Link previous = first;
        
        // iterate through list until we find the given value
        while (current.iData != id) {
            if (current.next == null) {
                System.out.println("Link not found");
                return null;
                
            } else {
                previous = current;
                current = current.next;
            }
        }
        System.out.print("Deleting : ");
        current.displayLink();
        System.out.println();
        // if the list is the first, just place it
        if (current == first) {
            first = first.next;
        } else { // otherwise, assign the previous as well
            previous.next = current.next;
        }
        return current;
    }
    
    // delete the first link on the linked list
    public Link deleteFirst(){
        // switch around
        Link temp = first;
        first = first.next;
        return temp;
    }
    
    // display the list from the last link to the first link
    public void displayList(){
        // create 'current' link to iterate through the list
        Link current = first;
        // itereate forward and print each 'current'
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class SortZeroToThreeApp
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList();
        LinkList sortedList = new LinkList();
        
        Scanner reader = new Scanner(System.in);
       	System.out.print("How many numbers do you want in your linked list ? : ");
      	int lengthOfArray = reader.nextInt(); 

        for (int i = 0; i < lengthOfArray; i = i + 0){
           System.out.print("Enter a number from 0 to 3, " + (lengthOfArray - i) + " remaining : ");
           int newNumber = reader.nextInt(); 
           if (newNumber > 3 ){
           	System.out.println("Invalid input!");
           } else {
           	theList.insertFirst(newNumber);
           	i++;
           }
       	}
       	
       	// print the sorted list!
        int count[] = theList.counter();
        for ( int i = 3; i >= 0; i--){
            for (int j = 0; j < count[i]; j++){
                sortedList.insertFirst(i);
            }
        }
        System.out.println("Unsorted List : ");
        theList.displayList();
        System.out.println("Sorted List : ");
        sortedList.displayList();
        
        
    }
}