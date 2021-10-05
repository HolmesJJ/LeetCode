package holmesjj.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {

    public static int[] kWeakestRows(int[][] mat, int k) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int i = 0; i < mat.length; i++) {
            // 每一行用二分搜索找到最后一个士兵的位置
            int start = 0;
            int end = mat[i].length - 1;
            while (start < end) {
                if (start == end - 1) {
                    break;
                }
                int mid = start + (end - start) / 2;
                if (mat[i][mid] == 1) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            List<Integer> indexes;
            // start就是最后一个士兵的位置
            if (treeMap.get(start) != null) {
                indexes = treeMap.get(start);
                indexes.add(i);
            } else {
                indexes = new ArrayList<>();
                indexes.add(i);
            }
            Collections.sort(indexes);
            treeMap.put(start, indexes);
        }
        int[] result = new int[k];
        int m = 0;
        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            if (m == k) {
                break;
            }
            List<Integer> indexes = entry.getValue();
            for (int i = 0; i < indexes.size(); i++) {
                if (m == k) {
                    break;
                }
                result[m] = indexes.get(i);
                m++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int[][] mat = new int[5][5];
        mat[0] = new int[]{1,1,0,0,0};
        mat[1] = new int[]{1,1,1,1,0};
        mat[2] = new int[]{1,0,0,0,0};
        mat[3] = new int[]{1,1,0,0,0};
        mat[4] = new int[]{1,1,1,1,1};
        kWeakestRows(mat, 1);
    }
}