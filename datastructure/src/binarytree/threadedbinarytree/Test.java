package binarytree.threadedbinarytree;



public class Test {
    public static void main(String[] args) {

    CreateThreadedBinaryTree createThreadedBinaryTree = new CreateThreadedBinaryTree();
    ThreadedTreeNode root = new ThreadedTreeNode(1);
    ThreadedTreeNode node2 = new ThreadedTreeNode(3);
    ThreadedTreeNode node3 = new ThreadedTreeNode(6);
    ThreadedTreeNode node4 = new ThreadedTreeNode(8);
    ThreadedTreeNode node5 = new ThreadedTreeNode(10);
    ThreadedTreeNode node6 = new ThreadedTreeNode(14);


    root.setLeftChild(node2);
    root.setRightChild(node3);
    node2.setLeftChild(node4);
    node2.setRightChild(node5);
    node3.setLeftChild(node6);

    createThreadedBinaryTree.setRoot(root);
    createThreadedBinaryTree.threadedNode();

    ThreadedTreeNode leftChild = node5.getLeftChild();
    System.out.println(leftChild);
    }
}
