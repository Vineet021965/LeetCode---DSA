/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1) Interleave cloned nodes with original nodes: A->A'->B->B'->...
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next; // move to next original node
        }

        // 2) Assign random pointers for clones
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // curr.next is the clone of curr; curr.random.next is the clone of curr.random
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // skip to next original
        }

        // 3) Detach the two lists: restore original and extract clone list
        Node dummy = new Node(0);
        Node cloneTail = dummy;
        curr = head;

        while (curr != null) {
            Node clone = curr.next;      // cloned node
            Node nextOrig = clone.next;  // next original node

            // append clone to cloned list
            cloneTail.next = clone;
            cloneTail = clone;

            // restore original list
            curr.next = nextOrig;

            // advance
            curr = nextOrig;
        }

        return dummy.next;
    }
}