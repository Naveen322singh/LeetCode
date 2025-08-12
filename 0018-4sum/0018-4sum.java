class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n=arr.length;
        Set<List<Integer>> st=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Long> hashset=new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum=arr[i]+arr[j];
                    sum+=arr[k];
                    long fourth=target-sum;
                    if(hashset.contains(fourth)){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int)fourth);
                        temp.sort(null);
                        st.add(temp);
                    }
                    hashset.add((long)arr[k]);
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>(st);
        return ans;
    }
}