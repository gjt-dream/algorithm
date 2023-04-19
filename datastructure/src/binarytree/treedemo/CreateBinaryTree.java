package binarytree.treedemo;

/**
 * 构建二叉树
 */
public class CreateBinaryTree {
    //根节点
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
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
    public TreeNode preOrderSearch(int data){
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
    public TreeNode infixOrderSearch(int data){
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
    public TreeNode postOrderSearch(int data){
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
