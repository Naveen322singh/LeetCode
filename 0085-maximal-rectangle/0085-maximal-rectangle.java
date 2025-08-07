class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length; //5
        int cols = matrix[0].length; //4
        int [][] psum=new int[rows][cols];
        int sum;

        for(int j = 0; j < cols; j++) {
            sum = 0;
            for(int i = 0; i < rows; i++) {
                if(matrix[i][j] == '1') {
                    sum += 1;
                } else {
                    sum = 0;
                }
                psum[i][j] = sum;
            }
        }
        int maxArea=0;
        for(int i=0;i<rows;i++){
            maxArea=Math.max(maxArea,largest_rect(psum[i]));
        }
        return maxArea;
    }
    public int largest_rect(int[] arr){
        int[] nse=nextSmallerElement(arr);
        int[] pse=previousSmallerElement(arr);
        int maximum=0;
        int n=arr.length;
        for (int i=0;i<n;i++){
            maximum=Math.max(maximum,arr[i]*(nse[i]-pse[i]-1));
        }
        return maximum;
    }
    public int[] nextSmallerElement(int[] nums) {
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
    public int[] previousSmallerElement(int[] nums) {
        int n = nums.length;
        int []pse= new int[n];
        Stack< Integer > st = new Stack < > ();
        for (int i =0; i <n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                pse[i] = -1;
            }
            else {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }
}