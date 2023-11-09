class Solution {
    public String pushDominoes(String dominoes) {
        char[] ds = dominoes.toCharArray();
        int n = ds.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (ds[i] == '.') {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            char[] temp = ds.clone();
            int size = queue.size();
            boolean isUpdate = false;
            for (int j = 0; j < size; j++) {
                int i = queue.poll();
                if (i - 1 >= 0 && ds[i - 1] == 'R' && (i + 1 >= n || ds[i + 1] != 'L')) {
                    temp[i] = 'R';
                    isUpdate = true;
                    continue;
                }
                if (i + 1 < n && ds[i + 1] == 'L' && (i - 1 < 0 || ds[i - 1] != 'R')) {
                    temp[i] = 'L';
                    isUpdate = true;
                    continue;
                }
                if (i - 1 >= 0 && ds[i - 1] == 'R' && i + 1 < n && ds[i + 1] == 'L') {
                    continue;
                }
                queue.add(i);
            }
            ds = temp;
            if (!isUpdate) {
                break;
            }
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            res = res + ds[i];
        }
        return res;
    }
}