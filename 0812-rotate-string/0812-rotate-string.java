class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate s with itself and check if goal is a substring
        String doubleS = s + s;
        return doubleS.contains(goal);
        
    }
}