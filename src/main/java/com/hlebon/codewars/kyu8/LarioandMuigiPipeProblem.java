package com.hlebon.codewars.kyu8;

public class LarioandMuigiPipeProblem {
    public static void main(String[] args) {
        int[] result = pipeFix(new int[]{-1, 4});
        System.out.println(result);
    }

    public static int[] pipeFix(int[] numbers) {
        int start = numbers[0];
        int end = numbers[numbers.length - 1];
        int resultArraySize = end - start + 1;
        int[] result = new int[resultArraySize];
        int currentValue = start;
        for (int i = 0; i < resultArraySize; i++) {
            result[i] = currentValue;
            currentValue++;
        }

        return result;
    }
}
