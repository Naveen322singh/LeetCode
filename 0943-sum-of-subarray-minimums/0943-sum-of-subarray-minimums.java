class Solution {
    public int sumSubarrayMins(int[] arr) {
        int [] nse=nextSmaller(arr);
        int [] pse=previousSmaller(arr);

        int total=0;
        int mod=(int)(1e9+7);
        
        for(int i=0;i<arr.length;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            total=(int)((total + ((long)left * right * arr[i]) % mod) % mod);
        }
        return total;
        
    }
    public int[] nextSmaller(int []arr){
        int n=arr.length;
        int []nse=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        return nse;
    }

    public int[] previousSmaller(int []arr){
        int n=arr.length;
        int []pse=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        return pse;
    }
}