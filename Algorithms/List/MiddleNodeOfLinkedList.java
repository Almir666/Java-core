package Algorithms.List;

import java.util.ArrayList;

// Дается линекд лист, верните средний узел связанного списка.
// Если есть два средних узла, верните второй узел.

// Example 1.
// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.

public class MiddleNodeOfLinkedList {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(middleNode(p1).toString());
    }

public static ListNode middleNode(ListNode head) {
    ArrayList<ListNode> arr = new ArrayList<>();
    int length = 0;
        while (head != null) {
            arr.add(head);
            head = head.next;
            length++;
        }
        return arr.get(length / 2);
    }
}

