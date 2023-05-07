class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = words[words.length - i - 1];
        }
        String result = "";
        for (int i = 0; i < reversedWords.length; i++) {
            if (reversedWords[i] != "") {
                result = result + reversedWords[i] + " ";
            }
        }
        return result.trim();
    }
}