class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        for(String token : arr){
            if(token.matches("-?\\d+")){
                st.push(Integer.parseInt(token));
            }
            else{
                int val1 = st.pop();
                int val2 = st.pop();
                
                switch(token){
                    case "+" :
                        st.push(val2 + val1);
                        break;
                    case "-" :
                        st.push(val2 - val1);
                        break;
                    case "*" :
                        st.push(val2 * val1);
                        break;
                    case "/" :
                        st.push(val2 / val1);
                        break;
                }
            }
        }
        return st.pop();
    }
}