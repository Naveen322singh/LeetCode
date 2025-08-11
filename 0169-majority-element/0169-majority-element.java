class Solution {
    public int majorityElement(int[] arr) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<n;i++){
            if(mpp.get(arr[i])>arr.length/2){
                return arr[i];
            }
        }
        return -1;
    }
}