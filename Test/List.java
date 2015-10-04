/*
Q2. Design, implement and test a linked list that allows 
for the insertion of multiple objects with the same key at
the same location.

For example, if a list = [1.55.6.6.29.10]
then both items with key 6 should be placed at one and the same 
location in the list and both should be displayed if an inspection
is required. Deletion, however, deletes only one of them, while 
addition, adds still another object with the same key.
*/
class Link
{
    public int iData;
    // data item (key)
    public double dData;
    // data item
    public Link next;
    // next link in list
    // -------------------------------------------------------------
    public Link(int id, double dd) // constructor
    {
        iData = id;
        // initialize data
        dData = dd;
        // (‘next’ is automatically
    }
    // set to null)
    // -------------------------------------------------------------
    public void displayLink()
    // display ourself
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
} // end class Link
////////////////////////////////////////////////////////////////
class LinkList
    {
    private Link first;
    // ref to first link on list
    // -------------------------------------------------------------
    public LinkList()
    // constructor
    {
        first = null;
    // no items on list yet
    }
    // -------------------------------------------------------------
    public boolean isEmpty()
    // true if list is empty
    {
        return (first==null);
    }
    // -------------------------------------------------------------
    // insert at start of list
    public void insertFirst(int id, double dd)
    {
        // make new link
        Link newLink = new Link(id, dd);
        newLink.next = first;
        // newLink --> old first
        first = newLink;
        // first --> newLink
    }
    public void insertLast(int id, double dd)
    {
        Link current = first;
        Link newLink = new Link(id, dd);
        while(current.next != null){
            current = current.next;
        }
        newLink.next = null;
        current.next = newLink;
        current = newLink; 
        
    }
    public boolean Search(int id, double dd)
    {
        Link newLink = new Link(id, dd);
        Link current = first;
        while (current != null){
            if (current.next == newLink){
                return true;
            }
            current = current.next;
        }
        return false ;
    }
    // -------------------------------------------------------------
    public Link deleteFirst()
    // delete first item
    {
        // (assumes list not empty)
        Link temp = first;
        // save reference to link
        first = first.next;
        // delete it: first-->old next
        return temp;
        // return deleted link
    }
    // -------------------------------------------------------------
    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        // start at beginning of list
        while(current != null) // until end of list,
        {
            current.displayLink();
            // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }
// -------------------------------------------------------------
} // end class LinkList
////////////////////////////////////////////////////////////////
class LinkListApp
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList(); // make new list
        theList.insertFirst(22,2.99);
        theList.insertFirst(44,4.99);
        theList.insertLast(222,10.99);
        theList.insertLast(444,12.99);
        theList.insertLast(222,10.99);
        theList.insertLast(444,12.99);
        theList.insertLast(222,10.99);
        theList.insertLast(444,12.99);
        theList.insertLast(222,10.99);
        theList.insertLast(444,12.99);
        theList.insertFirst(66,6.99);
        theList.insertFirst(88,8.99);
        if (theList.Search(66,6.99)){
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
        theList.displayList();
    
    // insert four items
    // display list
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
    // display list
    }
} // end main()
// end class LinkListApp
////////////////////////////////////////////////////////////////