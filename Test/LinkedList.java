
class Link {
    public int iData; // Integer data
    public double dData; // Double Data
    // There could be many other types in this Linked List so that it could accept any type of data
    
    public Link next; // The next Link. This is only a reference, not an object
    // This is a self referential class because one of the types is itself
    
    // Link aLink = someLink; is a reference
    // Link someLink = new Link(); is an object
    
    // Constructor
    public Link (int id, double dd){
        iData = id;
        dData = dd;
        // next is auomatically set to null
    }
    
    public void displayLink(){
        System.out.print("{" + iData +","+ dData+"}");
    }
}

class LinkList{
    
    private Link first; // reference to the first link in the list
    
    // Constructor
    public void LinkList() {
        first = null; // Empty List
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    // Insert to the first position
    public void insertFirst(int id, double dd){
        
        Link newLink = new Link(id,dd); // create new link
        newLink.next = first; // make the new links next(reference) point to the old first link
        first = newLink; // make the new link the new first link
    }
    
    public void insertLast(int id, double dd){
        Link current = first;
        Link newLink = new Link(id, dd);
        while(current.next != null){
            current = current.next;
        }
        newLink.next = null;
        current.next = newLink;
        current = newLink; 
        
        
    }
    
    public void find(int id, double dd) {
        Link current = first;
        while(current != null){
            if (current.iData == id && current.dData == dd) {
                System.out.println("Found!");
                return; // break if found
            }
            current = current.next;
        }
        System.out.println("Not Found!");
        
    }
    
    public Link delete(int id, double dd){
        Link current = first;
        Link previous = first;
        while (current.iData != id || current.dData != dd) {
            if (current.next == null) {
                return null;
                
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
    
    public Link deleteFirst(){
        Link temp = first; // save reference to link
        first = first.next; // make the second link the first link
        return temp; // this is for the java garbage collector. in C we would need to disallocate the memory
    }
    
    public void displayList(){
        System.out.print("List from first to last : ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class Test
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList(); // make new list
        theList.insertFirst(22,2.99);
        theList.insertFirst(44,4.99);
        theList.insertLast(222,10.99);
        theList.insertLast(444,12.99);
        theList.insertFirst(66,6.99);
        theList.insertFirst(88,8.99);
        
        theList.displayList();
        theList.delete(88,8.99);
        
        theList.displayList();
    
        // insert four items
        /*
        while( (!theList.isEmpty()) )
        // until it’s empty,
        {
            Link aLink = theList.deleteFirst();
            // delete link
            System.out.print("Deleted");
            // display it
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList();
        */
    }
}