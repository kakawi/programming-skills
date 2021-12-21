package com.hlebon.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

    private final LongestCommonPrefix service = new LongestCommonPrefix();

    @Test
    void longestCommonPrefix() {
        // given
        String[] strs = {"flower", "flow", "flight"};

        // expected
        String expected = "fl";

        // when
        String result = service.longestCommonPrefix(strs);

        // then
        assertEquals(expected, result);
    }

    @Test
    void longestCommonPrefix_noPrefix() {
        // given
        String[] strs = {"dog", "racecar", "car"};

        // expected
        String expected = "";

        // when
        String result = service.longestCommonPrefix(strs);

        // then
        assertEquals(expected, result);
    }

    @Test
    void longestCommonPrefix_oneString() {
        // given
        String[] strs = {"a"};

        // expected
        String expected = "a";

        // when
        String result = service.longestCommonPrefix(strs);

        // then
        assertEquals(expected, result);
    }

    @Test
    void longestCommonPrefix_oneDifferentWord() {
        // given
        String[] strs = {"reflower","flow","flight"};

        // expected
        String expected = "";

        // when
        String result = service.longestCommonPrefix(strs);

        // then
        assertEquals(expected, result);
    }
}