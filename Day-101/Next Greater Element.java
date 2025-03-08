class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            res.add(-1);
        }
        
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                res.set(i, st.peek());
            }
            
            st.push(arr[i]);
        } 
        return res;
    }
}