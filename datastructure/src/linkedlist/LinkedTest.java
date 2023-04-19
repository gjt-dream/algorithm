package linkedlist;

public class LinkedTest {
    public static int sun;
    private Node head;
    private Node last;

    private int size;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            sun++;
            this.data = data;
        }
    }
    private Node get(int index){
        if(index < 0 || size <= index){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp = head;
        for(int i = 0;i < index;i++ ){
            temp = temp.next;
        }
        return temp;
    }
    public void insert(int data,int index){
        if(index < 0 || size < index){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node indexNode = new Node(data);
        if(size == 0){
            //空链表
            head = indexNode;
            last = indexNode;
        }else if(index == 0){
            //插入头部
            indexNode.next = head;
            head = indexNode;
        }else if(index == size){
            //插入尾部
            last.next = indexNode;
            last = indexNode;
        }else {
            //插入中间
            Node prevNode = get(index - 1);
            indexNode.next = prevNode.next;
            prevNode.next = indexNode;
        }
        size++;
    }
    public Node delete(int index){
        if(index < 0 || size < index){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node deleteNode = null;
        if(index == 0){
            //删除头节点
            deleteNode = head;
            head = head.next;
        }else if(index == size - 1){
            //删除尾节点
            Node prevNode = get(index - 1);
            deleteNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            deleteNode = prevNode.next;
            prevNode.next = nextNode;
        }
        LinkedTest.sun--;
        size--;
        return deleteNode;
    }

    public void output(){
        Node temp = head;
        while (temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int getLength(){
        int length = 0;
        Node temp = head;
        if(head == null){
            return 0;
        }else {
            while (temp != null){
                length++;
                temp = temp.next;
            }
        }
        return length;
    }

    public void reverseList(LinkedTest linkedTest){
        int count =size-1;
        while (count != 0) {
//            System.out.println(linkedTest.last.data);
            insert(linkedTest.last.data, 0);
            delete(size - 1);
            count--;
//            System.out.println(linkedTest.last.data);
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedTest linkedTest = new LinkedTest();
        linkedTest.insert(3,0);
        linkedTest.insert(7,1);
        linkedTest.insert(9,2);
        linkedTest.insert(5,3);
        linkedTest.insert(6,4);
//        linkedTest.delete(0);
//        linkedTest.delete(1);
        linkedTest.output();
        System.out.println();

//        System.out.println(LinkedTest.sun);
//        System.out.println(linkedTest.last);
//
//        System.out.println(linkedTest.getLength());

        linkedTest.reverseList(linkedTest);
        linkedTest.output();
    }

}
