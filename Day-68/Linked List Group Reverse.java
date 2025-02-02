class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if(head == null || k == 1){
            return head;
        }
        
        Stack<Node> st = new Stack<>();
        Node curr = head;
        Node prev = null;
        
        while(curr != null){
            int count = 0;
            
            while(curr != null && count < k){
                st.push(curr);
                curr = curr.next;
                count++;
            }
            
            while(!st.isEmpty()){
                if(prev == null){
                    prev = st.pop();
                    head = prev;
                }
                else {
                    prev.next = st.pop();
                    prev = prev.next;
                }
            }
        }
        prev.next = null;
        return head;
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
