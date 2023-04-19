package binarytree.val;

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
     * 返回左子树的高度
     * @return
     */
    public int leftHeight(){
        if (left == null){
            return 0;
        }else {
            return left.height();
        }
    }

    /**
     * 返回右子树的高度
     * @return
     */
    public int rightHeight(){
        if (right == null){
            return 0;
        }else {
            return right.height();
        }
    }

    /**
     * 返回当前节点的高度
     * @return
     */

    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) + 1;
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
        if (rightHeight() - leftHeight() > 1){
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()){
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() > 1){
            //如果左节点的右节点的高度大于左节点的高度
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()){
                rightRotate();
            }else {
                rightRotate();
            }
        }
    }

    /**
     * 左旋转
     */
    public void leftRotate(){
        //创建新的节点，以当前节点的值为值
        Node newNode = new Node(data);
        //把新的节点的左子树设为当前节点的左子树
        newNode.left = this.left;
        //把新节点的右子树设置成当前节点右子树的左子树
        newNode.right = this.right.left;
        //把当前节点的值替换为当前节点的右子树的值
        this.data = this.right.data;
        //把当前节点的右子树设置为当前节点右子树的右子树
        this.right = this.right.right;
        //把当前节点的左子树设置为新节点
        this.left = newNode;
    }

    public void rightRotate(){
        Node newNode = new Node(this.data);

        newNode.right = this.right;

        newNode.left = this.left.right;

        this.data = this.left.data;

        this.left = this.left.left;

        this.right = newNode;
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
