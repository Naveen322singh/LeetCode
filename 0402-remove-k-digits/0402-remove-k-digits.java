class Solution {
    public String removeKdigits(String s, int k) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > current) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }

        // Remove remaining digits from end if needed
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build the result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            result.append(stack.get(i));
        }

        // Remove leading zeros
        if (result.length() > 0) {
            while (result.length() > 1 && result.charAt(0) == '0') {
                result.deleteCharAt(0);
            }
        }

        // Return "0" if empty
        if (result.length() == 0) {
            return "0";
        } else {
            return result.toString();
        }
    }
}