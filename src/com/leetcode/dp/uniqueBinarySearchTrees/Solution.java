package com.leetcode.dp.uniqueBinarySearchTrees;

public class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        //以第i个为根，i左边的系列构成左子树，i右边的序列构成右子树，注意G[i]只与序列个数有关
        for (int i = 2; i <= n; i++) {
            //子切割
            for (int j = 1; j <= i; j++) {
                G[i] += G[i - j] * G[j - 1];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.numTrees(3));
    }
}
