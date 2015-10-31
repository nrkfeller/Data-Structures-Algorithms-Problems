/******************************
 * (a) Implement, using Java or C++, a queue with a time complexity of O(1) for access to the
maximum element. (b) Test your implementation and exhibit the test results. [30]

save if largest at input, keep pointer to it

*********************************/
// Used queue skeleton from Lafore
class Queue
{
    private int maxSize; // the queue class keeps track of the maximum possible size of the quere
    private long[] queArray; // make the array of max size
    private int front; // the first index in the line
    private int rear; // the last index to be inserted
    private int nItems; // the number of used indexes
    private long maximumElement; // the largest element
    //--------------------------------------------------------------
    public Queue(int s) // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    //--------------------------------------------------------------
    public void insert(long j) // put item at rear of queue
    {
        System.out.print("insert: " + j + " ");
        // if the list is empty, the first number will automatically be the largest value
        if ( isEmpty() ){
            maximumElement = j;
        } 
        
        // if the newly inserted value is larger than the previous largest value, replace it with the newly inserted value
        if ( maximumElement < j ){
            maximumElement = j;
        }
        
        // dealing with wrapping
        if(rear == maxSize-1){
            rear = -1;
        }
        queArray[++rear] = j; // increment rear and insert
        nItems++; // one more item
    }
    //-------------------------------------------------------------
    public long remove(){
        
        // output items that is to be removed
        System.out.print("remove: " + queArray[front] + " ");
        
        // place it in a temp register
        long temp = queArray[front];
        
        // if the item being removed is that largest element
        if (queArray[front] == maximumElement){
            System.out.println();
            System.out.println("Largest item removed, get new largest! ...");
            front++; // increament the front of the line
            maximumElement = 0; // reinitialize the maximum element to zero
            for (int i = nItems; i > 0; i--){ // rebuild the queue with the items remaining in it
                
                if (i != nItems){
                    remake(); // remake method!
                }
            }
        } else {
            front++; // if item being removed is not the largest item, just increment the front of the line
        }
        
        // deal with wraparound
        if(front == maxSize){
            front = 0;
        }
        
        nItems--; // one less item
        return temp; // return the removed value
    }
    //--------------------------------------------------------------
    // remake removes all the items on the list an reinserts them. this insures that we have a new maximum
    public void remake() // take item from front of queue
    {
        long temp = queArray[front]; // save front element in a temp register
        // deal with wraparound
        if(front == maxSize){
            front = 0;
        }
        nItems--; // unincrement number of elements
        front++; // increment front
        insert(temp); // reinsert the last value to the front of the line!
    }
    //--------------------------------------------------------------
    // give back the largest element
    public long max(){
        if ( !isEmpty()) {
            System.out.println("Current max: "+ maximumElement);
            return maximumElement;
        } else {
            System.out.println("No max! Queue is Empty");
            return 0;
        }
        
    }
    //--------------------------------------------------------------
    public long peekFront() // peek at front of queue
    {
        return queArray[front];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // true if queue is empty
    {
        return (nItems==0);
    }
    //--------------------------------------------------------------
    public boolean isFull() // true if queue is full
    {
        return (nItems==maxSize);
    }
    //--------------------------------------------------------------
    public int size() // number of items in queue
    {
        return nItems;
    }
//--------------------------------------------------------------
} // end class Queue
////////////////////////////////////////////////////////////////
class QueueApp
{
    public static void main(String[] args)
    {
        Queue theQueue = new Queue(10); // queue holds 5 items
        System.out.println("Original Queue: ");
        theQueue.insert(10); // insert 4 items
        theQueue.insert(25); // insert 4 items
        theQueue.insert(90);
        theQueue.insert(50);
        theQueue.insert(40);
        theQueue.insert(80);
        theQueue.insert(40);
        theQueue.insert(30);
        theQueue.insert(20);
        System.out.println();
        theQueue.max();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        System.out.println();
        theQueue.max();
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(100);
        System.out.println();
        theQueue.max();
        while( !theQueue.isEmpty() ) // remove and display
        { // all items
            long n = theQueue.remove();
        }
        System.out.println();
        theQueue.max();
        System.out.println("Insert a one element ");
        theQueue.insert(15);
        System.out.println();
        theQueue.max();
    } // end main()
} // end class QueueApp