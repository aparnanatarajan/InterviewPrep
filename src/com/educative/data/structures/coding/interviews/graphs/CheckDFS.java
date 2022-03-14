package com.educative.data.structures.coding.interviews.graphs;

public class CheckDFS {
    //Depth First Traversal of Graph g
    public static String dfs(Graph g) {
        String result = "";
        if(g == null || g.adjacencyList == null || g.adjacencyList.length == 0 || g.vertices == 0)
        {
            return result;
        }

        boolean[] visited = new boolean[g.vertices];
        for(int vertex = 0; vertex < g.vertices; vertex++)
        {
            if(!visited[vertex])
            {
                Stack<Integer> stack = new Stack<>(g.vertices);
                stack.push(vertex);
                while(!stack.isEmpty())
                {
                    int currVertex = stack.pop();
                    result += currVertex;
                    visited[currVertex] = true;
                    DoublyLinkedList<Integer>.Node currNode = g.adjacencyList[currVertex].headNode;
                    while(currNode != null)
                    {
                        if(!visited[currNode.data])
                        {
                            stack.push(currNode.data);
                        }
                        currNode = currNode.nextNode;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));

        Graph g3 = new Graph(5);
        g3.addEdge(0,1);
        g3.addEdge(1,2);
        g3.addEdge(2,3);
        g3.addEdge(3,4);
        System.out.println("Graph3:");
        g3.printGraph();
        System.out.println("DFS traversal of Graph3 : " + dfs(g3));

        Graph g4 = new Graph(4);
        g4.addEdge(0,3);
        System.out.println("Graph4:");
        g4.printGraph();
        System.out.println("DFS traversal of Graph4 : " + dfs(g4));

        Graph g5 = new Graph(4);
        g5.addEdge(0,2);
        g5.addEdge(1,3);
        System.out.println("Graph5:");
        g5.printGraph();
        System.out.println("DFS traversal of Graph5 : " + dfs(g5));

        Graph g6 = new Graph(5);
        g6.addEdge(0,2);
        g6.addEdge(0,1);
        g6.addEdge(2,4);
        System.out.println("Graph6:");
        g6.printGraph();
        System.out.println("DFS traversal of Graph6 : " + dfs(g6));
    }
}
