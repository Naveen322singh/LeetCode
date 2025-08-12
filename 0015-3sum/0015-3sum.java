class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n=arr.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            Set<Integer> hashset=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third=-(arr[i]+arr[j]);
                if(hashset.contains(third)){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(arr[j]);
            }
        }
        List<List<Integer>> ans=new ArrayList<>(st);
        return ans;
    }
}