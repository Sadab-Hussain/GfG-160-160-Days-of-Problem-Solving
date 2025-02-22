class Solution {
    static int countPath(Node root, int k, int currSum, 
                        HashMap<Integer, Integer>prefixSums){
        if(root == null){
            return 0;
        }
        
        int pathCount = 0;
        currSum += root.data;
        
        if(currSum == k){
            pathCount++;
        }
        
        pathCount += prefixSums.getOrDefault(currSum - k, 0);
        prefixSums.put(currSum, prefixSums.getOrDefault(currSum , 0) + 1);
        
        pathCount += countPath(root.left, k, currSum , prefixSums);
        pathCount += countPath(root.right, k, currSum , prefixSums);
        
        prefixSums.put(currSum, prefixSums.get(currSum) - 1);
        
        return pathCount;
    }
    public int sumK(Node root, int k) {
        // code here
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        
        return countPath(root, k, 0, prefixSums);
    }
}