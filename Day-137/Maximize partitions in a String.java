class Solution {
    public int maxPartitions(String s) {
        // code here
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        for(int i=0; i<s.length(); i++){
            if(first[s.charAt(i) - 'a'] == -1){
                first[s.charAt(i) - 'a'] = i;
            }
            last[s.charAt(i) - 'a'] = i;
        }
        
        int count = 0, end = 0;
        for(int i=0; i<s.length(); i++){
            end = Math.max(end, last[s.charAt(i) - 'a']);
            
            if(i == end){
                count++;
            }
        }
        return count;
    }
}