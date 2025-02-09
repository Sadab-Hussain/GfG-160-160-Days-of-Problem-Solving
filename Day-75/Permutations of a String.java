class Solution {
    static void genPermutation(int i, String s, boolean[] used,
        StringBuilder curr, HashSet<String> st){
            
        if(i == s.length()){
            st.add(curr.toString());
            return;
        }
        
        for(int j=0; j<s.length(); j++){
            if(!used[j]){
                used[j] = true;
                curr.append(s.charAt(j));
                
                genPermutation(i+1, s, used, curr, st);
                
                used[j] = false;
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
    
    public ArrayList<String> findPermutation(String s) {
        // Code here
        boolean[] used = new boolean[s.length()];
        HashSet<String> st = new HashSet<>();
        StringBuilder curr = new StringBuilder();
        
        genPermutation(0, s, used, curr, st);
        
        return new ArrayList<>(st);
    }
}