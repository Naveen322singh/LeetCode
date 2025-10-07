class Solution {
    public void moveZeroes(int[] arr) {
        int count_zeroes=0;
        int n=arr.length;
         int index=0;
        int [] temp=new int[n];
        for (int i=0;i<n;i++){
            if (arr[i]!=0){
                temp[index++]=arr[i];
            }
        }
        for (int i=0;i<temp.length;i++){
            arr[i]=temp[i];
        }
        for (int i=temp.length;i<n;i++){
            arr[i]=0;
        }
    }
}