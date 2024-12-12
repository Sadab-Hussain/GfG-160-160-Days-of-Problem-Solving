class Solution {
    
    static final int MAX_CHAR = 26;
    
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] freq = new int[MAX_CHAR];
        
        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<s2.length(); i++){
            freq[s2.charAt(i) - 'a']--;
        }
        
        for(int count: freq){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}