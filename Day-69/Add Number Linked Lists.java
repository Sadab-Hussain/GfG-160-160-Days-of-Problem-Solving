class Solution {
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node trimLeadingZeros(Node head){
        while(head != null && head.data == 0){
            head = head.next;
        }
        return head;
    }
    
    static Node addListRec(Node num1, Node num2, int[] carry){
        if(num1 == null && num2 == null && carry[0] == 0){
            return null;
        }
        
        int sum = carry[0];
        
        if(num1 != null){
            sum += num1.data;
            num1 = num1.next;
        }
        
        if(num2 != null){
            sum += num2.data;
            num2 = num2.next;
        }
        
        carry[0] = sum / 10;
        Node res = new Node(sum % 10);
        res.next = addListRec(num1, num2, carry);
        
        return res;
    }
    
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
        
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        int[] carry = new int[1];
        Node res = addListRec(num1, num2 ,carry);
        
        if(carry[0] != 0){
            Node newNode = new Node(carry[0]);
            newNode.next = res;
            res = newNode;
        }
        return reverse(res);
    }
    
    static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}