package com.hlebon.leetcode.easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 */
public class ImplementStackUsingQueues {

    private final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        int lastValue = pop();
        queue.add(lastValue);
        return lastValue;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
