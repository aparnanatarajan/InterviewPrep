package com.greenlist.graphs;

import java.util.Arrays;

public class KnightsTour
{
    public static void main(String[] args)
    {
        solveKnightsTour(8);
    }

    public static void solveKnightsTour(int n)
    {
        int[][] solution = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(solution[i], -1);
        }

//        int[] xmove = {2,1,-1,-2,-2,-1,1,2};
//        int[] ymove = {-1,-2,-2,-1,1,2,2,1};

        int xmove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int ymove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        solution[0][0] = 0;
        if(!canSolveKnightsTour(n, 1, 0, 0, solution, xmove, ymove))
        {
            System.out.println("Solution to Knight's Tour does not exist. ");
        }
        else
        {
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean canSolveKnightsTour(int n, int moveNum, int x, int y, int[][] solution, int[] xmove, int[] ymove)
    {
        if( moveNum == n*n)
        {
            return true;
        }

        for(int index = 0; index < xmove.length; index++)
        {
            int nextX = x + xmove[index];
            int nextY = y + ymove[index];

            if(isSafeToMove(n, nextX, nextY, solution))
            {
                solution[nextX][nextY] = moveNum;
                if(canSolveKnightsTour(n, moveNum+1, nextX, nextY, solution, xmove, ymove))
                {
                    return true;
                }
                else
                {
                    solution[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    public static boolean isSafeToMove(int n, int x, int y, int[][] solution)
    {
        return (x >= 0 && y >= 0 && x < n && y < n && solution[x][y] != -1);
    }
}
