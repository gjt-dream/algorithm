package linkedlist;

public class DoubleLinked {


}
//创建一个HeroNode的类，每个HeroNode的对象都是一个节点
class HeroNode{
    //编号
    public int on;
    //
    public String name;
    //代号
    public String nickname;
    //指向下一个节点
    public HeroNode next;
    //指向前一个节点
    public HeroNode pre;

    public HeroNode() {

    }

    public HeroNode(int on, String name, String nickname) {
        this.on = on;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "on=" + on +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

class DoubleLinkedList{
   private HeroNode heroNode = new HeroNode();
}