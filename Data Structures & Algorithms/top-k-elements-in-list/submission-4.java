class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int numNeeded = k;
        int[] mostFreq = new int[k];
        HashMap<Integer, Integer> freqCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqCount.put(nums[i], freqCount.getOrDefault(nums[i], 0) + 1);
        }

        int largestNum = Integer.MIN_VALUE;

        int iterator = 0;

        while (numNeeded > 0) {
            largestNum = findMostFrequentNumber(freqCount);
            mostFreq[iterator] = largestNum;

            freqCount.remove(largestNum);
            largestNum = Integer.MIN_VALUE;

            numNeeded--;
            iterator++;
        }
        return mostFreq;
    }

    public int findMostFrequentNumber(HashMap<Integer, Integer> freqCount) {
        int maxFreq = Integer.MIN_VALUE;
        int mostFrequentNum = Integer.MIN_VALUE; // Or handle empty map appropriately

        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            int currentNum = entry.getKey();
            int currentFreq = entry.getValue();

            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                mostFrequentNum = currentNum;
            }
        }

        return mostFrequentNum;
    }
}
