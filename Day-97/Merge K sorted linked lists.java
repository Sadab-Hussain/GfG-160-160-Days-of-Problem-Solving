class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        
        for(Node head : arr){
            if(head != null){
                pq.add(head);
            }
        }
        
        Node dummy = new Node(-1);
        Node tail = dummy;
        
        while(!pq.isEmpty()){
            Node top = pq.poll();
            
            tail.next = top;
            tail = top;
            
            if(top.next != null){
                pq.add(top.next);
            }
        }
        return dummy.next;
    }
   
    static void printList(Node node){
        while(node != null){
            System.out.print(node.data +" ");
            node.next = node;
        }
    }
}