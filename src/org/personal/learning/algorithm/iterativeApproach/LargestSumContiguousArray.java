package org.personal.learning.algorithm.iterativeApproach;

import java.util.Arrays;
//TODO
//try to do it recursively
//then add method to do it using dynamic programming + mmemoization
public class LargestSumContiguousArray {
    static int [] inputArray = {-2,-3,4,-1,-2,1,5,-3};
//    {-2,1,-3,4,-1,2,1,-5,4}
    public static void main(String[] args) {
        System.out.println(largestSumContiguousArrIterative(inputArray));
    }

    private static int largestSumContiguousArrIterative(int [] inputArr){
        int maxSum = Integer.MIN_VALUE;
        int [] maxContiguousArrIndexes = new int[2];

        for(int i=0; i<inputArr.length;i++){
            int sum=0;
            int [] currentMaxArrIndexes = new int[2];
            for (int j = i; j<inputArr.length;j++){
                sum += inputArr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    currentMaxArrIndexes[0]=i;
                    currentMaxArrIndexes[1]=j;
                }
//                System.out.println("currentMaxArrIndexes : "+ currentMaxArrIndexes [0] +","+currentMaxArrIndexes[1]);
                System.out.println("SUM: "+ sum);
            }
            maxContiguousArrIndexes= Arrays.copyOf(currentMaxArrIndexes,2);

            System.out.println("MAX_SUM: "+ maxSum);
            System.out.println("maxContiguousArrIndexes : "+ maxContiguousArrIndexes [0] +","+maxContiguousArrIndexes[1]);
        }
        return maxSum;
    }
}
