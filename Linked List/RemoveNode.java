/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        if (head.next == null && n == 1)
            return null;

        ListNode temp1 = head;
        ListNode temp2 = head;

        int count1 = 0;
        int count2 = 0;

        while (temp1 != null) {
            count1++;
            temp1 = temp1.next;
        }

        if (count1 - n == 0) {
            head = head.next;
        }

        while (temp2 != null) {
            count2++;

            if (count1 - n == 0) {
                temp2 = temp2.next;
                break;
            }

            if (temp2.next != null && count2 == count1 - n) {
                temp2.next = temp2.next.next;
                break;
            }

            temp2 = temp2.next;
        }

        return head;
    }
}