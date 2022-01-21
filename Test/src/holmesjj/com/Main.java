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

    private static int paths = 0;

    public static int pathSum(TreeNode root, int targetSum) {
        hasPathSum(root, targetSum);
        return paths;
    }

    public static void hasPathSum(TreeNode root, int targetSum) {

        System.out.print(targetSum + ", ");

        if (root == null) {
            return;
        } else {
            // 不一定要到叶结点
            if (targetSum == root.val) {
                paths++;
                System.out.println("");
                return;
            }
        }

        // 每个结点都会有两种情况
        hasPathSum(root.left, targetSum);
        hasPathSum(root.left, targetSum - root.val);
        hasPathSum(root.right, targetSum);
        hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        pathSum(root, 8);
        System.out.println(paths);
    }
}