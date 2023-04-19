package binarytree.huffmantree;

import java.util.*;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};

        HuffmanNode huffmanTree = createHuffmanTree(arr);
//        System.out.println(huffmanTree);


        preOrder(huffmanTree);
    }

    /**
     * 创建哈夫曼树
     * @param array
     * @return
     */
    public static HuffmanNode createHuffmanTree(int array[]){

        ArrayList<HuffmanNode> nodeArrayList= new ArrayList<HuffmanNode>();

        for (int data:array) {
            nodeArrayList.add(new HuffmanNode(data));
        }
//        Collections.sort(nodeArrayList);
//        nodeArrayList.sort(Comparator.naturalOrder());

        while (nodeArrayList.size() > 1){
            //从小到大排序
            Collections.sort(nodeArrayList);

            //取出最小节点
            HuffmanNode leftNode = nodeArrayList.get(0);
            //取出第二小节点
            HuffmanNode rightNode = nodeArrayList.get(1);
            //构建一个新的二叉树
            HuffmanNode parent  = new HuffmanNode(leftNode.getData() + rightNode.getData());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);

            nodeArrayList.remove(leftNode);
            nodeArrayList.remove(rightNode);

            nodeArrayList.add(parent);
        }
        return nodeArrayList.get(0);
    }

    public static void preOrder(HuffmanNode node){
        if (node != null){
            node.preOrder();
        }else {
            System.out.println("树为空！");
        }
    }
}
