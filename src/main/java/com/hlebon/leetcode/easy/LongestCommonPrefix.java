package com.hlebon.leetcode.easy;

/**
 * Bad solution. Too much information is saved.
 * Use only one child in the Node
 */
public class LongestCommonPrefix {

    private final Node root = new Node();
    private Node biggest = root;

    public String longestCommonPrefix(String[] strs) {
        int countOfWords = strs.length;
        for (int i = 0; i < countOfWords - 1; i++) {
            root.addWord(strs[i]);
        }
        root.addLastWord(strs[countOfWords - 1], countOfWords);
        return biggest.getPrefix(countOfWords == 1);
    }

    class Node {
        private final Node parent;
        private final Character value;

        private final Node[] next = new Node[26];

        private int weight;

        public Node() {
            parent = null;
            value = null;
        }

        public Node(Node parent, char value) {
            this.parent = parent;
            this.value = value;
        }

        public void addWord(String str) {
            char[] chars = str.toCharArray();
            Node currentNode = this;
            for (char c : chars) {
                currentNode = currentNode.put(c);
            }
        }

        public void addLastWord(String str, int countOfWords) {
            char[] chars = str.toCharArray();
            Node currentNode = this;
            for (char c : chars) {
                currentNode = currentNode.put(c);
                if (biggest.getWeight() <= currentNode.getWeight() && currentNode.getWeight() == countOfWords) {
                    biggest = currentNode;
                }
            }
        }

        private Node put(char c) {
            int index = convertCharToIndex(c);
            final Node result;
            if (next[index] == null) {
                result = new Node(this, c);
                next[index] = result;
            } else {
                result = next[index];
            }
            result.increaseWeight();

            return result;
        }

        private int convertCharToIndex(char c) {
            return c - 'a';
        }

        private void increaseWeight() {
            weight++;
        }

        private int getWeight() {
            return weight;
        }

        private boolean isRoot() {
            return parent == null;
        }

        public String getPrefix(boolean oneWord) {
            Node currentChild = this;
            if (!oneWord && this.getWeight() == 1) {
                currentChild = root;
            }

            StringBuilder result = new StringBuilder();
            while (!currentChild.isRoot()) {
                result.insert(0, currentChild.value);
                currentChild = currentChild.parent;
            }

            return result.toString();
        }
    }
}


