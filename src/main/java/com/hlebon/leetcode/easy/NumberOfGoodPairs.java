package com.hlebon.leetcode.easy;

/**
 * GoodPair - the same number for example (1,1)
 * Solution: use the number of the same elements in the array
 */
public class NumberOfGoodPairs {

    public static void main(String[] args) {
        NumberOfGoodPairs main = new NumberOfGoodPairs();
        System.out.println(main.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }

    public int numIdenticalPairs(int[] nums) {
        int[] temp = new int[100];

        int result = 0;
        for (int num : nums) {
            result += temp[num - 1];
            temp[num - 1]++;
        }

        return result;
    }
}
