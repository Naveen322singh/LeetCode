class Solution {
    public int numSubarraysWithSum(int[] arr, int sum_k) {
        int n=arr.length;
        int count=0;
        for (int i=0;i<n;i++){
            int sum=0;
            for (int j=i;j<n;j++){
                sum=sum+arr[j];
                if (sum==sum_k){
                    count++;
                }
            }
        }
        return count;
        
    }
}