Jarod England C343

1.a.

  | A  B  C  D  E  F              
--|-----------------               
A |       1     1
B |       1        1
C | 1  1     1     1         
D |       1        1         
E | 1              1
F |    1  1  1  1   


1.b.

Vertex  Adj List
A       [C,E]
B       [C,F]
C       [A,B,D,F]
D       [C,F]
E       [A,F]
F       [B,C,D,E]

1.c.
DFS starting at B
B:1
C:2
A:3
E:4
F:5
D:6

1.d.
BFS starting at B
B:1
C:2
F:2
D:3
A:3
E:3

2. The algorithm would work by checking all the nodes in the directed graph and finding which one can reach all the other nodes in the graph. The algorithm could work by checking if each node points to all the nodes in a graph. If it does not, keep all the nodes that it points to and go to the parent node. If that parent node points to other nodes then check all the nodes that other child points to and add it to the total nodes. Once the node being looked at doesn’t have any parent or children that has already been searched, check to see if all the total nodes are in the list of nodes that has been updated throughout the algorithm.

psuedocode:

public NodeList SearchChild(Node a, NodeList b){
for(child c: a){
b.add(c);
}
return b;
}

public void searchRoot(DirectedGraph dg, Node startNode, NodeList[] totalNode){
totalNode[] = SearchChild(startNode, totalNode);
if (totalNode contains all nodes){
return startNode;
}
else{
currentNode = startNode.getParent();
while(currentNode has parent){ //if a node has a parent
	currentNode = currentNode.getParent(); //updates the currentNode
	while(currentNode has children that hasn’t been checked){ //gets the children to the currentNode
		check the children and add to totalNode;
	}
}
while (currentNode has children that hasn’t been checked){
	check the children and add to totalNode; //gets the children to the currentNode and adds the current Node
}
if (totalNode has all nodes){
sysout(currentNode);
}
else if(any nodes that weren’t checked){
for all nodes not checked{
	searchRoot(dg, notCheckedNode, emptyNodeList);
}
else{
sysout(no node found);
}
}

3.

