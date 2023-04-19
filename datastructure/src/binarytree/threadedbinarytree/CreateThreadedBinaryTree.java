package binarytree.threadedbinarytree;


/**
 * 构建二叉树
 */
public class CreateThreadedBinaryTree {
    //根节点
    private ThreadedTreeNode root;

    private ThreadedTreeNode pre = null;

    public void setRoot(ThreadedTreeNode root) {
        this.root =root;
    }

    public void threadedNode(){
        this.threadedNode(root);
    }

    /**
     * 编写对二叉树进行中序线索化的节点
     * @param node 需要线索化的节点
     */
    public void threadedNode(ThreadedTreeNode node){
        //不能线索化
        if (node == null){
            return;
        }

        //先线索化左子树
        threadedNode(node.getLeftChild());

        //线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeftChild() == null){
            //让当前节点的左孩子指向前驱节点
            node.setLeftChild(pre);
            //修改当前节点的左孩子类型，指向前驱节点
            node.setLeftType(1);
        }

        //处理后继节点
        if (pre != null && pre.getRightChild() == null){
            //让当前节点的右孩子指向前驱节点
            pre.setRightChild(node);
            //修改当前节点的右孩子类型，指向前驱节点
            pre.setRightType(1);
        }
        pre = node;

        threadedNode(node.getRightChild());
    }



    public void preOrder(){
        if (root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空！");
        }
      }

    public void infixOrder(){
        if (root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空！");
        }
    }

    public void postOrder(){
        if (root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空！");
        }
    }

    /**
     * 前序查找
     * @param data
     * @return
     */
    public ThreadedTreeNode preOrderSearch(int data){
        if (root != null){
            return this.root.preOrderSearch(data);
        }else {
            return null;
        }
    }


    /**
     * 中序遍历
     * @param data
     * @return
     */
    public ThreadedTreeNode infixOrderSearch(int data){
        if (root != null){
            return this.root.infixOrderSearch(data);
        }else {
            return null;
        }
    }

    /**
     * 后序遍历
     * @param data
     * @return
     */
    public ThreadedTreeNode postOrderSearch(int data){
        if (root != null){
            return this.root.infixOrderSearch(data);
        }else {
            return null;
        }
    }

    public void delNode(int data){
        if (root != null){
            if (root.getData() == data){
                root = null;
            }else {
                root.delNode(data);
            }
        }else {
            System.out.println("二叉树为空！");
        }
    }
}
