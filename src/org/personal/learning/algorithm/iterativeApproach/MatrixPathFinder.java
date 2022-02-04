package org.personal.learning.algorithm.iterativeApproach;

import java.util.HashMap;
import java.util.Map;

/**
 * Count the number of paths
 * Count number of stpes in each path
 * Find the smallest path
 * Find the longest path
 * Solve iteratively
 * Solve recursively
 */
public class MatrixPathFinder {
    static int pathCount = -1;

    public static void main(String[] args) {
        int[][] routeMatrix = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};
        int numberOfRuns = 1;
        testHarness(routeMatrix, numberOfRuns);
    }

    private static void testHarness(int[][] routeMatrix, int numberOfRuns) {
        for (int i = 0; i < numberOfRuns; i++) {
            pathCount = -1;
            Long startTimeIterative = System.currentTimeMillis();
            System.out.println("Iterative Approach | Path Count: " + countPathsIterative(routeMatrix));
            Long timeTakenIterative = System.currentTimeMillis() - startTimeIterative;
            System.out.println("timeTakenIterative : " + timeTakenIterative);
            Long startTimeRecursive = System.currentTimeMillis();
            System.out.println("Recursive Approach | Path Count: " + countPathsRecursive(routeMatrix, 0, 0));
            Long timeTakenRecursive = System.currentTimeMillis() - startTimeRecursive;
            System.out.println("timeTakenRecursive : " + timeTakenRecursive);
            Long startTimeRecursiveMem = System.currentTimeMillis();
//            System.out.println("Recursive Mem Approach | Path Count: " + countPathsRecursiveWithMemoization(routeMatrix, 0, 0, pathMap));
            System.out.println("Recursive Mem Approach | Path Count: " + countPathsRecursiveWithMemoization(routeMatrix, 0, 0, new int[8][8]));
            Long timeTakenRecursiveMem = System.currentTimeMillis() - startTimeRecursiveMem;
            System.out.println("timeTakenRecursiveMem : " + timeTakenRecursiveMem);
        }
    }

    static Map<String, Integer> pathMap = new HashMap<>();

    public static int countPathsIterative(int[][] routeMatrix) {
        for (int i = 0; i < routeMatrix.length; i++) {
            for (int j = 0; j < routeMatrix.length; j++) {
//                To Print current element
//                System.out.println(routeMatrix[i][j]);
                if (routeMatrix[i][j] == 1)
                    break;
                else
                    pathCount = ++pathCount;
            }
        }
//        System.out.println(pathCount);
        return pathCount;
    }

    public static int countPathsRecursive(int[][] routeMatrix, int rowIndex, int columnIndex) {
//        System.out.println("rowIndex: " + rowIndex+ " | "+"columnIndex: " + columnIndex+ " | "+"routeMatrix value: " + routeMatrix[rowIndex][columnIndex]);
        if (routeMatrix.length - 1 == columnIndex || rowIndex == routeMatrix.length - 1)
//        if(7==columnIndex || rowIndex==7)
            return 1;
        if (routeMatrix[rowIndex][columnIndex] == 1 || rowIndex == routeMatrix.length - 1 || columnIndex == routeMatrix.length - 1)
            return 0;
        return countPathsRecursive(routeMatrix, rowIndex + 1, columnIndex) + countPathsRecursive(routeMatrix, rowIndex, columnIndex + 1);
    }

    //        public static int countPathsRecursiveWithMemoization(int [][] routeMatrix, int rowIndex, int columnIndex,Map<String, Integer> pathMap){
    public static int countPathsRecursiveWithMemoization(int[][] routeMatrix, int rowIndex, int columnIndex, int[][] pathArr) {
//        System.out.println("rowIndex: " + rowIndex+ " | "+"columnIndex: " + columnIndex+ " | "+"routeMatrix value: " + routeMatrix[rowIndex][columnIndex]);
        if (routeMatrix.length - 1 == columnIndex || rowIndex == routeMatrix.length - 1)
//        if(7==columnIndex || rowIndex==7)
            return 1;
        if (routeMatrix[rowIndex][columnIndex] == 1 || rowIndex == routeMatrix.length - 1 || columnIndex == routeMatrix.length - 1)
            return 0;
        /* USAGE OF MAP AS MEMOIZATION STORAGE
        if(!pathMap.containsKey(rowIndex+"_"+columnIndex))
        pathMap.put(rowIndex+"_"+columnIndex,countPathsRecursive(routeMatrix,rowIndex+1,columnIndex) + countPathsRecursive(routeMatrix,rowIndex,columnIndex+1));
        return pathMap.get(rowIndex+"_"+columnIndex);*/
        if (pathArr[rowIndex][columnIndex] == 0) {
            pathArr[rowIndex][columnIndex] = countPathsRecursive(routeMatrix, rowIndex + 1, columnIndex) + countPathsRecursive(routeMatrix, rowIndex, columnIndex + 1);
        }
        return pathArr[rowIndex][columnIndex];
    }

}
