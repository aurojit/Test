package com.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition an Array into Two equal sum Arrays.
 * Example : [1,2,4,2,5,2,4] = 20
 * Output will be : [1,2,2,5] = 10; and [4,2,4] = 10;
 * Environment Requirement : Only Java-8 runtime environment is needed to play this game.
 *
 * @author Aurojit Basak
 * @version 1.0
 * @implNote This problem has been solved by Back-Tracking Algorithm (using Recursion).
 * @since 10.08.2020
 */
public class TwoEqualSumArrays {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(4);

        int sum = calculateSumOfList(arrayList);

        System.out.println("sum = " + sum);

        List<Integer> solutionArrayList = new ArrayList<>();
        twoEqualSumArraysSolution(arrayList, solutionArrayList, sum / 2);
        System.out.println("solutionArrayList = " + solutionArrayList);
    }

    private static int calculateSumOfList(List<Integer> arrayList) {
        return arrayList.stream().reduce(0, Integer::sum);
    }

    private static boolean twoEqualSumArraysSolution(List<Integer> arrayList, List<Integer> solutionArrayList, int halfSum) {
        if (halfSum == calculateSumOfList(solutionArrayList))
            return true;

        for (int i = 0; i < arrayList.size(); i++) {
            solutionArrayList.add(arrayList.get(i));
            int element = arrayList.get(i);
            arrayList.remove(i);
            System.out.println("element = " + element);
            System.out.println("arrayList = " + arrayList);
            System.out.println("solutionArrayList = " + solutionArrayList);
            if (twoEqualSumArraysSolution(arrayList, solutionArrayList, halfSum)) {
                return true;
            }
            solutionArrayList.remove(arrayList.get(i));
            arrayList.add(i, element);
        }
        return false;
    }
}
