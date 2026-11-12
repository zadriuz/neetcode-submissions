class Solution {

    public String encode(List<String> strs) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String word = strs.get(i);
            int length = strs.get(i).length();
            char delimiter = '#';

            string.append(length).append(delimiter).append(word);
        }
        return string.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int delimiterIndex = str.indexOf('#', i);
            int length = Integer.valueOf(str.substring(i, delimiterIndex)); // number mismo
            
            int start = delimiterIndex + 1;
            int end = start + length;

            decoded.add(str.substring(start, end));

            i = end - 1;
        }

        return decoded;
    }
}
