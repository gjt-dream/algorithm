package binarytree.huffmancpde;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();

        for (Byte b: bytes) {
            System.out.println(b);
        }

        System.out.println(bytes.length);

        List<CodeNode> nodes = getNodes(bytes);
        System.out.println(nodes);

        CodeNode huffmanTree = createHuffmanTree(nodes);
//        System.out.println(huffmanTree);
        preOrder(huffmanTree);
    }

    public static List<CodeNode> getNodes(byte[] bytes){
        List<CodeNode> codeNodes = new ArrayList<>();
        HashMap<Byte, Integer> counts = new HashMap<>();

        for (Byte b: bytes) {
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b,1);
            }else {
                counts.put(b,count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            codeNodes.add(new CodeNode(entry.getKey(), entry.getValue()));
        }
        return codeNodes;
    }


    public static CodeNode createHuffmanTree(List<CodeNode> codeNodeList){
        while (codeNodeList.size() > 1){
            codeNodeList.sort(Comparator.naturalOrder());

            CodeNode codeNodeLeft = codeNodeList.get(0);
            CodeNode codeNodeRight = codeNodeList.get(1);
            CodeNode parent = new CodeNode(null,codeNodeLeft.getWeight() + codeNodeRight.getWeight());

            parent.setLeft(codeNodeLeft);
            parent.setRight(codeNodeRight);

            codeNodeList.remove(codeNodeLeft);
            codeNodeList.remove(codeNodeRight);

            codeNodeList.add(parent);
        }
        return codeNodeList.get(0);
    }

    public static void preOrder(CodeNode root){
        if (root != null){
            root.preOrder();
        }else{
            System.out.println("哈夫曼树为空！");
        }
    }
}
