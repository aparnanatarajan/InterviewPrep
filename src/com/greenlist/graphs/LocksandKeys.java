package com.greenlist.graphs;

import java.util.Set;
import java.util.HashSet;

/**
 * You are given an m x n grid where:
 *
 * '.' is an empty cell.
 * '#' is a wall.
 * '@' is the starting point.
 * Lowercase letters represent keys.
 * Uppercase letters represent locks.
 * You start at the starting point and one move consists of walking one space in one of the four cardinal directions.
 * You cannot walk outside the grid, or walk into a wall.
 *
 * If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.
 *
 * For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English
 * alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also
 * that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 *
 * Return the lowest number of moves to acquire all keys. If it is impossible, return -1.
 *
 * Example 1:
 * Input: grid = ["@.a.#","###.#","b.A.B"]
 * Output: 8
 * Explanation: Note that the goal is to obtain all the keys not to open all the locks.
 *
 * Example 2:
 * Input: grid = ["@..aA","..B#.","....b"]
 * Output: 6
 *
 * Example 3:
 * Input: grid = ["@Aa"]
 * Output: -1
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 30
 * grid[i][j] is either an English letter, '.', '#', or '@'.
 * The number of keys in the grid is in the range [1, 6].
 * Each key in the grid is unique.
 * Each key in the grid has a matching lock.
 *
 */
public class LocksandKeys
{
    public static void main(String args[])
    {
        String[] grid = {"@.a.#","###.#","b.A.B"};
        System.out.print(shortestPathAllKeys(grid));
    }

    public static int shortestPathAllKeys(String[] grid)
    {
        char[][] graph = getCharGrid(grid);
        int[] xPath = {1, 0, -1, 0};
        int[] yPath = {0, -1, 0, 1};
        boolean[][] visited = new boolean[grid.length][graph[0].length];
        Set<Character> keySet = new HashSet<>();
        Set<Character> lockSet = new HashSet<>();
        int currX = 0;
        int currY = 0;
        if(graph[currX][currY] != '@')
        {
            for(int i = 0; i < graph.length; i++)
            {
                for(int j = 0; j < graph[0].length; j++)
                {
                    if(graph[i][j] == '@')
                    {
                        currX = i;
                        currY = j;
                        break;
                    }
                }
            }
        }
        visited[currX][currY] = true;
        int minSteps = shortestPathAllKeys(graph, currX, currY, visited, keySet, lockSet, xPath, yPath,
                0, Integer.MAX_VALUE);
        return minSteps;
    }

    public static int shortestPathAllKeys(char[][] graph, int currX, int currY, boolean[][] visited,
                                   Set<Character> keySet, Set<Character> lockSet, int[] xPath, int[] yPath,
                                   int currCount, int minCount)
    {
        int minSteps = Integer.MAX_VALUE;
        for(int index = 0; index < xPath.length; index++)
        {
            int newX = currX + xPath[index];
            int newY = currY + yPath[index];
            if(isValidMove(newX, newY, graph, visited, keySet))
            {
                currCount += 1;
                visited[newX][newY] = true;
                if(Character.isLowerCase(graph[newX][newY]))
                {
                    keySet.add(graph[newX][newY]);
                }
                minSteps = shortestPathAllKeys(graph, newX, newY, visited, keySet, lockSet, xPath,
                        yPath, currCount, minCount);
                minCount = Math.min(minSteps, minCount);
                currCount -= 1;
            }
        }

        return minCount;
    }

    public static char[][] getCharGrid(String[] graph)
    {
        char[][] charGrid = new char[graph.length][graph[0].length()];
        for(int index = 0; index < graph.length; index++)
        {
            String gridString = graph[index];
            int pos = 0;
            while (pos < gridString.length())
            {
                charGrid[index][pos] = gridString.charAt(pos);
                pos++;
            }
        }
        return charGrid;
    }

    public static boolean isValidMove(int x, int y, char[][] graph, boolean[][] visited, Set<Character> keySet)
    {
        return (x >= 0 && y >= 0 && x < graph.length && y < graph[0].length && graph[x][y] != '#' && !visited[x][y]
                && hasMatchingKey(graph, x, y, keySet));
    }

    public static boolean hasMatchingKey(char[][] graph, int x, int y, Set<Character> keySet)
    {
        boolean hasMatchingKey = false;
        if(Character.isUpperCase(graph[x][y]))
        {
            Character lowerChar = Character.toLowerCase(graph[x][y]);
            if(keySet.contains(lowerChar))
            {
                hasMatchingKey = true;
            }
        }
        else
        {
            hasMatchingKey = true;
        }
        return hasMatchingKey;
    }
}
