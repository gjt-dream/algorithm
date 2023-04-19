package graph;

public class Test {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2);

        try {
            int test = Test();
            System.out.println(test);
        } catch (Exception e) {

            System.out.println("成功抛出！");
        }

    }
    public static int Test() throws Exception {
        int i1 = 10;
        try {
            i1 = i1 / 0;
//            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常了！");
//            throw new RuntimeException();
        } finally {
            System.out.println("我进来了喔！");
        }

        System.out.println("我出来了喔！");
        return i1;
    }
}
