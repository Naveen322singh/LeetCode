class Solution {
    public int NcR(int n,int r){
        int res =1;
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }

    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list=new ArrayList<>();
        for(int r=1;r<=n;r++){
            List<Integer> row=new ArrayList<>();
            for (int c=1;c<=r;c++){
                int element=NcR(r-1,c-1);
                row.add(element);

            }
            list.add(row);
        }
        return list;
    }
}