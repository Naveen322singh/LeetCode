class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n=arr.length;
        int []ans=new int[2];
        HashMap<Integer,Integer> mpp=new HashMap<>();
        ans[0]=ans[1]=-1;
        for(int i=0;i<n;i++){
            int num=arr[i];
            int need=target-num;
            if(mpp.containsKey(need)){
                ans[0]=mpp.get(need);
                ans[1]=i;
            }
            mpp.put(arr[i],i);
        }
        return ans;
    }
}