package com.binarysearch;

/**
 * 二分搜索树
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

    // 树中节点为私有类
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    // 根节点
    private Node root;
    // 节点个数
    private int count;

    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // 向二分搜索树插入新的节点
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        }
        else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        }
        else {
            node.right = insert(node.right, key, value);
        }
    }

    private boolean contain(Node node, Key key) {
        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        }
        else if(key.compareTo(node.key) < 0) {
            return contain(node.left, key);

        }
        else {
            return contain(node.right, key);
        }
    }

    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        }
        else if(key.compareTo(node.key) < 0) {
            return search(node.left, key);
        }
        else {
            return search(node.right, key);
        }
    }

    /**
     * 添加深度优先遍历
     * 包括前序遍历， 中序遍历， 后续遍历
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
        }
    }


    public static void main(String[] args) {

    }

}
