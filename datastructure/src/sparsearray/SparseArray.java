package sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始数组 11 * 11
        int chessArr1[][] = new int[11][11];
        //0表示没有棋子，1表示黑子，2表示白子
        chessArr1[2][4] = 1;
        chessArr1[3][6] = 2;
        chessArr1[3][5] = 1;
        //输出原始数组
        for (int row[] : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转化为稀疏数组
        //先遍历二维数组，得到非 0 数据的个数
        int sum = 0;
        for (int arr[]:chessArr1) {
            for (int data : arr) {
                if(data != 0){
                    sum++;
                }
            }
        }

        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;


        //遍历二维数组，将非 0  的值存放到  sparseArr
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for(int j = 0;j < chessArr1[0].length;j++){
                if(chessArr1[i][j] != 0){
                    count++;
                sparseArr[count][0] = i;
                sparseArr[count][1] = j;
                sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("稀疏数组为：");
        for (int arr[] : sparseArr) {
            System.out.printf("%d\t%d\t%d\t",arr[0],arr[1],arr[2]);
            System.out.println();
        }
        System.out.println();
        //将稀疏数组转化为原始二维数组
        //先获取稀疏数组第一行数据，根据数据创建数组

        int chessArr2[][] = new int [sparseArr[0][0]][sparseArr[0][1]];


        //恢复后的原始数组
        for (int row[] : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println();
        //给数组赋值
        for (int i = 1;i < sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int row[] : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
