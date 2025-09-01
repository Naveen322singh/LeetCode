class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {  // traverse from end of num
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);  // return prefix ending at odd digit
            }
        }
        return "";  // if there's no odd
    }
}