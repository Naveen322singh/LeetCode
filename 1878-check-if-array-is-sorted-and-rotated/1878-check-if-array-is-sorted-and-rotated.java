class Solution {
    public boolean check(int[] arr) {
        int count=0;
        if(arr[0]<arr[arr.length-1]){
            count++;
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]<arr[i]){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }
}