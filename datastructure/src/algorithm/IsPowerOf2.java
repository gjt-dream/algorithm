package algorithm;

public class IsPowerOf2 {
    public static boolean isPowerOf(int num){
        return (num&(num-1)) == 0;
    }


    public static void main(String[] args) {
        System.out.println(IsPowerOf2.isPowerOf(64));
    }
}
