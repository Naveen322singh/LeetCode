class Solution {
    public int[] twoSum(int[] arr, int target) {
        int [] ans=new int[2];
        ans[0]=ans[1]=-1;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int current=arr[i];
            int needMore=target-current;
            if(mpp.containsKey(needMore)){
                ans[0]=mpp.get(needMore);
                ans[1]=i;
            }
            mpp.put(current,i);
        }
        return ans;
    }
}