/*
Q1. Given a connected graph G1, with edges
{(A,B), (B,C), (C,F), (C,D), (D,E), (B,E)}
write & test a program that finds whether 
the graph has a cycle or not. Is there a 
way to return an answer without traversal?


Q2. Given a connected graph G2, with directed 
edges {(A,B), (B,C), (C,F), (C,D), (D,E), (E,B)}
where the (X,Y) represents a directed edge from
X to Y, write a program that outputs the shortest
list of nodes, starting from A that leads to any
node. For example, 

ABC is the shortest path to get to C (starting from A)

Q3. Design and write a program that returns 
true if there is a path (no matter how long
it may be) from a given node to another given 
node, within connected graph G3, which is described 
using the set of edges {(A,B),(B,D),(A,C),(C,D),
(D,A),(D,E)}. Be ware of cycles. 

Q4*. Write a program that accepts any graph
with up to 100 nodes (call them cities) and the
distances between them (lengths of 2-ways roads
between them) and returns the path with the shortest 
distance between any 2 cities (chosen by the user).

Example: {(AB:10), (BD:5), (DC:11), (CA:6), (AD:17)}
The path between A and D with the shortest distance 
is ABD:15. This is just one example; your program 
should be general. You may wish to pre-process some
of the information provided in order to minimize the 
time complexity of the shortest path computation. 

* This question counts for 2 normal questions.
*/
import java.util.Arrays;

// Create nodes (vertex)
class Vertex
{
    public char label;
    // label (e.g. ‘A’)
    public boolean wasVisited;
    // -------------------------------------------------------------
    public Vertex(char lab)
    // constructor
    {
        label = lab;
        wasVisited = false;
    }
    // -------------------------------------------------------------
} // end class Vertex
////////////////////////////////////////////////////////////////
class Graph
{
    private final int MAX_VERTS = 11;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][];
    // adjacency matrix
    private int nVerts;
    // current number of vertices
    // ------------------
    public Graph()
    // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++)
        // set adjacency
        for(int k=0; k<MAX_VERTS; k++)
        //matrix to 0
        adjMat[j][k] = 0;
    } // end constructor
    
    public void warshall(){
        
        int n = adjMat.length;
        for ( int k = 0; k < n; ++k){
            for (int i = 0; i < n; ++i){
                for (int j = 0; j < n; ++j){
                    if ((adjMat[i][k] * adjMat[k][j] != 0)){
                        if ((adjMat[i][k] + adjMat[k][j] < adjMat[i][j]) || (adjMat[i][j] ==0)){
                            adjMat[i][j] = adjMat[i][k] + adjMat[k][j];
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(adjMat));
    }
    
    public boolean possiblePath(int start, int end ){
        if (adjMat[start][end] != 0){
            System.out.println("Possible path exists");
            return true;
        } else {
            System.out.println("No possible path exists");
            return false;
        }
    }
    // -------------------------------------------------------------
    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }
    // -------------------------------------------------------------
    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    // -------------------------------------------------------------
    public void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }
    // -------------------------------------------------------------
} // end class Graph
////////////////////////////////////////////////////////////////
class BFSApp
{
    public static void main(String[] args)
    {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); //1
        theGraph.addVertex('B'); //2
        theGraph.addVertex('C'); //3
        theGraph.addVertex('D'); //4
        theGraph.addVertex('E'); //5
        theGraph.addVertex('G'); //6
        theGraph.addVertex('H'); //7
        theGraph.addVertex('I'); //8
        theGraph.addVertex('J'); //9
        theGraph.addVertex('k'); //10
        theGraph.addVertex('L'); //11
        
        
        // Subgraph A
        theGraph.addEdge(0,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(0,2);
        theGraph.addEdge(3,4);
        theGraph.addEdge(7,5);
        theGraph.addEdge(6,5);
        theGraph.addEdge(8,9);
        theGraph.addEdge(3,1);
        theGraph.addEdge(4,5);
        theGraph.addEdge(3,5);
        
        // Subgraph B
        theGraph.addEdge(8,9);
        theGraph.addEdge(9,10);
        theGraph.addEdge(10,8);
        
        // Build up the warshall matrix
        theGraph.warshall();
        
        // test Paths
        theGraph.possiblePath(0,7);
        theGraph.possiblePath(8,10);
        theGraph.possiblePath(4,9);
        System.out.println();
    
    }
} // end main()
// end class BFSApp
////////////////////////////////////////////////////////////////