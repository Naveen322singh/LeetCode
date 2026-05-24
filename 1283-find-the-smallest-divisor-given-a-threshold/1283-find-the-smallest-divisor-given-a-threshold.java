class Solution {
    public static int smallestDivisor(int[] arr,int threshold){
        int start=1;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxi=Math.max(maxi,arr[i]);
        }
        int end=maxi;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(sumCeil(arr,mid)<=threshold){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
    public static int sumCeil(int[] arr,int mid){
        int ansSum=0;
        for(int i=0;i<arr.length;i++){
            double ceil= Math.ceil((double)arr[i]/(double)mid);
            ansSum+=ceil;
        }
        return ansSum;
    }
}