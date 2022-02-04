package org.personal.learning.algorithm.iterativeApproach;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(n + "thFibonacciNumberIterative :" + nthFibonacciNumberIterative(n));
        System.out.println(n + "thFibonacciNumberRecursive :" + nthFibonacciNumberRecursive(n));
        nthFibonacciNumberRecursive1(n);
        System.out.println(n + "thFibonacciNumberRecursive1 :" + sequence);
    }
//  for conisdering sequence starts from 0 => 0 1 1 2 3 5 8 13 21 34
    private static int nthFibonacciNumberIterative(int n) {
        int n1 = 0, n2 = 1, n3 = 0;
        int currentNumber = 0;
        if (n == 0)
            return n1;
        else if (n == 1)
            return n2;
        else {
            for (int i = 2; i < n; i++) {
                currentNumber = n1 + n2;
                n1 = n2;
                n2 = currentNumber;
            }
            return currentNumber;
        }
    }
    //  for conisdering sequence starts from 1 => 1 1 2 3 5 8 13 21 34
    private static int nthFibonacciNumberRecursive(int n) {
        if (n <= 1)
            return n;
        else {
            return nthFibonacciNumberRecursive(n - 1) + nthFibonacciNumberRecursive(n - 2);
        }
    }
    static List<Integer> sequence = new ArrayList<>();
    private static void nthFibonacciNumberRecursive1(int n) {
        if (n == 0)
            sequence.add(0);
        else if (n == 1)
            sequence.add(1);
        else {
            sequence.add(nthFibonacciNumberRecursive(n - 2) + nthFibonacciNumberRecursive(n - 3));
        }
    }

    private static void printFibonacciSeqRecursively(int n){

    }
    private static void nthFibonacciNumberWithMemoization(int n){

    }
}
