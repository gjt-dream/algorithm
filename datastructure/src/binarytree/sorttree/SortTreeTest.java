package binarytree.sorttree;

public class SortTreeTest {
    public static void main(String[] args) {
        int arr[] = {7,3,10,12,5,1,9,0};
        CreateBinarySortTree createBinarySortTree = new CreateBinarySortTree();
        for (int i = 0;i < arr.length;i++){
            createBinarySortTree.add(new Node(arr[i]));
        }

        createBinarySortTree.infixOrder();
        createBinarySortTree.del(10);
        System.out.println();
        createBinarySortTree.infixOrder();
    }
}
