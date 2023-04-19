package algorithm;

import java.util.Arrays;

public class DijkstraAlgorithm {

    static final int N =65535;
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        matrix[0] = new int[]{N,5,7,N,N,N,2};
        matrix[1] = new int[]{5,N,N,9,N,N,3};
        matrix[2] = new int[]{7,N,N,N,8,N,N};
        matrix[3] = new int[]{N,9,N,N,N,4,N};
        matrix[4] = new int[]{N,N,8,N,N,5,4};
        matrix[5] = new int[]{N,N,N,4,5,N,6};
        matrix[6] = new int[]{2,3,N,N,4,6,N};

        //创建图对象
        Graph graph = new Graph(vertex,matrix);
        graph.showGraph();

        graph.dis(6);

        graph.showDijkstra();
    }
}

class VisitedVertex{
    public int[] already_arr;//记录个顶点是否访问过，1表示已经访问过，0表示为访问过
    public int[] pre_visited;//每个下标对应的值为前一个顶点下标，会动态更新
    public int[] dis;//记录出发顶点到其他所有顶点的距离，比如G到其他顶点的距离，会动态更新，求的最短距离就会放到dis

    /**
     *
     * @param length 表示顶点个数
     * @param index 出发点对应下标
     */
    public VisitedVertex(int length,int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];

        //初始化数组
        Arrays.fill(dis,65535);

        already_arr[index] = 1;
        //设置出发点的访问距离为0
        dis[index] = 0;
    }

    /**
     * 判断是否访问过
     * @param index
     * @return
     */
    public boolean in(int index){
        return already_arr[index] == 1;
    }


    /**
     * 更新出发顶点到index的距离
     * @param index
     * @param len
     */
    public void updateDis(int index,int len){
        dis[index] = len;
    }

    /**
     * 更新pre这个顶点的前驱顶点为index
     * @param pre
     * @param index
     */
    public void updatePre(int pre,int index){
        pre_visited[pre] = index;
    }

    /**
     * 返回出发点到index顶点的距离
     * @param index
     * @return
     */
    public int getDis(int index){
        return dis[index];
    }

    public int updateArr(){
        int min = 65535,index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }


    public void show(){
        System.out.println("------------------------------");
        for (int i : already_arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i : pre_visited) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i : dis) {
            System.out.print(i + "\t");
        }
    }
}

class Graph{
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    VisitedVertex visitedVertex;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示图
    public void  showGraph(){
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void showDijkstra(){
        visitedVertex.show();
    }

    /**
     * Dijkstra算法实现
     * @param index 出发顶点对应的下标
     */
    public void dis(int index){
        visitedVertex = new VisitedVertex(vertex.length, index);
        update(index);
        for (int i = 1; i < vertex.length; i++) {
            int arr = visitedVertex.updateArr();
            update(arr);
        }
    }

    /**
     * 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶顶点
     * @param index
     */
    private void update(int index){
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            len = visitedVertex.getDis(index) + matrix[index][i];

            if (!visitedVertex.in(i) && len < visitedVertex.getDis(i)){
                visitedVertex.updatePre(i,index);
                visitedVertex.updateDis(i,len);
            }
        }
    }
}