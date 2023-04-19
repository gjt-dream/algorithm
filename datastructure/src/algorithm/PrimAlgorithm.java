package algorithm;

import java.util.Arrays;

/**
 * Prim算法求修路问题
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
    }


    /**
     *
     * @param graph
     * @param v
     */
    public void prim(MGraph graph,int v){
        //判断是否访问过
        int visited[] = new int[graph.vertex];

        //把当前节点标记为以访问
        visited[v] = 1;

        //记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 100000;//
        for (int i = 1; i < graph.vertex; i++) {
            for (int j = 0; j < graph.vertex; j++) {
                for (int k = 0; k < graph.vertex; k++) {
                    if (visited[j] == 1 && visited[k] == 0 && graph.weight[j][k] < minWeight){
                        minWeight = graph.weight[j][k];
                        h1 = j;
                        h2 = k;
                    }
                }
            }
            //找到最小边
            System.out.println(graph.data[h1] + "," + graph.data[h2] + "," + minWeight);
            //标记为已经访问
            visited[h2] = 1;

            minWeight = 100000;
        }
    }
}

class MGraph{
    int vertex;//表示图的节点个数

    char[] data;//存放节点数据

    int[][] weight;//存放边，就是邻接矩阵

    public MGraph(int vertex) {
        this.vertex = vertex;
        this.data = new char[vertex];
        this.weight = new int[vertex][vertex];
    }

}
//创建最小生成树
class MinTree{

    /**
     * 创建图的邻接矩阵
     * @param graph 图对象
     * @param vertex 图对应的顶点个数
     * @param data 土地各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph,int vertex,char[] data,int[][] weight){
        for (int i = 0; i < vertex; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertex; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 显示图的方法
     */
    public void showGraph(MGraph graph){
        for (int[] link: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }
}
