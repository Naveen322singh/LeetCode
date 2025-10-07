class Solution {
    public int missingNumber(int[] arr) {
        int i=0;
        int n=arr.length;
        while(i<n){
            int correct_index=arr[i];
            if(arr[i]<n && arr[i]!=arr[correct_index]){
                int temp=arr[i];
                arr[i]=arr[correct_index];
                arr[correct_index]=temp;
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
}