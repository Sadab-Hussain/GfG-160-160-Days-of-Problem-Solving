class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        if(head == null){
            return null;
        }
        
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        Node clonedHead = head.next;
        Node clone = clonedHead;
        while(clone.next != null){
            curr.next = curr.next.next;
            clone.next = clone.next.next;
            
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;
        
        return clonedHead;
    }
    
    public static void printList(Node head){
        while(head != null){
            System.out.print(head.data + "(");
            if(head.random != null){
                System.out.print(head.random.data);
            }
            else {
               System.out.print("null"); 
            }
            System.out.println(")");
            
            if(head.next != null){
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}