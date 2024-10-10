package com.henry.leetcode.problems.oct_24.oct_08_24;

import com.henry.leetcode.utils.TreeNode;

/**
 * LeetCode Problem 409: Longest Palindrome
 *
 * Given the roots of two binary trees root and subRoot, return true if there
 * is a subtree of root with the same structure and node values of subRoot and
 * false otherwise.
 *
 * @problemId 572
 * @problemName Subtree of Another Tree
 * @difficulty Easy
 * @topics Recursion
 * @date 10/08/2024
 * @Notes The key is to compare if two trees are the same, by comparing left subtree and right subtree.
 */
public class Problem572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) { return true; }
        if (root == null || subRoot == null) { return false; }

        if (isSameTree(root, subRoot)) { return true; }

        if (isSubtree(root.left, subRoot)) { return true; }
        if (isSubtree(root.right, subRoot)) { return true; }

        return false;
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) { return true; }
        if (s == null || t == null) { return false; }

        return (s.val == t.val) && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

}
