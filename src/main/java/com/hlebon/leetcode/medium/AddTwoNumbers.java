package com.hlebon.leetcode.medium;

/**
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example #1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example #2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example #3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        printListNodes(addTwoNumbers.addTwoNumbers(generateNodes(342), generateNodes(465)));
        printListNodes(addTwoNumbers.addTwoNumbers(generateNodes(999), generateNodes(9)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int leftVal = l1.val;
        int rightVal = l2.val;
        int sumVal = leftVal + rightVal;

        int remainder = calculateRemainder(sumVal);
        if (nextValueExist(l1.next, l2.next, remainder)) {
            return new ListNode(calculateCurrentValue(sumVal), nextNode(l1.next, l2.next, remainder));
        } else {
            return new ListNode(calculateCurrentValue(sumVal));
        }
    }

    private int calculateRemainder(int value) {
        return value / 10;
    }

    private int calculateCurrentValue(int value) {
        return value % 10;
    }

    private ListNode nextNode(ListNode l1, ListNode l2, int remainder) {
        if (l1 == null && l2 == null) {
            return nextNodeFromRemainder(remainder);
        } else if (l1 == null) {
            return nextNodeFromOneListNode(l2, remainder);
        } else if (l2 == null) {
            return nextNodeFromOneListNode(l1, remainder);
        }
        return nextNodeFromTwoListNodes(l1, l2, remainder);
    }

    private ListNode nextNodeFromTwoListNodes(ListNode l1, ListNode l2, int oldRemainder) {
        int leftVal = l1.val;
        int rightVal = l2.val;
        int sumVal = leftVal + rightVal + oldRemainder;

        int remainder = calculateRemainder(sumVal);
        if (nextValueExist(l1.next, l2.next, remainder)) {
            return new ListNode(calculateCurrentValue(sumVal), nextNode(l1.next, l2.next, remainder));
        } else {
            return new ListNode(calculateCurrentValue(sumVal));
        }
    }

    private ListNode nextNodeFromOneListNode(ListNode node, int oldRemainder) {
        int value = node.val;
        int sumVal = value + oldRemainder;

        int remainder = calculateRemainder(sumVal);
        if (nextValueExist(null, node.next, remainder)) {
            return new ListNode(calculateCurrentValue(sumVal), nextNode(null, node.next, remainder));
        } else {
            return new ListNode(calculateCurrentValue(sumVal));
        }
    }

    private ListNode nextNodeFromRemainder(int remainder) {
        return new ListNode(remainder);
    }

    private boolean nextValueExist(ListNode l1, ListNode l2, int remainder) {
        return l1 != null || l2 != null || remainder != 0;
    }




    private static ListNode generateNodes(int value) {
        if (value < 10) {
            return new ListNode(value);
        }

        int currentValue = value % 10;
        return new ListNode(currentValue, generateNodes(value / 10));
    }

    private static void printListNodes(ListNode node) {
        System.out.println(node.val);
        if (node.next != null) {
            printListNodes(node.next);
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
