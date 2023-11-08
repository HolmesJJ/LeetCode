class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String local = emails[i].split("@")[0];
            String domain = emails[i].split("@")[1];
            String valid = local.split("\\+")[0];
            String[] dotSplits = valid.split("\\.");
            String finalLocal = "";
            for (int j = 0; j < dotSplits.length; j++) {
                finalLocal = finalLocal + dotSplits[j];
            }
            String finalEmail = finalLocal + "@" + domain;
            set.add(finalEmail);
        }
        return set.size();
    }
}