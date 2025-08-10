class Solution {
    public int numberOfSubarrays(int[] arr, int goal) {
        int [] final_array=convert_array_to_binary_array(arr);
        int ans=countExactSum(final_array,goal);
        return ans;
        
    }
    public int[] convert_array_to_binary_array(int [] arr){
        int n=arr.length;
        int [] binary_array =new int[n];
        for (int i=0;i<n;i++){
            if (arr[i]%2==1){
                binary_array[i]=1;
            }
            else{
                binary_array[i]=0;
            }
        }
        return binary_array;
    }
    public int countExactSum(int[] arr, int goal) {
        int n = arr.length;
        int count = 0;

        int left = 0;    // main window start
        int sum = 0;
        int prefixZeros = 0; // count of leading zeros in window

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // shrink from left if sum > goal
            while (left < right && sum > goal) {
                sum -= arr[left];
                left++;
                prefixZeros = 0; // reset zero count
            }

            // count trailing zeros at left when sum == goal
            while (left < right && arr[left] == 0 && sum == goal) {
                prefixZeros++;
                left++;
            }

            // if sum == goal, add count of subarrays ending here
            if (sum == goal) {
                count += 1 + prefixZeros;
            }
        }
        return count;
    }
}