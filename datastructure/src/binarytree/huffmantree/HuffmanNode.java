package binarytree.huffmantree;


public class HuffmanNode implements Comparable<HuffmanNode> {
    private int data;
    private HuffmanNode left;
    private  HuffmanNode right;

    public HuffmanNode(int data) {
        this.data = data;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "data=" + data +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.data - o.data;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }

        if (this.right != null){
            this.right.preOrder();
        }
    }
}
