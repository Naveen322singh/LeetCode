class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n=arr.length;
        int [] ans=new int[2];
        ans[0]=ans[1]=-1;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=arr[i];
            int needMore=target-num;
            if(mpp.containsKey(needMore)){
                ans[0]=mpp.get(needMore);
                ans[1]=i;
                return ans;
            }
            mpp.put(arr[i],i);
        }
        return ans;
        
    }
}