package stack;

import linkedlist.MyLinkedList;

public class MyLinkedStack {
    private Node head;
    private int top;

    public boolean isEmpty(){
        return top == 0;
    }

    public void push(int value){
        Node pushValue = new Node(value);
        pushValue.next = head;
        head = pushValue;
        top++;
    }
    public int pop(){
        Node popValue = head;
        head = popValue.next;
        top--;
        return popValue.data;
    }
    public void output(){
        Node temp = head;
        while (temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedStack myLinkedStack = new MyLinkedStack();

        myLinkedStack.push(4);
        myLinkedStack.push(3);
        myLinkedStack.push(6);
        myLinkedStack.push(9);
        myLinkedStack.push(1);

        myLinkedStack.output();
    }
}


class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}