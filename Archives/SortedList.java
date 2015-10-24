class Link {
    
    public long dData;
    public Link next;
    
    public Link (long dd){
        dData = dd;
    }
    
    public void displayLink(){
        System.out.print(dData+ " ");
    }
}

class SortedList{
    private Link first;
    
    public SortedList() {
        first = null;
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    public void insert(long key){
        Link newLink = new Link(key);
        Link current = first;
        Link previous = null; 
        while ( current != null && key > current.dData ){
            previous = current;
            current = current.next; 
        }
        if(previous==null){
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current; 
    }
    
    public Link remove(){
        Link temp = first; // save first
        first = first.next; // delete first
        return temp; 
    }
    public void displayList(){
        Link current = first;
        while ( current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

class SortedListApp
{
    public static void main(String[] args)
    { // create new list
        SortedList theSortedList = new SortedList();
        theSortedList.insert(20); // insert 2 items
        theSortedList.insert(40);
        theSortedList.displayList(); // display list
        theSortedList.insert(10); // insert 3 more items
        theSortedList.insert(30);
        theSortedList.insert(50);
        theSortedList.displayList(); // display list
        theSortedList.remove(); // remove an item
        theSortedList.displayList(); // display list
    } // end main()
}