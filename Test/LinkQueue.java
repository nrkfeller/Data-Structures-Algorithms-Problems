// linkQueue.java
// demonstrates queue implemented as double-ended list

class Link{
    public long dData;
    public Link next;
    
    public Link(long d){
        dData = d;
    }
    
    public void displayLink(){
        System.out.println(dData + " ");
    }
}

class FirstLastList{
    private Link first;
    private Link last;
    
    public FirstLastList(){
        first = null;
        last = null;
    }
    
    public boolean isEmpty(){
        return ( first == null);
    }
    
    public void insertLast(long dd){
        Link newLink = new Link(dd);
        if ( isEmpty() ){
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }
    
    public long deleteFirst(){
        long temp = first.dData;
        if ( first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }
    
    public void displayList()
    {
        Link current = first; // start at beginning
        while(current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }
}

class LinkQueue{
    private  FirstLastList theList;
    
    public LinkQueue(){
        theList = new FirstLastList();
    }
    
    public void insert(long j){
        theList.insertLast(j);
    }
    
    public long remove(){
        return theList.deleteFirst();
    }
    
    public boolean isEmpty(){
        return theList.isEmpty();
    }
    
    public void displayQueue()
    {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}

class LinkQueueApp
{
    public static void main(String[] args)
    {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20); // insert items
        theQueue.insert(40);
        theQueue.displayQueue(); // display queue
        theQueue.insert(60); // insert items
        theQueue.insert(80);
        theQueue.displayQueue(); // display queue
        theQueue.remove(); // remove items
        theQueue.remove();
        theQueue.displayQueue(); // display queue
    }
}