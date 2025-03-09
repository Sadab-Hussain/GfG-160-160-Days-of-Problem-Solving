class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int res = 0;
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                int top = st.pop();
                
                int width = st.isEmpty() ? i: i - st.peek() - 1;
                
                res = Math.max(res, arr[top] * width);
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int top = st.pop();
            int curr = arr[top] * (st.isEmpty() ? n: n - st.peek() - 1);
            res = Math.max(res, curr);
        }
        return res;
    }
}