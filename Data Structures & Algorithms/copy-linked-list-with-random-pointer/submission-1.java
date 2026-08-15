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

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;

        // step 1: create all copied nodes;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // step 2: connect next and random pointers;
        curr = head;
        while (curr != null) {
            Node copyNode = map.get(curr);

            copyNode.next = map.get(curr.next);
            copyNode.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);





        // method-2
        // go through this interleaving soltion once

        // if (head == null) return null;

        // Node curr = head;

        // // 1. Insert copied node after every original node
        // while (curr != null) {
        //     Node copy = new Node(curr.val);

        //     copy.next = curr.next;
        //     curr.next = copy;

        //     curr = copy.next;
        // }

        // // 2. Set random pointers
        // curr = head;

        // while (curr != null) {
        //     if (curr.random != null) {
        //         curr.next.random = curr.random.next;
        //     }

        //     curr = curr.next.next;
        // }

        // // 3. Separate the two lists
        // curr = head;
        // Node copyHead = head.next;

        // while (curr != null) {
        //     Node copy = curr.next;

        //     curr.next = copy.next;

        //     if (copy.next != null) {
        //         copy.next = copy.next.next;
        //     }

        //     curr = curr.next;
        // }

        // return copyHead;

    }
}
