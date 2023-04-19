package binarytree.treedemo;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(14);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(10);

        root.setLeftChild(node2);
        root.setRightChild(node3);
        node2.setLeftChild(node5);
        node2.setRightChild(node6);
        node3.setLeftChild(node4);

        createBinaryTree.setRoot(root);
//        createBinaryTree.preOrder();

        createBinaryTree.infixOrder();
//
//        createBinaryTree.postOrder();
//
//        TreeNode treeNode = createBinaryTree.preOrderSearch(4);
//        if (treeNode != null){
//            System.out.println("找到了" + treeNode);
//        }

//        createBinaryTree.delNode(3);
//
//        createBinaryTree.preOrder();
    }
}
