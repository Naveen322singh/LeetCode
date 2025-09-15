class Solution {
    public int majorityElement(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
        
        for(int i=0;i<n;i++){
            if(mpp.get(arr[i])>n/2){
                return arr[i];
            }
        }
        return -1;
    }
}