package binarytree.val;


public class AVLTree {
    private Node root;
    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }
    public void infixOrder(){
        if (root == null){
            return;
        }else {
            root.infixOrder();
        }
    }

    /**
     * 查找目标节点
     * @param value
     * @return
     */
    public Node find(int value){
        if (root == null){
            return null;
        }else {
            return root.find(value);
        }
    }

    /**
     * 查找目标节点的父节点
     * @param value
     * @return
     */
    public Node findParent(int value){
        if (root == null){
            return null;
        }else {
            return root.findParent(value);
        }
    }

    /**
     * 返回以node为根节点的最小节点的值
     * 删除以node为根节点的最小节点
     * @param node 要删除节点的右节点
     * @return
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        //循环查找左子节点，找到最小值
        while (target.getLeft() != null){
            target = target.getLeft();
        }
        //删除最小节点
        del(target.getData());
        return  target.getData();
    }

    public Node getRoot() {
        return root;
    }

    public void del(int value){
        if (root == null){
            return;
        }else {
            //查找要删除的节点
            Node delNode = find(value);
            //没有找到要删除的节点
            if (delNode == null){
                return;
            }

            //如果只要根节点就直接删除
            if (root.getLeft() == null && root.getRight() == null){
                root = null;
                return;
            }

            //查找要删除的父节点
            Node parent = findParent(value);
            //删除的是叶子节点
            if (delNode.getLeft() == null && delNode.getRight() == null){
                //判断是父节点的左节点还是右节点
                if (parent.getLeft() != null && parent.getLeft().getData() == value){
                    parent.setLeft(null);
                }else if (parent.getRight() != null && parent.getRight().getData() == value){
                    parent.setRight(null);
                }
            }else if (delNode.getLeft() != null && delNode.getRight() != null){//删除节点有两个子树
                int min = delRightTreeMin(delNode.getRight());
                delNode.setData(min);
            }else {//只有一颗子树
                //如果要删除的节点有左节点
                if (delNode.getLeft() != null){
                    //如果delNode为parent的左节点
                    if (parent != null){
                        if (parent.getLeft().getData() == value){
                            parent.setLeft(delNode.getLeft());
                        }else {
                            //如果delNode为parent的右节点
                            parent.setRight(delNode.getLeft());
                        }
                    }else {
                        root = delNode.getLeft();
                    }
                }else {//如果要删除的节点有右节点
                    //如果delNode为parent的左节点
                    if (parent != null){
                        if (parent.getLeft().getData() == value){
                            parent.setLeft(delNode.getRight());
                        }else {
                            //如果delNode为parent的右节点
                            parent.setRight(delNode.getRight());
                        }
                    }else {
                        root = delNode.getRight();
                    }
                }
            }
        }
    }
}
