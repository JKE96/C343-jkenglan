Jarod England C343

#1.
Single-destination shortest-paths problem

Use Djikstra’s algorithm and instead of using the start vertex as the one that’s being searched for, use the end vertex.  This will find all the shortest paths.  Also, if it is a directed path, reverse all the directions of the edges and compute using the end vertex as the start vertex, then return the normalize all the directions of the edges.

// Compute shortest path distances from s, store them in Dstatic void Djikstra(Graph G, int s, int[] D) {  for (int i=0; i<G.n(); i++)    // Initialize    D[i] = Integer.MAX VALUE;  D[s] = 0;  for (int i=0; i<G.n(); i++) {  // Process the vertices    int v = minVertex(G, D);     // Find next-closest vertex    G.setMark(v, VISITED);    if (D[v] == Integer.MAX VALUE) return; // Unreachable    for (int w = G.first(v); w < G.n(); w = G.next(v, w))      if (D[w] > (D[v] + G.weight(v, w)))        D[w] = D[v] + G.weight(v, w);} }

static int minVertex(Graph G, int[] D) {  int v = 0;  // Initialize v to any unvisited vertex;  for (int i=0; i<G.n(); i++)    if (G.getMark(i) == UNVISITED) { v = i; break; }  for (int i=0; i<G.n(); i++)  // Now find smallest value    if ((G.getMark(i) == UNVISITED) && (D[i] < D[v]))      v = i;return v; }

#2.
3 , 2 , 4 , 1 , 6 , 5


#3.

This would not be a MST because it connects all the nodes with the smallest path possible.  The edges selected by Dijkstra’s algorithm would be a type of spanning tree because it does show the smallest paths from all the nodes to a certain node.

#4.

