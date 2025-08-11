class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n=arr.length;
        int []ans=new int[2];
        ans[0]=ans[1]=-1;
        HashMap<Integer,Integer>mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=arr[i];
            int needmore=target-num;
            if(mpp.containsKey(needmore)){
                ans[0]=mpp.get(needmore);
                ans[1]=i;
                return ans;
            }
            mpp.put(arr[i],i);
        }
        return ans;
    }
}