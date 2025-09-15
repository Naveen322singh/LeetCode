class Solution {
    public void moveZeroes(int[] arr) {
        int n=arr.length;
        int count=0;
        int [] temp=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                temp[j++]=arr[i];
            }
        }
        for(int i=0;i<temp.length;i++){
            arr[i]=temp[i];
        }
        for(int i=temp.length;i<n;i++){
            arr[i]=0;
        }

    }
}