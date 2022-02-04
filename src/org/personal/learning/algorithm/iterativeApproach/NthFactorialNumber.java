package org.personal.learning.algorithm.iterativeApproach;

public class NthFactorialNumber {
    public static void main(String[] args) {
        System.out.println("ntfFactorialIterative : "+ ntfFactorialIterative(4));
        System.out.println("nthFactorialRecursive : "+nthFactorialRecursive(5));
    }

    private static int ntfFactorialIterative(int n){
        int nthNumber = 1;
        for(int i =1; i<=n; i++){
            nthNumber = i*nthNumber;
        }
        return nthNumber;
    }

    private static int nthFactorialRecursive(int n) {
        if(n==1)
            return 1;
        else
            return n*nthFactorialRecursive(n-1);
    }
}
