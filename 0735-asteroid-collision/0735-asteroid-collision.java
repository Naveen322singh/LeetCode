class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int ast : asteroids) {
            if (ast > 0) {
                list.add(ast);
            } else {
                while (!list.isEmpty() && list.get(list.size() - 1) > 0 && list.get(list.size() - 1) < Math.abs(ast)) {
                    list.remove(list.size() - 1);
                }
                if (!list.isEmpty() && list.get(list.size() - 1) == Math.abs(ast)) {
                    list.remove(list.size() - 1);
                } else if (list.isEmpty() || list.get(list.size() - 1) < 0) {
                    list.add(ast);
                }
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}