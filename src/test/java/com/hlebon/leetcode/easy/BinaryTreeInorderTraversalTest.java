package com.hlebon.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeInorderTraversalTest {

    private final BinaryTreeInorderTraversal tree = new BinaryTreeInorderTraversal();

    @Test
    void inorderTraversal() {
        // given
        BinaryTreeInorderTraversal.TreeNode third = new BinaryTreeInorderTraversal.TreeNode(3);
        BinaryTreeInorderTraversal.TreeNode second = new BinaryTreeInorderTraversal.TreeNode(2, third, null);
        BinaryTreeInorderTraversal.TreeNode root = new BinaryTreeInorderTraversal.TreeNode(1, null, second);

        // expected
        List<Integer> expected = List.of(1, 3, 2);

        // when
        List<Integer> result = tree.inorderTraversal(root);

        // then
        assertEquals(result, expected);
    }

    @Test
    void inorderTraversal_null() {
        // expected
        List<Integer> expected = List.of();

        // when
        List<Integer> result = tree.inorderTraversal(null);

        // then
        assertEquals(result, expected);
    }
}