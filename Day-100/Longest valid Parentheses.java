class Solution {
    static int maxLength(String s) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        st.push(-1);
        int maxLen = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else {
                st.pop();
                
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }
        return maxLen;
    }
}