package com.educative.data.structures.coding.interviews.graphs;

import java.util.Iterator;

class CheckBFS {

    //Breadth First Traversal of Graph g
    public static String bfs(Graph g) {
        String result = "";
        if(g == null || g.adjacencyList == null || g.adjacencyList.length == 0)
        {
            return result;
        }

        boolean[] visited = new boolean[g.vertices];
        for(int vertex = 0; vertex < g.vertices; vertex++)
        {
            if(!visited[vertex])
            {
                Queue<Integer> queue = new Queue<Integer>(g.vertices);
                queue.enqueue(Integer.valueOf(vertex));
                while(!queue.isEmpty())
                {
                    int currVertex = queue.dequeue().intValue();
                    result += currVertex;
                    visited[currVertex] = true;
                    DoublyLinkedList<Integer> adjList = g.adjacencyList[currVertex];
                    if(adjList != null && !adjList.isEmpty())
                    {
                        DoublyLinkedList<Integer>.Node temp = adjList.getHeadNode();
                        while(temp != null)
                        {
                            if(!visited[temp.data])
                            {
                                queue.enqueue(temp.data);
                            }
                            temp = temp.nextNode;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
//        Graph g = new Graph(5);
//        g.addEdge(0,1);
//        g.addEdge(0,2);
//        g.addEdge(1,3);
//        g.addEdge(1,4);
//        System.out.println("Graph1:");
//        g.printGraph();
//        System.out.println("BFS traversal of Graph1 : " + bfs(g));
//        System.out.println();

//        Graph g2 = new Graph(5);
//        g2.addEdge(0,1);
//        g2.addEdge(0,4);
//        g2.addEdge(1,2);
//        g2.addEdge(3,4);
//        System.out.println("Graph2:");
//        g2.printGraph();
//        System.out.println("BFS traversal of Graph2 : " + bfs(g2));

        Graph g3 = new Graph(4);
        g3.addEdge(0,2);
        g3.addEdge(1,3);
        System.out.println("Graph3:");
        g3.printGraph();
        System.out.println("BFS traversal of Graph3 : " + bfs(g3));

        Graph g4 = new Graph(5);
        g4.addEdge(0,1);
        g4.addEdge(0,3);
        g4.addEdge(2,4);
        System.out.println("Graph4:");
        g4.printGraph();
        System.out.println("BFS traversal of Graph4 : " + bfs(g4));
    }
}
