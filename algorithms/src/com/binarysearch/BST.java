package com.binarysearch;

import java.util.LinkedList;

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

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
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

    // 查看bst中是否存在键值key
    public boolean contain(Key key) {
        return contain(root, key);
    }

    // 查找bst中key对应的值 不存在的话返回null
    public Value search(Key key) {
        return search(root, key);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
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

    /**
     * 添加广度优先遍历
     */
    public void levelOrder() {
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(root);
        while( !q.isEmpty() ) {
            Node node = q.remove();
            System.out.println(node.key);

            if(node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right)
            }
        }
    }

    // 寻找bst中最小的键值
    public Key minimum() {
        assert count != 0;
        Node miniNode = minimum(root);
        return miniNode.key;
    }

    // 寻找bst中最大的键值
    public Key maxinum() {
        assert count != 0;
        Node maxNode = maximun(root);
        return maxNode.key;
    }


    /**
     * 查找以node为根的bst的最小键值和最大键值所在节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node maximun(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximun(node.right);
    }

    /**
     * 删除以node为根的bst的最小节点和最大节点
     *
     * 整体思路一致：以最小节点为例
     * 通过递归查找最小，对该节点右子节点进行重新赋值
     * 删除该节点后，返回其右子节点
     * 将此右子节点重新赋值给新父节点的左子节点
     */

    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        else {
            // key == node.key

            // 待删除节点左子树为空时
            removeMin(node);
            // 待删除节点右子树为空时
            removeMax(node);

            /**
             * 待删除节点左右子树均不为空
             * 找到以该节点为根的子树的右子树的最小值
             * 并用此节点代替待删除节点位置
             */
            Node successor = new Node(minimum(node.right));
            count++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count--;
            return successor;
        }
    }


    public static void main(String[] args) {

    }

}
