class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            if (len + line.size() + words[i].length() > maxWidth) {
                int extraSpace = maxWidth - len;
                int spaces = extraSpace / Math.max(1, line.size() - 1);
                int remainder = extraSpace % Math.max(1, line.size() - 1);
                for (int j = 0; j < Math.max(1, line.size() - 1); j++) {
                    line.set(j, line.get(j) + new String(new char[spaces]).replace("\0", " "));
                    if (remainder > 0) {
                        line.set(j, line.get(j) + " ");
                        remainder--;
                    }
                }
                res.add(String.join("", line));
                line.clear();
                len = 0;
            }
            line.add(words[i]);
            len += words[i].length();
        }
        String lastLine = String.join(" ", line);
        int trailSpace = maxWidth - lastLine.length();
        res.add(lastLine + new String(new char[trailSpace]).replace("\0", " "));
        return res;
    }
}