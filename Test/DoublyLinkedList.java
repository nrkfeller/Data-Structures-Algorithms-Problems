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
    private Link first;
    private Link last;
    
    public DoublyLinkedList(){
        first = null;
        last = null;
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    public void insertFirst(long dd){
        Link newLink = new Link(dd);
        
        if (isEmpty()){
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }
    
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
    
    public Link deleteFirst(){
        Link temp = first;
        if (first.next == null){
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }
    
    public Link deleteLast(){
        Link temp = last;
        if (first.next == null){
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }
    // insert dd after key, insert 77 after 22
    public boolean insertAfter(long key, long dd){
        Link current = first;
        while ( current.dData != key ){
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        Link newLink = new Link(dd);
        
        if ( current == last ){
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }
    
    public Link deleteKey(long key){
        Link current = first;
        while ( current.dData != key ){
            current = current.next;
            if(current == null)
                { return null; }
        }
        
        if (current == first){
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        
        if (current == last){
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }
    
    public void displayForward(){
        Link current = first;
        while ( current != null ){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
    
    public void displayBackward(){
        Link current = last;
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
        
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66); // insert at front
        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55); // insert at rear
        theList.displayForward();
        theList.displayBackward(); // display list forward
        // display list backward
        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11); // delete first item
        // delete last item
        // delete item with key 11
        theList.displayForward(); // display list forward
        theList.insertAfter(22, 77);
        theList.insertAfter(33, 88); // insert 77 after 22
        // insert 88 after 33
        theList.displayForward();
    }
}