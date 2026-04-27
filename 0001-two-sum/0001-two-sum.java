class Solution {
    public int[] twoSum(int[] arr, int target) {
        int [] ans=new int[2];
        ans[0]=ans[1]=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            int remain=target-num;
            if(map.containsKey(remain)){
                ans[0]=map.get(remain);
                ans[1]=i;
                return ans;
            }
            map.put(num,i);
        }
        return ans;
    }
}