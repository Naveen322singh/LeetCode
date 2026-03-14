class Solution {
    public int reverse(int num) {
        
        long rev=0;
        int digit;
        while(num!=0)
        {
            digit=num%10;
            rev=rev*10+digit;
            num=num/10;
        }
        if (rev>Integer.MAX_VALUE||rev<Integer.MIN_VALUE)
        {
            return 0;
        }
        return (int)rev;
    }
}