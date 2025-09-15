class Solution {
    public int missingNumber(int[] arr) {
        int n=arr.length;
        int i=0;
        while(i<n){
            int correct_index=arr[i];
            if(arr[i]<n && arr[i]!=arr[correct_index]){
                swap(arr,i,correct_index);
            }
            else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(arr[j]!=j){
                return j;
            }
        }
        return n;
    }
    public static void swap(int[]arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
