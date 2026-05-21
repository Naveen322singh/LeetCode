class Solution {
    public int findPeakElement(int[] arr) {
        if(arr.length==1){
            return 0;
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return i;
            }
        }
        return arr.length-1;
    }
}