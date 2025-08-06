class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            // Handle collisions only when top is moving right and current is moving left
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();
                
                if (top < -asteroid) {
                    stack.pop();  // Top explodes
                    continue;     // Check next asteroid in stack
                } else if (top == -asteroid) {
                    stack.pop();  // Both explode
                }
                // If top > -asteroid, current asteroid explodes
                asteroid = 0;    // Mark as exploded
                break;
            }
            
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }
        
        // Convert stack to array (in reverse order)
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}