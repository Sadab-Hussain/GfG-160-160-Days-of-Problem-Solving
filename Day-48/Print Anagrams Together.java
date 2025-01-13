class Solution {
    static final int MAX_CHAR = 26;
    
    static String getHash(String s){
        StringBuilder hash = new StringBuilder();
        int [] freq = new int[MAX_CHAR]; 
        
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++; 
        }
        
        for(int i=0; i<MAX_CHAR; i++){
            hash.append(freq[i]);
            hash.append('$');
        }
        return hash.toString();
    }
    
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            String key = getHash(arr[i]);
            
            if(!mp.containsKey(key)){
                mp.put(key, res.size());
                res.add(new ArrayList<>());
            }
            res.get(mp.get(key)).add(arr[i]);
        }
        return res;
    }
}
