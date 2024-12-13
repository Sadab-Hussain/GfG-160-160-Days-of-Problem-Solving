class Solution {
    
    static final int MAX_CHAR = 26;
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        int[] freq = new int[MAX_CHAR];

        for (char c : s.toCharArray()) 
            freq[c - 'a']++;

        for (int i = 0; i < s.length(); ++i) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }
    
        return '$';
    }
}