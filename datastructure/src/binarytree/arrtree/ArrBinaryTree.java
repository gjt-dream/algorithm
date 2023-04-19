package binarytree.arrtree;

public class ArrBinaryTree {
    private int arr[];

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空！");
        }
        System.out.println(arr[index]);

        //向左递归遍历
        if (index * 2 + 1 < arr.length){
            preOrder(index * 2 +1);
        }


        //向右递归遍历
        if (index * 2 + 2 < arr.length){
            preOrder(index * 2 + 2);
        }
    }
}


