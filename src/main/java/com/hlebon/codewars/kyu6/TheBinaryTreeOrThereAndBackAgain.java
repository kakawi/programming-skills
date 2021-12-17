package com.hlebon.codewars.kyu6;

/**
 * The Binary Tree, or There and Back Again
 */
public class TheBinaryTreeOrThereAndBackAgain {

    public Node rotateRight(Node root) {
        Node newRoot = root.left;
        if (newRoot == null) {
            return root;
        }
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    public Node rotateLeft(Node root) {
        Node newRoot = root.right;
        if (newRoot == null) {
            return root;
        }
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }
}

class Node {
    Node left;
    Node right;
    int value;

}
