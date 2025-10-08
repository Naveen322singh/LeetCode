class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int needMore=target-arr[i];
            if(mpp.containsKey(needMore)){
                return new int[]{mpp.get(needMore),i};
            }
            mpp.put(arr[i],i);
        }
        return new int[]{};
    }
}