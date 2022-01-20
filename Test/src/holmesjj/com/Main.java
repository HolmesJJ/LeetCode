package holmesjj.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        boolean[][] isValid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isValid[i], true);
        }
        backtracking(results, result, isValid, 0, n);
        return results;
    }

    public static void backtracking(List<List<String>> results, List<String> result, boolean[][] isValid, int queens, int n) {

        // 皇后的数量
        if (queens == n) {
            // 收集结果，需要创建一个新的对象
            results.add(new ArrayList<>(result));
            return;
        }

        // 处理结点
        // 不需要每次都从第一行扫描，因为每个皇后肯定只能存在一行中
        // 有多少个皇后就代表前几行都不能再放皇后
        // 只需要遍历当前没有皇后的行即可
        int a = queens;
        for (int b = 0; b < n; b++) {
            if (isValid[a][b]) {
                // 当前皇后的位置为a, b

                // 复制当前可行区域
                boolean[][] nIsValid = new boolean[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        nIsValid[i][j] = isValid[i][j];
                    }
                }

                // 摆放一个皇后，更新剩下可行的格子
                // 00 01 02 03
                // 10 11 12 13
                // 20 21 22 23
                // 30 31 32 33
                for (int i = queens; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        // 行
                        if (i == a) {
                            nIsValid[i][j] = false;
                        }
                        // 列
                        if (j == b) {
                            nIsValid[i][j] = false;
                        }
                        // 斜线
                        if (a - b == i - j) {
                            nIsValid[i][j] = false;
                        }
                        if (a + b == i + j) {
                            nIsValid[i][j] = false;
                        }
                    }
                }

                // 添加放置了当前皇后的行
                String line = "";
                for (int i = 0; i < n; i++) {
                    if (i != a) {
                        line = line + ".";
                    } else {
                        line = line + "Q";
                    }
                }
                result.add(line);
                queens++;
                backtracking(results, result, nIsValid, queens, n);
                // 回溯操作
                result.remove(result.size() - 1);
                queens--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solveNQueens(4);
    }
}