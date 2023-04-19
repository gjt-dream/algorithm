package algorithm;

public class EightQueen {
    //定义有多少皇后
    int max = 10;
    //保存皇后放置的位置
    int[] array = new int[max];


    static int count = 0;
    static int judgeCount = 0;
    /**
     * 查看当前我们放置的第n个皇后，就去检测该皇后是否和前面的皇后冲突
     * @param n 第n个皇后
     * @return
     */
    public boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //array[i] == array[n],表示和前面的皇后冲突
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 放置第n个皇后
     * @param n
     */
    public void check(int n){
        if (n == max){
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0;i < max;i++){
            //先把当前皇后放入第一列
            array[n] = i;
            //判断当放置第n个皇后到第i列时，是否冲突
            if (judge(n)){
                //不冲突接着放下一个皇后
                check(n + 1);
            }
        }
    }

    public void print(){
        count++;
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        EightQueen queen = new EightQueen();
        long start = System.currentTimeMillis();
        queen.check(0);
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        long sum = end - start;
        System.out.printf("一共有%d种算法",count);
        System.out.printf("\n判断冲突%d次",judgeCount);

        System.out.println();
        System.out.println("运算时间为：" + sum);
    }
}
