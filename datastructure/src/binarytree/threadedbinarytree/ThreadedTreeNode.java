package binarytree.threadedbinarytree;

/**
 * 树节点
 */
public class ThreadedTreeNode {
    private int data;
    private ThreadedTreeNode leftChild;
    private ThreadedTreeNode rightChild;
    //如果leftType; == 0 表示指向左子树，如果为1表示指向前驱节点
    //如果rightType; == 0 表示指向右子树，如果为1表示指后继驱节点
    private int leftType;
    private int rightType;
    public ThreadedTreeNode(int data) {
        this.data = data;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ThreadedTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(ThreadedTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public ThreadedTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(ThreadedTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        //输出当前节点
        System.out.println(this);
        //如果左孩子不为空就递归左孩子
        if (this.leftChild != null){
            this.leftChild.preOrder();
        }

        //如果右孩子不为空就递归右孩子
        if (this.rightChild != null){
            this.rightChild.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (this.leftChild != null){
            this.leftChild.infixOrder();
        }

        System.out.println(this);

        if (this.rightChild != null){
            this.rightChild.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        if (this.leftChild != null){
            this.leftChild.infixOrder();
        }
        if (this.rightChild != null){
            this.rightChild.infixOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序查找
     * @param data
     * @return
     */
    public ThreadedTreeNode preOrderSearch(int data){
        if (this.data == data){
            return this;
        }

        ThreadedTreeNode resData = null;
        if (this.leftChild != null){
            resData = this.leftChild.preOrderSearch(data);
        }

        if (resData != null){
            return resData;
        }

        if (this.rightChild != null){
            resData = this.rightChild.preOrderSearch(data);
        }
        return resData;
    }

    /**
     * 中序遍历
     * @param data
     * @return
     */
    public ThreadedTreeNode infixOrderSearch(int data){
        ThreadedTreeNode resData = null;
        if (this.leftChild != null){
            resData = this.leftChild.infixOrderSearch(data);
        }

        if (resData != null){
            return resData;
        }

        if (this.data == data){
            return this;
        }

        if (this.rightChild != null){
            resData = this.rightChild.infixOrderSearch(data);
        }
        return resData;
    }


    /**
     * 后序遍历
     * @param data
     * @return
     */
    public ThreadedTreeNode postOrderSearch(int data){
        ThreadedTreeNode resData = null;
        if (this.leftChild != null){
            resData = this.leftChild.postOrderSearch(data);
        }

        if (resData != null){
            return resData;
        }

        if (this.rightChild != null){
            resData = this.rightChild.postOrderSearch(data);
        }

        if (resData != null){
            return resData;
        }

        if (this.data == data){
            return this;
        }
        return resData;
    }



    public void delNode(int data){
        if (this.leftChild != null && this.leftChild.data == data){
            this.leftChild = null;
            return;
        }

        if (this.rightChild != null && this.rightChild.data == data){
            this.rightChild = null;
            return;
        }

        if (this.leftChild != null){
            this.leftChild.delNode(data);
        }

        if (this.leftChild == null){
            return;
        }
        if (this.rightChild != null){
            this.rightChild.delNode(data);
        }

    }
}
