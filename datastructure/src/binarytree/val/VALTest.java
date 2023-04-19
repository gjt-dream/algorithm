package binarytree.val;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VALTest {
    public static void main(String[] args) {
//        int arr[] = {4,3,6,5,7,8};
        int arr[] = {10,12,8,9,7,6};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        avlTree.infixOrder();
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());

        List<Integer> integers = new ArrayList<>();
    }
}
