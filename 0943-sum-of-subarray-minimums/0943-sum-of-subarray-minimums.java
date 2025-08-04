class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse=nextSmallerElement(arr);
        int[] psee=previousSmallerOrEqualElement(arr);
        int total=0;
        int mod=(int)(1e9+7);
        int n=arr.length;
        for (int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(int)((total + ((long)left * right * arr[i]) % mod) % mod);
        }
        return total;
    }
    public static int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int []nse= new int[n];
        Stack< Integer > st = new Stack < > ();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nse[i] = n;
            }
            else {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }

    public static int[] previousSmallerOrEqualElement(int[] nums) {
        int n = nums.length;
        int []psee= new int[n];
        Stack< Integer > st = new Stack < > ();
        for (int i =0; i <n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                psee[i] = -1;
            }
            else {
                psee[i] = st.peek();
            }
            st.push(i);
        }
        return psee;
    }
}