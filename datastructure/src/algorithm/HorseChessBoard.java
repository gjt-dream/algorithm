package algorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

//马踏棋盘
public class HorseChessBoard {
    private static int X;//棋盘的列数
    private static int Y;//棋盘的行数
    //标记棋盘的各个位置是否被访问过
    private static boolean visited[];
    //是否棋盘的所有位置都被访问
    private static boolean finished;
    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        int[][] chessBoard = new int[Y][X];
        visited = new boolean[X * Y];
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard,row -1,column - 1,1);
        long end = System.currentTimeMillis();
        System.out.println(end -start);


        for (int rows[]: chessBoard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 完成骑士周游问题的算法
     * @param chessBoard 棋盘
     * @param row 初始行 0开始
     * @param column 初始列 0开始
     * @param step 第几步
     */
    public static void traversalChessBoard(int [][] chessBoard,int row,int column,int step){
        chessBoard[row][column] = step;
        visited[row * X + column] = true;//标记已经访问
        //获取当前位置可以走的下一个位置集合
        ArrayList<Point> nextList = next(new Point(column, row));
        sort(nextList);
        while (!nextList.isEmpty()){
            Point nextPoint = nextList.remove(0);//取出下一个可以走的位置
            if (!visited[nextPoint.y * X + nextPoint.x]){
                traversalChessBoard(chessBoard,nextPoint.y, nextPoint.x, step + 1);
            }
        }
        if (step < X * Y && !finished){
            chessBoard[row][column] = 0;
            visited[row * X + column] = false;
        }else {
            finished =true;
        }
    }

    /**
     * 根据当前位置（Point对象），计算马还能走哪些位置（Point），并放入到一个集合，最多有8个点
 jie'he@param point
     * @return
     */
    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> points = new ArrayList<>();

        Point p = new Point();

        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0){
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0){
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 2) >= 0){
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0){
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y){
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y){
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y){
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y){
            points.add(new Point(p));
        }

        return points;
    }

    /**
     *使用贪心算法优化
     * 根据当前这一步的所有的下一步的选择位置，进行非递减排序，减少回溯
     * @param ps
     */
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int size1 = next(o1).size();
                int size2 = next(o2).size();
                if (size1 < size2){
                    return -1;
                }else if (size1 == size2){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }
}
