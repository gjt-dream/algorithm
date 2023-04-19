package binarytree.sorttree;
/*
        二叉排序树
 */
public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    /**
     * 添加节点
     * @param node
     */
    public void add(Node node){
        //如果这个节点为空，直接返回
        if (node == null){
            return;
        }

        //将传入的节点值与当前节点的值进行比较
        if (this.data >= node.getData()) {
            if (this.getLeft() == null) {
                this.setLeft(node);
            }else {
                this.left.add(node);
            }
        }else {
            if (this.getRight() == null) {
                this.setRight(node);
            }else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null){
            this.right.infixOrder();
        }
    }

    /**
     * 查找
     * @param value
     * @return
     */
    public Node find(int value){
        if (this.data == value){
            return this;
        }else if (value < this.data){
            if (this.left == null){
                return null;
            }
            return this.left.find(value);
        }else {
            if (this.right == null){
                return null;
            }
            return this.right.find(value);
        }
    }

    public Node findParent(int value){
        //如果当前节点是要删除节点的父节点，就返回
        if ((this.left != null && this.left.data == value) || (this.right != null && this.right.data == value)){
            return this;
        }else{
            if (this.left != null && value < this.data ){
                return this.left.findParent(value);
            }else if (this.right != null && value >= this.data){
                return this.right.findParent(value);
            }else {
                return null;
            }
        }
    }
}
