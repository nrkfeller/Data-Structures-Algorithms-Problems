
class Link {
    public int iData;
    public double dData;
    
    public Link next;
    public Link (int id, double dd){
        iData = id;
        dData = dd;
    }
    
    public void displayLink(){
        System.out.print("{" + iData +","+ dData+"}");
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
    
    public void insertFirst(int id, double dd){
        
        Link newLink = new Link(id,dd);
        newLink.next = first;
        first = newLink;
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
                return;
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
        LinkList theList = new LinkList();
        theList.insertFirst(22,2.99);
        theList.insertFirst(44,4.99);
        theList.insertLast(222,10.99);
        theList.insertLast(444,12.99);
        theList.insertFirst(66,6.99);
        theList.insertFirst(88,8.99);
        
        theList.displayList();
        theList.delete(44,4.99);
        
        theList.displayList();
    }
}