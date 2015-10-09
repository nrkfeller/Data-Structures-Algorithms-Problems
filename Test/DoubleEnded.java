class Link{
    public long lData;
    public Link next;
    
    // constructor
    public Link(long l){
        lData = l;
    }
    
    // display
    public void displayLink(){
        System.out.print(lData + " ");
    }
}

class FirstLastList {
    private Link first;
    private Link last;
    
    // constructor
    public FirstLastList(){
        first = null;
        first = null;
    }
    
    public boolean isEmpty()
    { return first == null; }
    
    public void insertFirst(long dd){
        Link newLink = new Link(dd);
        
        if ( isEmpty() ){
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }
    
    public void insertLast(long dd){
        Link newLink = new Link(dd);
        
        if ( isEmpty() ){
            last = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }
    
    public long deleteFirst(){
        long temp = first.lData;
        // if there is only one element in the list
        if (first.next == null ){
            last = null;
        }
        first = first.next;
        return temp;
    }
    
    public void displayList(){
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

class FirstLastApp
{
    public static void main(String[] args)
    { // make a new list
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayList(); // display the list
        theList.deleteFirst(); // delete first two items
        theList.deleteFirst();
        theList.displayList(); // display again
    } // end main()
} // end class FirstLastApp