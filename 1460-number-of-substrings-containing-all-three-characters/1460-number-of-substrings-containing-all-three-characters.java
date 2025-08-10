class Solution {
    public int numberOfSubstrings(String s) {
        int l=0;
        int r=0;
        int count=0;
        int n=s.length();
        HashMap <Character,Integer> mpp=new HashMap<>();
        while(r<n){
            mpp.put(s.charAt(r),mpp.getOrDefault(s.charAt(r),0)+1);
            while(mpp.containsKey('a') && mpp.containsKey('b') && mpp.containsKey('c')){
                count=count+(n-r);

                mpp.put(s.charAt(l),mpp.get(s.charAt(l))-1);
                if(mpp.get(s.charAt(l))==0){
                    mpp.remove(s.charAt(l));
                }
                l++;
            }
            r++;
        }
        return count;
        
    }
}