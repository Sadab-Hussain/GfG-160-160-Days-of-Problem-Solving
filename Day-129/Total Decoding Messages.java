class Solution {
    public int countWays(String digits) {
        // code here
        int n = digits.length();
        
        if(n == 0 || digits.charAt(0) == '0'){
            return 0;
        }
        
        int prev1 = 1, prev2 = 1;
        for(int i=1; i<n; i++){
            int curr = 0;
            
            if(digits.charAt(i) != '0'){
                curr += prev1;
            }
            
            int twoDigit = (digits.charAt(i - 1) - '0') * 10
                + (digits.charAt(i) - '0');
            if(twoDigit >= 10 && twoDigit <= 26){
                curr += prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}