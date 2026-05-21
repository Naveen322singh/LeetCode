class Solution {
    public int findMin(int[] arr) {
        int start=0;
        int end=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(start<=end){
            int mid=(start+end)/2;

            //normal condition
            if(arr[start]<=arr[end]){
                ans=Math.min(ans,arr[start]);
                break;
            }

            //left half is sorted
            if (arr[start]<=arr[mid]){
                ans=Math.min(ans,arr[start]);
                start=mid+1;
            }

            //right half is sorted
            else{
                ans=Math.min(ans,arr[mid]);
                end=mid-1;
            }
        }
        return ans;
    }
}