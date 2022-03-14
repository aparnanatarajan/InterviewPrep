package com.educative.data.structures.coding.interviews.graphs;

public class CheckCycle
{
    public static boolean detectCycle(Graph g){
        if(g == null || g.adjacencyList == null || g.vertices == 0 || g.adjacencyList.length == 0)
        {
            return false;
        }

        for(int vertex = 0; vertex < g.vertices; vertex++)
        {
            boolean[] visited = new boolean[g.vertices];
            if(!visited[vertex])
            {
                Stack<Integer> stack = new Stack<>(g.vertices);
                stack.push(vertex);
                while(!stack.isEmpty())
                {
                    int currVertex = stack.pop().intValue();
                    visited[currVertex] = true;
                    DoublyLinkedList<Integer>.Node currNode = g.adjacencyList[currVertex].headNode;
                    while(currNode != null)
                    {
                        if(visited[currNode.data])
                        {
                            return true;
                        }
                        else
                        {
                            stack.push(currNode.data);
                        }
                        currNode = currNode.nextNode;
                    }
                }
            }
        }
        return false;
    }
}
