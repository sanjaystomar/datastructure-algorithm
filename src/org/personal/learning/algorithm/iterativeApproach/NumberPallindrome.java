package org.personal.learning.algorithm.iterativeApproach;

//TODO
//update code for checking if number is pallindrom
//add method to do all the taks recursively
//try to do it in O(logn)
public class NumberPallindrome {
    public static void main(String[] args) {
        int i = 665667;
int reversei = 0;
//int initialMultiplier = Math.pow(10,0);
        int pow = 0;
        while (i >0){
int temp = i%10;
            reversei = (int) (reversei*(Math.pow(10,pow)))+temp;
            System.out.println(reversei);
//            System.out.print(i +" : ");
//            System.out.print(i%10+" : ");
            i=i/10;
//            System.out.print(i+" : ");
//            System.out.println();
            if(pow ==0)
            pow++;
        }
//        reverseNumber(121);

    }

    private static boolean isNumberPallindrome(int number){
        int result=0;
//        for(int i=0; i<)
        return true;
    }


    private static int reverseNumber(int number){
        for(int i=0, j=1; number/10>0;i++,j++){
            System.out.println(i + ":"+j);
            number=number/10;
        }
return 0;
    }
}
