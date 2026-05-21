class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ans=new int[2];
        ans[0]=first_occurrence(nums,target);
        ans[1]=last_occurrence(nums,target);
        return ans;
        
    }
    public int first_occurrence(int [] arr,int x){
        int first=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if (arr[mid]==x){
                first=mid;
                high=mid-1;
            }
            else if(arr[mid]<x){
                low=mid+1;
            }
            else if (arr[mid]>x){
                high=mid-1;
            }
        }
        return first;
    }
    public int last_occurrence(int [] arr,int x){
        int last=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if (arr[mid]==x){
                last=mid;
                low=mid+1;
            }
            else if(arr[mid]<x){
                low=mid+1;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
        }
        return last;
    }
}