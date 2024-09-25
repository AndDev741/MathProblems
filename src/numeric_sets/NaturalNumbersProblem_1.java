package numeric_sets;

import java.util.ArrayList;
import java.util.List;

public class NaturalNumbersProblem_1 {
    public static void main (String[] args){
        /*Problem: A subset X of natural numbers have 12 multiples of 4, 7 multiples of 6
        5 multiples of 12 and 8 odd numbers. What's the total of elements in X? */

        //I remove 5 of the multiples of four and six because the multiples of 12 are also
        //multiples of 4 and 6
        int multiplesOfFour = 7;
        int multiplesOfSix = 2;
        int multiplesOfTwelve = 5;
        int oddNumbers = 8;

        //Let's start with the multiples of 4
        int dividerOfFour = 0;
        List<Integer> checkedMultiplesOfFour = new ArrayList<Integer>(multiplesOfFour);
        while(checkedMultiplesOfFour.size() != multiplesOfFour){
            checkedMultiplesOfFour.add(dividerOfFour);
            dividerOfFour += 4;
        }

        //Now the multiples of 6
        int dividerOfSix = 0;
        List<Integer> checkedMultiplesOfSix = new ArrayList<Integer>(multiplesOfSix);
        while(checkedMultiplesOfSix.size() != multiplesOfSix){
            if(!checkedMultiplesOfFour.contains(dividerOfSix)){
                checkedMultiplesOfSix.add(dividerOfSix);
            }
            dividerOfSix += 6;
        }

        //Now the multiples of 12
        int dividerOfTwelve = 0;
        List<Integer> checkedMultiplesOfTwelve = new ArrayList<Integer>(multiplesOfTwelve);
        while(checkedMultiplesOfTwelve.size() != multiplesOfTwelve){
            if(!checkedMultiplesOfFour.contains(dividerOfTwelve) && !checkedMultiplesOfSix.contains(dividerOfTwelve)){
                checkedMultiplesOfTwelve.add(dividerOfTwelve);
            }
            dividerOfTwelve += 12;
        }

        //Now the odds numbers
        int oddNumber = 1;
        List<Integer> checkedOddNumbers = new ArrayList<Integer>(oddNumbers);
        while(checkedOddNumbers.size() != oddNumbers){
            checkedOddNumbers.add(oddNumber);
            oddNumber += 2;
        }

        ArrayList<Integer> allElementsOfX = new ArrayList<Integer>();
        allElementsOfX.addAll(checkedMultiplesOfFour);
        allElementsOfX.addAll(checkedMultiplesOfSix);
        allElementsOfX.addAll(checkedMultiplesOfTwelve);
        allElementsOfX.addAll(checkedOddNumbers);

        System.out.println("All the elements of X: " + allElementsOfX);
        System.out.println("The total of elements in X: " + allElementsOfX.size());
    }
}
