/*
Q1. Implement a Heap Sort using an array and in-place sorting.
Test it and output the results.

Q2. Implement a min heap: insert the following elements into 
it in order: 4,9,2,89,12,69,32,1,56,12,-12,190,-5,77.

Q3. Given an array of size n, split it into two arrays of ~n/2,
sort each one using heap sort then merge the resulting arrays 
into one array using merge sort. Output the result of one test.

Do not use more memory space than is minimally necessary.

Q4. Use a heap to implement a stack. Hint: the order or time 
of entry (which are increasing quantities) could be used as 
the key of the inserted element. 
*/

import java.io.*;
////////////////////////////////////////////////////////////////
class Node
{
    private int iData;
    // data item (key)
    // -------------------------------------------------------------
    public Node(int key)
    // constructor
    { iData = key; }
    // -------------------------------------------------------------
    public int getKey()
    { return iData; }
    // -------------------------------------------------------------
    public void setKey(int id)
    { iData = id; }
// -------------------------------------------------------------
} // end class Node
////////////////////////////////////////////////////////////////
class Heap
{
    private Node[] heapArray;
    private int maxSize;
    // size of array
    private int currentSize;
    // number of nodes in array
    // -------------------------------------------------------------
    public Heap(int mx)
    // constructor
    {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize]; // create array
    }
    // -------------------------------------------------------------
    public boolean isEmpty()
    { return currentSize==0; }
    // -------------------------------------------------------------
    public boolean insert(int key)
    {
        if(currentSize==maxSize)
            return false;
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    } // end insert()
    // -------------------------------------------------------------
    public void trickleUp(int index)
    {
        int parent = (index-1) / 2;
        Node bottom = heapArray[index];
        while( index > 0 && heapArray[parent].getKey() > bottom.getKey() )
            {
            heapArray[index] = heapArray[parent]; // move it down
            index = parent;
            parent = (parent-1) / 2;
            } // end while
        heapArray[index] = bottom;
    } // end trickleUp()
    // -------------------------------------------------------------
    public Node remove()
    // delete item with max key
    {
        // (assumes non-empty list)
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    } // end remove()
    // -------------------------------------------------------------
    public void trickleDown(int index)
    {
        int largerChild;
        Node top = heapArray[index];
        // save root
        while(index < currentSize/2)
        // while node has at
        {
        // least one child,
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;
            // find larger child
            if(true)//rightChild < currentSize && heapArray[leftChild].getKey() > heapArray[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;
            // top >= largerChild?
            if( top.getKey() <= heapArray[largerChild].getKey() )
            break;
            // shift child up
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
            // go down
        } // end while
        heapArray[index] = top;
        // root to index
    } // end trickleDown()
    // -------------------------------------------------------------
    public boolean change(int index, int newValue)
    {
        if(index < 0 || index >= currentSize)
        return false;
        int oldValue = heapArray[index].getKey(); // remember old
        heapArray[index].setKey(newValue); // change to new
        if(oldValue < newValue)
        // if raised,
            trickleUp(index);
        // trickle it up
        else
        // if lowered,
            trickleDown(index);
        // trickle it down
        return true;
    } // end change()
    // -------------------------------------------------------------
    public void displayHeap()
    {
        System.out.print("heapArray: ");
        // array format
        for(int m=0; m<currentSize; m++)
            if(heapArray[m] != null)
                System.out.print( heapArray[m].getKey() + " ");
            else
                System.out.print( "-- ");
        System.out.println();
        // heap format
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        // current item
        String dots = "...............................";
        System.out.println(dots+dots);
        // dotted top line
        while(currentSize > 0)
        {
            if(column == 0){
                for(int k=0; k<nBlanks; k++)
                    System.out.print(" ");
            }
                
            // for each heap item
            // first item in row?
            // preceding blanks
            // display item
            System.out.print(heapArray[j].getKey());
            if(++j == currentSize)
                { break; }
            // done?
            if (++column==itemsPerRow) {
                nBlanks /= 2;
                // half the blanks
                itemsPerRow *= 2;
                // twice the items
                column = 0;
                // start over on
                System.out.println();
            }
            else 
            // next item on row
                for(int k=0; k<nBlanks*2-2; k++)
                    System.out.print(' ');
            // interim blanks
            }    // end for
        System.out.println("\n"+dots+dots); // dotted bottom line
    } // end displayHeap()
// -------------------------------------------------------------
} // end class Heap
////////////////////////////////////////////////////////////////
class HeapApp
{
    public static void main(String[] args) throws IOException
    {
    int value, value2;
    Heap theHeap = new Heap(31); // make a Heap; max size 31
    boolean success;
    // insert 10 items
    
    theHeap.insert(4);
    theHeap.insert(9);
    theHeap.insert(2);
    theHeap.insert(89);
    theHeap.insert(12);
    theHeap.insert(69);
    theHeap.insert(32);
    theHeap.insert(1);
    theHeap.insert(56);
    theHeap.insert(12);
    theHeap.insert(-12);
    theHeap.insert(190);
    theHeap.insert(-5);
    theHeap.insert(77);

    while(true)
    // until [Ctrl]-[C]
    {
        System.out.print("Enter first letter of ");
        System.out.print("show, insert, remove, change: ");
        int choice = getChar();
        switch(choice)
        {
            case 's':
                // show
                theHeap.displayHeap();
                break;
            case 'i':
                // insert
                System.out.print("Enter value to insert: ");
                value = getInt();
                success = theHeap.insert(value);
                if( !success )
                    System.out.println("Can’t insert; heap full");
                break;
            case 'r':
                // remove
                if( !theHeap.isEmpty() )
                    theHeap.remove();
                else
                    System.out.println("Can’t remove; heap empty");
                break;
            case 'c':
                // change
                System.out.print("Enter current index of item: ");
                value = getInt();
                System.out.print("Enter new key: ");
                value2 = getInt();
                success = theHeap.change(value, value2);
                if( !success )
                    System.out.println("Invalid index");
                break;
            default:
            System.out.println("Invalid entry\n");
        } // end switch
    } // end while
    } // end main()
    //-------------------------------------------------------------
    public static String getString() throws IOException
    {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s = br.readLine();
    return s;
    }
    //-------------------------------------------------------------
    public static char getChar() throws IOException
    {
    String s = getString();
    return s.charAt(0);
    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
    String s = getString();
    return Integer.parseInt(s);
    }
    //-------------------------------------------------------------
} // end class HeapApp
////////////////////////////////////////////////////////////////