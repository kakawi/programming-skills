package com.hlebon.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 1268. Search Suggestions System
 */
public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        test("mouse", "mobile", "mouse", "moneypot", "monitor", "mousepad");
        test("havana", "havana");
        test("bags", "bags","baggage","banner","box","cloths");
        test("tatiana", "havana");
    }

    private static void test(String searchWord, String... products) {
        SearchSuggestionsSystem system = new SearchSuggestionsSystem();
        List<List<String>> allResults = system.suggestedProducts(products, searchWord);
        System.out.println("Result for " + searchWord);
        System.out.print("[");
        for (List<String> currentResult : allResults) {
            if (currentResult.isEmpty()) {
                System.out.print("[],");
                continue;
            }
            System.out.print("[\"");
            System.out.print(String.join("\",\"", currentResult));
            System.out.print("\"],");
        }
        System.out.print("]");
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for (String product : products) {
            root.add(product);
        }
        int searchLength = searchWord.length();
        List<List<String>> result = new LinkedList<>();

        for (int i = 0; i < searchLength; i++) {
            ResultQueue resultQueue = root.find(searchWord.substring(0, i + 1));
            result.add(resultQueue.result());
        }

        return result;
    }
}

class Node {

    private final Node[] next = new Node[26];
    private String value;

    public void add(String newWord) {
        char[] chars = newWord.toCharArray();
        Node currentRoot = this;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            int index = convertCharIntoIndex(c);
            final Node node = currentRoot.getOrCreate(index);

            if (i == chars.length - 1) {
                node.value = newWord;
            }

            currentRoot = node;
        }
    }

    private Node getOrCreate(int index) {
        if (next[index] == null) {
            next[index] = new Node();
        }

        return next[index];
    }

    public ResultQueue find(String searchWord) {
        char[] chars = searchWord.toCharArray();
        Node level = this;
        for (char c : chars) {
            int index = convertCharIntoIndex(c);
            Node nextNode = level.get(index);
            if (nextNode == null) {
                return new ResultQueue();
            }
            level = nextNode;
        }
        ResultQueue resultQueue = new ResultQueue();
        if (level != this) {
            level.fillResultQueue(resultQueue);
        }
        return resultQueue;
    }

    private Node get(int index) {
        return next[index];
    }

    public boolean exists() {
        return value != null;
    }

    private void fillResultQueue(ResultQueue queue) {
        if (queue.isReady()) return;
        if (this.exists()) {
            queue.add(this.value);
        }
        for (Node node : next) {
            if (queue.isReady()) break;
            if (node == null) continue;
            node.fillResultQueue(queue);
        }
    }

    private int convertCharIntoIndex(char c) {
        return c - 97;
    }
}

class ResultQueue {
    private final List<String> row = new LinkedList<>();
    private int size;

    public void add(String element) {
        row.add(element);
        size++;
    }

    public boolean isReady() {
        return size == 3;
    }

    public List<String> result() {
        return row;
    }
}
