package algorithm;

public class MaxCommonDivisor {


    /**
     * 辗转相除法
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor1(int a,int b){
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if(big % small == 0){
            return small;
        }
        return getGreatestCommonDivisor1(big % small,small);
    }

    /**
     * 更像减损法
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor2(int a,int b){
        if (a == b){
            return a;
        }
        if ((a&1) == 0 && (b&1) == 0){
            return getGreatestCommonDivisor(a>>1,b>>1)<<1;
        }else if ((a&1) != 0 && (b&1) == 0){
            return getGreatestCommonDivisor(a,b>>1);
        }else if ((a&1) == 0 && (b&1) != 0){
            return getGreatestCommonDivisor(a>>1,b>>1);
        }else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return getGreatestCommonDivisor(big - small,small);
        }
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor(int a,int b){
        if (a == b){
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getGreatestCommonDivisor1(big - small,small);
    }


    public static void main(String[] args) {
        System.out.println(MaxCommonDivisor.getGreatestCommonDivisor1(25, 10));
        System.out.println(MaxCommonDivisor.getGreatestCommonDivisor2(25,10));
        System.out.println(MaxCommonDivisor.getGreatestCommonDivisor(25,10));
    }
}
