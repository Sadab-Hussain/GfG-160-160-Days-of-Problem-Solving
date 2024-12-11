class Solution {
    public String addBinary(String s1, String s2) {
        // Trim leading zeros from the binary strings
        s1 = trimLeadingZeros(s1);
        s2 = trimLeadingZeros(s2);
        
        int n = s1.length();
        int m = s2.length();
        
        // Ensure s1 is the longer string
        if (n < m) {
            return addBinary(s2, s1);
        }
        
        int j = m - 1; // Pointer for the shorter string
        int carry = 0; // Initialize carry to 0
        StringBuilder result = new StringBuilder();
        
        // Loop through the longer string
        for (int i = n - 1; i >= 0; i--) {
            int bit1 = s1.charAt(i) - '0'; // Get the bit from the longer string
            int sum = bit1 + carry; // Add carry to the bit
            
            // If there's a corresponding bit in the shorter string
            if (j >= 0) {
                int bit2 = s2.charAt(j) - '0'; // Get the bit from the shorter string
                sum += bit2;
                j--; // Move the pointer in the shorter string
            }
            
            int bit = sum % 2; // Calculate the current bit
            carry = sum / 2;   // Calculate the carry
            result.append((char)(bit + '0')); // Append the bit to the result
        }
        
        // If there's any remaining carry, append it
        if (carry > 0) {
            result.append('1');
        }
        
        // Reverse the result and return it
        return result.reverse().toString();
    }
    
    // Helper method to trim leading zeros
    private String trimLeadingZeros(String s) {
        int firstOne = s.indexOf('1');
        return (firstOne == -1) ? "0" : s.substring(firstOne);
    }
}
