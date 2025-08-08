class LFUCache {
    // Key-Value store
    private Map<Integer, Integer> keyToValue;
    // Key-Frequency store
    private Map<Integer, Integer> keyToFreq;
    // Frequency-Keys store (using LinkedHashSet to maintain insertion order for LRU)
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    private int minFreq;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToValue = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        // Increase frequency
        increaseFrequency(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        // If key exists, update value and increase frequency
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFrequency(key);
            return;
        }

        // If cache is full, remove LFU item (LRU if tie)
        if (keyToValue.size() >= capacity) {
            evict();
        }

        // Add new key with frequency 1
        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1; // New item always has frequency 1
    }

    private void increaseFrequency(int key) {
        int freq = keyToFreq.get(key);
        // Update frequency map
        keyToFreq.put(key, freq + 1);

        // Remove from current frequency set
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // If this was the min frequency, update minFreq
            if (freq == minFreq) {
                minFreq++;
            }
        }

        // Add to new frequency set
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
    }

    private void evict() {
        // Get the LRU key from the min frequency set
        LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
        int keyToRemove = keys.iterator().next();

        // Remove from all maps
        keys.remove(keyToRemove);
        if (keys.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyToValue.remove(keyToRemove);
        keyToFreq.remove(keyToRemove);
    }
}