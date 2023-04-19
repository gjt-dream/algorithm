package linkedlist;

public class Josephu {
    public static void main(String[] args) {
        CircleSingLinkedList circleSingLinkedList = new CircleSingLinkedList();
        circleSingLinkedList.addBoy(5);
        circleSingLinkedList.show();
        circleSingLinkedList.countBoy(2,2,5);
    }
}

class Boy{
    //编号
    private int on;
    //指向下一个节点
    private Boy next;

    public Boy(int on) {
        this.on = on;
    }

    public int getOn() {
        return on;
    }

    public void setOn(int on) {
        this.on = on;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

//创建一个环形链表
class CircleSingLinkedList{
    //创建第一个节点
    Boy first = null;
    //添加小孩节点，构成环形链表
    public void addBoy(int on){
        if(on < 1){
            System.out.println("on的值不正确！");
            return;
        }
        Boy temp = null;//辅助节点
        for (int i = 1; i <= on; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                temp =first;
            }else {
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }
        }

    }
    //遍历当前环形链表
    public void show(){

        if(first == null){
            System.out.println("没有一个小孩。。。");
            return;
        }
        Boy temp = first;
        while (true){
            System.out.println("小孩的编号为："+ temp.getOn());
            if(temp.getNext() == first){//遍历完成
                break;
            }
            temp = temp.getNext();//temp后移
        }
    }

    /**
     *
     * @param startOn 表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums 表示最开始有多少小孩
     */

    public void countBoy(int startOn,int countNum,int nums){
        //先进行数据校验
        if(first == null || startOn < 0 || startOn > nums){
            System.out.println("参数输入有误，请重新输入！");
        }
        //辅助节点
        Boy temp = first;
        while (true){
            if(temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
        //小孩报数前先让first和temp移动到startOn - 1次
        for (int i = 0; i < startOn - 1; i++) {
            first = first.getNext();
            temp = temp.getNext();
        }

        //当小孩报数时，让first和temp同时移动 countNum - 1次
        while (true){
            if (temp == first){//说明只有一个节点
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                temp = temp.getNext();
            }
            //first指向的节点就是出圈的节点
            System.out.println("出圈小孩：" + first.getOn());
            //将first小孩出圈
            first = first.getNext();
            temp.setNext(first);
        }
        System.out.println("最后的小孩编号为：" + temp.getOn());
    }

}