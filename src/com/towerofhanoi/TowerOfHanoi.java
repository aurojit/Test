package com.towerofhanoi;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("TowerOfHanoi.main number of ring : " + n);
        towerOfHanoi(n,"FRIST","LAST","MIDDLE");
    }

    private static void towerOfHanoi(int n, String FRIST, String LAST, String MIDDLE) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + FRIST + " to rod " + LAST);
            return;
        }
        towerOfHanoi(n - 1, FRIST, MIDDLE, LAST);
        System.out.println("Move disk " + n + " from rod " + FRIST + " to rod " + LAST);
        towerOfHanoi(n - 1, MIDDLE, LAST, FRIST);
    }
}
