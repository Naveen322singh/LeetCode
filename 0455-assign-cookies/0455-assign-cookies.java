class Solution {
    public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int i=0;
        int j=0;
        while(i<children.length && j<cookies.length){
            if (children[i]<=cookies[j]){
                i++;
            }
            j++;
        }
        return i;
        
    }
}