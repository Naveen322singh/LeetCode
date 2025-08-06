class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == -asteroids[i]) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
            }
        }
        int n=stack.size();
        int[] result = new int[n];
        for (int i = n-1; i >=0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}