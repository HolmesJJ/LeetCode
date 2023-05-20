class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        rows.add(row1);
        if (numRows == 1) {
            return rows;
        }
        List<Integer> pre_row = row1;
        for (int i = 1; i < numRows; i++) {
            List<Integer> new_row = generateCurRow(pre_row);
            rows.add(new_row);
            pre_row = new_row;
        }
        return rows;
    }
    
    public List<Integer> generateCurRow(List<Integer> pre_row) {
        List<Integer> cur_row = new ArrayList<>();
        cur_row.add(1);
        for (int i = 0; i < pre_row.size() - 1; i++) {
            cur_row.add(pre_row.get(i) + pre_row.get(i + 1));
        }
        cur_row.add(1);
        return cur_row;
    }
}