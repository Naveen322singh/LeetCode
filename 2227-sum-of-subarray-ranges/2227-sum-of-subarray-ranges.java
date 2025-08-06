import java.util.*;
class Solution {
    public long subArrayRanges(int[] arr) {
        return subarraymax(arr)-subarraymin(arr);
    }
    public int[] nextsmallerelement(int []arr){
        int n=arr.length;
        int []nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
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

    public int[] previoussmallerorequalelement(int []arr){
        int n=arr.length;
        int []psee=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                psee[i]=-1;
            }
            else{
                psee[i]=st.peek();
            }
            st.push(i);
        }
        return psee;
    }
    public long subarraymin(int []arr){
        int []nse=nextsmallerelement(arr);
        int []psee=previoussmallerorequalelement(arr);
        long total=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            long left=i-psee[i];
            long right=nse[i]-i;
            total+=left*right*arr[i];
        }
        return total;
    }


    public int[] nextgreaterelement(int []arr){
        int n=arr.length;
        int []nge=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=n;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
        return nge;
    }

    public int[] previousgreaterorequalelement(int []arr){
        int n=arr.length;
        int []pgee=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pgee[i]=-1;
            }
            else{
                pgee[i]=st.peek();
            }
            st.push(i);
        }
        return pgee;
    }

    public long subarraymax(int []arr){
        int []nge=nextgreaterelement(arr);
        int []pgee=previousgreaterorequalelement(arr);
        long total=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            long left=i-pgee[i];
            long right=nge[i]-i;
            total+=left*right*arr[i];
        }
        return total;
    }
}