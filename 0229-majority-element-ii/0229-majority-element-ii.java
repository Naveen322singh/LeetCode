class Solution {
    public List<Integer> majorityElement(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        int n=arr.length;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
        for (int i = 0; i < n; i++) {
            if (mpp.get(arr[i]) > n / 3 && !list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        return list;
    }
}