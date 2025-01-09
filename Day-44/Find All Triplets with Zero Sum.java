class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        ArrayList<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(i);
                        triplet.add(j);
                        triplet.add(k);
                        res.add(triplet);
                    }
                }
            }
        }
        return res;
    }
}
