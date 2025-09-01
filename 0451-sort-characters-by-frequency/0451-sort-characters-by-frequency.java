class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a list from the frequency map entries
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

        // Step 3: Sort the list by frequency in descending order
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < entryList.size(); i++) {
            Map.Entry<Character, Integer> entry = entryList.get(i);
            char c = entry.getKey();
            int freq = entry.getValue();
            for (int j = 0; j < freq; j++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}