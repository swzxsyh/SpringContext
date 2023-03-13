package com.test.application.algorithm.other.tree;

import com.test.application.algorithm.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class AbstractTreeTraverseTest {

    private TreeNode bt = null;
    private AbstractTreeTraverse traverse = null;

    private final Class<?> TYPE = StackBinaryTreeTraverse.class;

    @Before
    public void set() {
        if (RecursionBinaryTreeTraverse.class.equals(TYPE)) {
            //递归
            traverse = new RecursionBinaryTreeTraverse();
        } else if (StackBinaryTreeTraverse.class.equals(TYPE)) {
            //栈
            traverse = new StackBinaryTreeTraverse();
        } else {
            log.info("SELECT ERROR");
        }
    }


    ///        A
    ///      /   \
    ///     B     C
    ///    / \   / \
    ///   D   E F   G
    @Before
    public void setUp() {
        bt = new TreeNode("A");
        bt.left = new TreeNode("B");
        bt.right = new TreeNode("C");

        bt.left.left = new TreeNode("D");
        bt.left.right = new TreeNode("E");

        bt.right.left = new TreeNode("F");
        bt.right.right = new TreeNode("G");

    }

    @Test
    public void preOrderTest() {
        traverse.preOrder(bt);
    }

    @Test
    public void inOrderTest() {
        traverse.inOrder(bt);
    }

    @Test
    public void postOrderTest() {
        traverse.postOrder(bt);
    }

    @Test
    public void sequenceOrderTest(){
        traverse.sequenceOrder(bt);
    }
}