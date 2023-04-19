package algorithm;


/**
 * 分治算法
 */
public class HanoiTower {

    public static void main(String[] args) {
        long star = System.currentTimeMillis();
        hanoiTower(20,'A','B','C');
        long end = System.currentTimeMillis();
        System.out.println(end -star);
    }

    /**
     * 使用分治算法实现汉诺塔的移动
     * @param num 盘的数量
     * @param a A 塔
     * @param b B 塔
     * @param c C 塔
     */
    public static void hanoiTower(int num,char a,char b,char c){
        //如果只有一个盘
        if (num == 1){
            System.out.println("第1个盘从" + a + "->" + c);
        }else {
            //大于2 我们总是可以看做两个盘 1 ，最下边一个盘2 ，
            //先把最上边的所有盘移动 A -> B ，移动过程会使用c
            hanoiTower(num - 1,a ,c ,b);
            //把最下面的盘A->C
            System.out.println("第" + num + "个盘从" + a + "->" + c);

            hanoiTower(num -1 ,b,a,c);
        }
    }
}
