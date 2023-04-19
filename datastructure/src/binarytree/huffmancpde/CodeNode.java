package binarytree.huffmancpde;

public class CodeNode implements Comparable<CodeNode> {
    //存放数据本身；‘a' => 97
    private Byte data;
    //权值，表示字符出现的次数
    private int weight;

    private CodeNode left;
    private CodeNode right;

    public CodeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CodeNode getLeft() {
        return left;
    }

    public void setLeft(CodeNode left) {
        this.left = left;
    }

    public CodeNode getRight() {
        return right;
    }

    public void setRight(CodeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "CodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(CodeNode o) {
        return this.weight - o.weight;
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
