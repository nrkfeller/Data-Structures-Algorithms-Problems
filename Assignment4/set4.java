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