class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> lenOfArr = new ArrayList<>(Collections.nCopies(n, 0));
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                int top = st.pop();
                int windowSize = st.isEmpty() ? i : i - st.peek() - 1;
                lenOfArr.set(top, windowSize);
            } 
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int top = st.pop();
            int windowSize = st.isEmpty() ? n : n - st.peek() - 1;
            lenOfArr.set(top, windowSize);
        }
        
        for(int i=0; i<n; i++){
            int windowSize = lenOfArr.get(i) - 1;
            res.set(windowSize, Math.max(res.get(windowSize), arr[i]));
        }
        
        for(int i=n-2; i>=0; i--){
            res.set(i, Math.max(res.get(i), res.get(i + 1)));
        }
        return res;
    }
}