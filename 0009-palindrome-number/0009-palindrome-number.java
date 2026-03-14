class Solution {
    public boolean isPalindrome(int n) {
        int originalNumber=n;
        int reverseNumber=0;
        while(n>0){
            int last_digit=n%10;
            n=n/10;
            reverseNumber=(reverseNumber*10)+last_digit;
        }
        if(originalNumber==reverseNumber){
            return true;
        }
        return false;
    }
}