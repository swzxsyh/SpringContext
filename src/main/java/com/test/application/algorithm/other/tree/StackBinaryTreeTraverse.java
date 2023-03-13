package com.test.application.algorithm.other.tree;

import com.test.application.algorithm.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 栈方案
 */
@Slf4j
public class StackBinaryTreeTraverse extends AbstractTreeTraverse {

    /**
     * 前序
     *
     * @param treeNode
     */
    @Override
    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            log.info((String) node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序
     *
     * @param treeNode
     */
    @Override
    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = treeNode;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            log.info((String) node.val);
            if (node.right != null) {
                current = node.right;
            }
        }
    }

    /**
     * 后序
     *
     * @param treeNode
     */
    @Override
    public void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            stack2.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            log.info((String) stack2.pop().val);
        }
    }

    /**
     * 层序
     *
     * @param treeNode
     */
    @Override
    public void sequenceOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            //节点出队
            TreeNode node = queue.poll();
            log.info((String) node.val);
            //节点左子树入队
            if (node.left != null) {
                queue.add(node.left);
            }
            //节点右子树入队
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
