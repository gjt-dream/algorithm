package binarytree.arrtree;

import java.util.Arrays;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);

        arrBinaryTree.preOrder(0);
    }
}
