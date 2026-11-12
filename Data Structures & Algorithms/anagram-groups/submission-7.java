class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();

        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;

            List<String> anagrams = new ArrayList<>();
            anagrams.add(strs[i]);
            visited[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    anagrams.add(strs[j]);
                    visited[j] = true;
                }
            }
            groupedAnagrams.add(anagrams);
        }
        return groupedAnagrams;
    }

    public boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] alpha = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            alpha[word1.charAt(i) - 'a']++;
            alpha[word2.charAt(i) - 'a']--;
        }

        for (int n : alpha) {
            if (n > 0) {
                return false;
            }
        }
        return true;
    }
}
