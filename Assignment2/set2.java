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
    
    private Link first;
    public void LinkList() {
        first = null;
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    public void insertFirst(int id){
        
        Link newLink = new Link(id);
        newLink.next = first;
        first = newLink;
    }
    
    public void insertLast(int id){
        Link current = first;
        Link newLink = new Link(id);
        while(current.next != null){
            current = current.next;
        }
        newLink.next = null;
        current.next = newLink;
        current = newLink; 
        
        
    }
    
    public int[] counter(){
        int[] ZeroToThreeArray = {0,0,0,0};
        Link current = first;
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
    
    public void find(int id) {
        Link current = first;
        while(current != null){
            if (current.iData == id) {
                System.out.println("Found!");
                return;
            }
            current = current.next;
        }
        System.out.println("Not Found!");
        
    }
    
    public Link delete(int id){
        Link current = first;
        Link previous = first;
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
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
    
    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }
    
    public void displayList(){
        Link current = first;
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
        // MODIFY THIS ARRAY TO YOUR LIKING AND CHECK THE OUTPUT

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