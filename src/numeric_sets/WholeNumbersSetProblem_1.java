package numeric_sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WholeNumbersSetProblem_1 {
    /*Let's consider a set A ⊆ Z such that:
    * - Each number in "A" it's multiple of 3 or 5
    * - A have exactly 30 elements excluding the number 0
    * Questions:
    * 1 - What's the smaller positive number n in A?
    * 2 - What's the biggest negative number n in A?
    * 3 - What's the sum of all elements in A?
    * */

    public static void main(String[] args){
        Set<Integer> A = new HashSet<>(30);

        int element = -33;
        while(A.size() != 30){
            if(element % 3 == 0 || element % 5 == 0){
                if(element != 0){
                    A.add(element);
                }
            }
            element++;
        }

        //First question: What's the smaller positive number n in A?
        //Second question: What's the biggest negative number n in A?
        //Third question: What's the sum of all elements in A?
        int smallerPositiveNumber = Integer.MAX_VALUE;
        int biggestNegativeNumber = Integer.MIN_VALUE;
        int sum = 0;
        for(Integer num : A){
            if(num < smallerPositiveNumber && num > 0){
                smallerPositiveNumber = num;
            }

            if(num > biggestNegativeNumber && num < 0){
                biggestNegativeNumber = num;
            }

            sum += num;
        }

        System.out.println(A);
        System.out.println(A.size());
        System.out.println("Smaller Positive Element: " + smallerPositiveNumber);
        System.out.println("Biggest Negative Element: " + biggestNegativeNumber);
        System.out.println("Sum of all elements: " + sum);
    }



}
