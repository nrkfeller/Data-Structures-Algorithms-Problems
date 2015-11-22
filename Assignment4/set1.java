/*
Q1. Build a hash table with open addressing and a size of 99. Use the hash function "k%99". Insert the 
following keys, in order: 15, 229, 320, 0, 127 and 18 into your table.

Q2. Design and imeplement a perfect hashing based algorithm that accepts a Concordia student ID as input and generates a unique index as output. Look up: Perfect Hashing.

Q3. Do Q2, but this time, instead of having to generate a unique index as output, you may
allow collisions, but resolve these collisions using some form of Double Hashing.

Q4. Do Q2, but instead of ensuring uique indexes or using double hashing, use Separate 
Chaining with linked lists. 
*/

import java.io.*;

//////////////////////DATA ITEM/////////////////////////////////
class DataItem
{
    // (could have more data)
    private int iData;
    // data item (key)
    //--------------------------------------------------------------
    public DataItem(int ii)
    // constructor
    { iData = ii; }
    //--------------------------------------------------------------
    public int getKey()
    { return iData; }
    //--------------------------------------------------------------
} // end class DataItem
////////////////////////////////////////////////////////////////


///////////////////////HASH TABLE///////////////////////////////
class HashTable
{
    private DataItem[] hashArray;// array holds hash table
    private int arraySize;
    private DataItem nonItem;// for deleted items
    // -------------------------------------------------------------
    public HashTable(int size)
    // constructor
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    // deleted item key is -1
    }
    // -------------------------------------------------------------
    public void displayTable()
    {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++)
        {
            if(hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("- ");
        }
        System.out.println();
    }
    // -------------------------------------------------------------
    public int hashFunc(int key)
    {
        return key % arraySize;
    // hash function
    }
    // -------------------------------------------------------------
    public void insert(DataItem item) // insert a DataItem
    // (assumes table not full)
    {
        int key = item.getKey();
        // extract key
        int hashVal = hashFunc(key); // hash the key
        // until empty cell or -1,
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1)
        {
            ++hashVal;
            // go to next cell
            hashVal %= arraySize;
            // wraparound if necessary
        }
        hashArray[hashVal] = item;
        // insert item
    } // end insert()
    // -------------------------------------------------------------
    public DataItem delete(int key) // delete a DataItem
    {
        int hashVal = hashFunc(key); // hash the key
        while(hashArray[hashVal] != null) // until empty cell,
        {
            // found the key?
            if(hashArray[hashVal].getKey() == key)
            {
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem;
                // delete item
                return temp;
                // return item
            }
            ++hashVal;
            // go to next cell
            hashVal %= arraySize;
            // wraparound if necessary
        }
        return null;
        // can’t find item
    } // end delete()
    // -------------------------------------------------------------
    public DataItem find(int key)
    // find item with key
    {
        int hashVal = hashFunc(key); // hash the key
        while(hashArray[hashVal] != null) // until empty cell,
        {
            // found the key?
            if(hashArray[hashVal].getKey() == key)
            return hashArray[hashVal];
            // yes, return item
            ++hashVal;
            // go to next cell
            hashVal %= arraySize;
            // wraparound if necessary
        }
        return null;
        // can’t find item
    }
    // -------------------------------------------------------------
} // end class HashTable
////////////////////////////////////////////////////////////////


class HashTableApp
    {
    public static void main(String[] args) throws IOException
    {
        DataItem aDataItem;
        
        int aKey;
        
        HashTable theHashTable = new HashTable(99);
        while(true)
        {
            System.out.print("Enter number for execute ");
            System.out.print("[1]show, [2]insert, [3]delete, or [4]find: ");
            char choice = getChar();
            switch(choice)
            {
                case '1':
                    theHashTable.displayTable();
                    break;
                case '2':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case '3':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case '4':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null)
                    {
                        System.out.println("Found " + aKey);
                    }
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                System.out.print("Invalid entry\n");
            } // end switch
        } // end while
    } // end main()
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //--------------------------------------------------------------
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
    
}