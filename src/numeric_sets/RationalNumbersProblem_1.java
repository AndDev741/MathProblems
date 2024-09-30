package numeric_sets;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RationalNumbersProblem_1 {
    /*We're going to write a algorithm that receive a list of fractions as pairs of integers
    *(numerator and denominator) and return a new List where all the fractions are simplified
    * */
    public static void main(String[] args){
        ArrayList<List<Integer>> fractionsToSimplify = new ArrayList<>(
                List.of(List.of(4, 8), List.of(-12, 16), List.of(15, -42), List.of(9, 3))
        );

        System.out.println(simplifyFraction(fractionsToSimplify));
    }

    private static ArrayList<List<Integer>> simplifyFraction(ArrayList<List<Integer>> fractions){
        ArrayList<List<Integer>> simplifiedFraction = new ArrayList<>();
        for(List<Integer> fraction : fractions){
            int numerator = fraction.get(0);
            int denominator = fraction.get(1);
            int gcd = greatestCommonDivisor(numerator, denominator);
            if(denominator != 0){
                numerator /= gcd;
                denominator /= gcd;
                simplifiedFraction.add(List.of(numerator, denominator));
            }else{
                throw new ArithmeticException("The denominator can't be 0");
            }
        }
        return simplifiedFraction;
    }

    //This algorithm is much better than the old. It has a big O of O(log(min(a, b)))
    private static Integer greatestCommonDivisor(int numerator, int denomitor){
        while (denomitor != 0){
            int temp = denomitor;
            denomitor = numerator % denomitor;
            numerator = temp;
        }
        return Math.abs(numerator);
    }

    //Old gdc algorithm
//    private static Integer greatestCommonDivisor(List<Integer> fraction){
//        int divisor = 2;
//        int gcd = 1;
//        int numerator = fraction.get(0);
//        int denominator = fraction.get(1);
//        while(numerator != 1 && denominator != 1){
//            if(numerator % divisor == 0 && denominator % divisor ==0){
//                gcd *= divisor;
//                numerator = numerator / divisor;
//                denominator = denominator / divisor;
//            }else if(numerator % divisor != 0 && denominator % divisor !=0){
//                divisor++;
//            }
//            else{
//                if(numerator % divisor == 0){
//                    numerator = numerator / divisor;
//                }
//                if(denominator % divisor ==0){
//                    denominator = denominator / divisor;
//                }
//            }
//
//        }
//        return gcd;
//    }
}
