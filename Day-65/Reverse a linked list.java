/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution {
    Node reverseList(Node head) {
        // code here
        if(head == null || head.next == null){
            return head;
        }
        Node rest = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return rest;
    }
    
    static void printList(Node node){
        while(node != null){
            System.out.println(" " +node.data);
            node = node.next;
        }
    }
}
