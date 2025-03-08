class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>(n);
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            span.add(0);
        }
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                span.set(i, (i+1));
            }
            else{
                span.set(i, (i - st.peek()));
            }
            st.push(i);
        }
        return span;
    }
}