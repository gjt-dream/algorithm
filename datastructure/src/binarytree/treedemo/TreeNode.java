package binarytree.treedemo;

/**
 * 树节点
 */
public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
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
    public TreeNode preOrderSearch(int data){
        if (this.data == data){
            return this;
        }

        TreeNode resData = null;
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
    public TreeNode infixOrderSearch(int data){
        TreeNode resData = null;
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
    public TreeNode postOrderSearch(int data){
        TreeNode resData = null;
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
