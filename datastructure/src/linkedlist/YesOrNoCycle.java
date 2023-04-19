package linkedlist;

public class YesOrNoCycle {
    public boolean isCycle(Node head){
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                return true;
            }
        }
        return false;
    }

    public int countCycle(Node head){
        int flag = 0;
        int i = 0;
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                flag++;
            }
            if (flag == 1){
                i++;
            }else if (flag == 2){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(9);
        Node node5 = new Node(2);
        Node node6 = new Node(0);
        Node node7 = new Node(5);
        Node node8 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node4;
        YesOrNoCycle yesOrNoCycle = new YesOrNoCycle();
        boolean cycle = yesOrNoCycle.isCycle(node1);
        System.out.println(cycle);

        int i = yesOrNoCycle.countCycle(node1);
        System.out.println(i);
    }

}

class Node{
    public int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}