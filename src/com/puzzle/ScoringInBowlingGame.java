package com.puzzle;

public class ScoringInBowlingGame {

    public static void main(String[] args) {
        int[] numbers = {5, 2, 3, 5, 5, 0, 4, 1, 9, 1, 5, 1, 7, 1, 10, 5, 2, 10, 10, 2};
        int score = bowlingGame(numbers, 0, 0, 0);
        System.out.println("Final Score = " + score);
    }

    private static int bowlingGame(int[] numbers, int i, int score, int totalFrame) {
        if (totalFrame == 10) return score;

        if (numbers[i] == 10) {
            score = score + 10 + numbers[i + 1] + numbers[i + 2];
            return bowlingGame(numbers, i + 1, score, totalFrame + 1);
        } else if (numbers[i] + numbers[i + 1] == 10) {
            score = score + 10 + numbers[i + 2];
            return bowlingGame(numbers, i + 2, score, totalFrame + 1);
        } else {
            score = score + numbers[i] + numbers[i + 1];
            return bowlingGame(numbers, i + 2, score, totalFrame + 1);
        }
    }
}
