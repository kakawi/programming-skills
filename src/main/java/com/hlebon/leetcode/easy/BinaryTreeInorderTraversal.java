package com.hlebon.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            fillFromNode(root, result);
        }
        return result;
    }

    private void fillFromNode(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            fillFromNode(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            fillFromNode(node.right, result);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}



