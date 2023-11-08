package Day230920;

import org.w3c.dom.ls.LSException;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */


public class AddTwoNumbers {
    public static final int[] num1 = {9, 9, 9};
    public static final int[] num2 = {9, 9, 9, 9, 9, 9};

    public static void main(String[] args) {
        ListNode l1 = ListNode.makeListNode(num1);
        ListNode l2 = ListNode.makeListNode(num2);
        ListNode.printListNode(ListNode.addTwoNumbers(l1, l2));
    }
}

class ListNode {
    public int val;
    public ListNode next;

    private ListNode(int val) {
        this.val = val;
    }


    public static ListNode makeListNode(int[] nums) {
        if (nums == null || nums.length == 0) return new ListNode(0);
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode temp = l1;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            if (flag) {
                l1.val = l1.val + l2.val + 1;
            } else l1.val = l1.val + l2.val;
            if (l1.val > 9) {
                l1.val -= 10;
                flag = true;
            } else flag = false;
            temp = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null) {
            if (flag) temp.next = new ListNode(1);
            return head;
        } else {
            if (l1 == null) {
                l1 = l2;
                temp.next = l1;
            }
        }

        while (l1 != null && flag) {
            l1.val += 1;
            if (l1.val > 9) {
                l1.val -= 10;
                flag = true;
            } else  return head;
            temp =l1;
            l1 =l1.next;
        }
        if (flag) temp.next = new ListNode(1);
        return head;
    }

}
