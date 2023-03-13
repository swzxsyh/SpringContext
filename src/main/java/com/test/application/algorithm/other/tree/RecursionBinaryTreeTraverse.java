package com.test.application.algorithm.other.tree;

import com.test.application.algorithm.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 递归方案
 */
@Slf4j
public class RecursionBinaryTreeTraverse extends AbstractTreeTraverse {

    /**
     * 前序
     *
     * @param treeNode
     */
    @Override
    public void preOrder(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        log.info((String) treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 中序
     *
     * @param treeNode
     */
    @Override
    public void inOrder(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        inOrder(treeNode.left);
        log.info((String) treeNode.val);
        inOrder(treeNode.right);
    }

    /**
     * 后序
     *
     * @param treeNode
     */
    @Override
    public void postOrder(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        log.info((String) treeNode.val);
    }

    /**
     * 层序
     *
     * @param treeNode
     */
    @Override
    public void sequenceOrder(TreeNode treeNode) {

    }
}
