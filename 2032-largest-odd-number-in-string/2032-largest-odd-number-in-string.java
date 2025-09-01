class Solution {
    public String largestOddNumber(String num) {
        String result = ""; // Initialize the result as an empty string

        // Traverse the string from start to end
        for (int i = 0; i < num.length(); i++) {
            // Check if the character is an odd digit
            if ((num.charAt(i) - '0') % 2 == 1) {
                // Update the result to include this character
                result = num.substring(0, i + 1);
            }
        }

        // Return the result (largest odd-numbered substring)
        return result;
        
    }
}