class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        
        Set<String> set = new HashSet<>();
        int maxLength = 0;
        for(String word :dictionary){
            set.add(word);
            maxLength = Math.max(word.length(), maxLength);
        }
        
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
         
        for(int i = 1; i <= n; i++) {
            for(int j = i-1; j >= Math.max(0,i-maxLength); j--) {
                    if(dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        return dp[n];
    }
}