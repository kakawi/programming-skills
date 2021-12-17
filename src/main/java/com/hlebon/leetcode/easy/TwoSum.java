package com.hlebon.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Description: there is exactly one pair of numbers sum of which gives the target
 * Solution: iterate by array and put numbers into HashMap (checking maybe you've already found the answer)
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        printArray(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
        printArray(twoSum.twoSum(new int[]{3, 2, 4}, 6));
        printArray(twoSum.twoSum(new int[]{3, 3}, 6));
    }

    private static void printArray(int[] array) {
        System.out.println(IntStream.of(array).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapOfIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (mapOfIndexes.get(currentValue) != null) {
                if (target == currentValue * 2) {
                    return new int[]{mapOfIndexes.get(nums[i]), i};
                }
            }
            int desirableValue = target - currentValue;
            if (mapOfIndexes.get(desirableValue) != null) {
                return new int[]{mapOfIndexes.get(desirableValue), i};
            }
            mapOfIndexes.put(nums[i], i);
        }
        return null;
    }
}
