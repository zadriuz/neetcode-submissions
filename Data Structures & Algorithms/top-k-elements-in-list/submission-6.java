class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqCount.put(nums[i], freqCount.getOrDefault(nums[i], 0) + 1);
        }

        int[] frequents = new int[k];
        for (int i = 0; i < k; i++) {
            frequents[i] = getMostFrequent(freqCount);
            freqCount.remove(getMostFrequent(freqCount));
        }
        return frequents;
    }

    public int getMostFrequent(Map<Integer, Integer> freqCount) {
        int largestNum = Integer.MIN_VALUE;
        int largestQty = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            int currentNum = entry.getKey();
            int currentQty = entry.getValue();

            if (currentQty > largestQty) {
                largestNum = currentNum;
                largestQty = currentQty;
            }
        }
        return largestNum;
    }
}
