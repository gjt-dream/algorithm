package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合

    private int[][] edges;//存储相对应的邻节矩阵

    private int numOfEdges;//表示边的数目

    private boolean isVisited[];

    public Graph(int n) {
        //初始化
        this.vertexList = new ArrayList<String>(n);
        this.edges = new int[n][n];
        this.numOfEdges = 0;
        this.isVisited = new boolean[n];
    }

    /**
     * 插入节点
     * @param vertex
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 表示点在下标为  v1 位置
     * @param v2 表示点在下标为  v2 位置
     * @param weight 表示是否有路径
     */
    public void insertEdges(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 返回节点个数
     * @return
     */
    public int getNumOfVertex(){
        return vertexList.size();
    }

    /**
     * 返回边的条数
     * @return
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 返回下标为 i 的索引
     * @param i
     * @return
     */
    public String getVertexByIndex(int i){
        return vertexList.get(i);
    }

    /**
     * 返回v1、v2 对应的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    /**
     * 显示图
     */
    public void showGraph(){
        for (int arr[] : edges) {
            System.err.println(Arrays.toString(arr));
        }
    }

    /**
     * 得到第一邻接节点的下标
     * @param index
     * @return
     */
    public int getFistNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }


    /**
     * 根据前一个邻接节点的下标获取下一个邻接节点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历算法
     * @param isVisited
     * @param i
     */
    public void dfs(boolean isVisited[],int i){
        //首先我们访问该节点,输出
        System.out.print(getVertexByIndex(i) + "->");
        //将该节设置为已访问
        isVisited[i] = true;
        //查找节点 i 的第一关邻接节点
        int w = getFistNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果节点已经访问过
            w = getNextNeighbor(i,w);
        }
    }

    /**
     * 重载
     */
    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    /**
     * 广度优先遍历
     * @param isVisited
     * @param i
     */
    private void bfs(boolean isVisited[],int i){
        int u;//表示队列头所对应的下标
        int w;//邻接节点

        //记录节点访问的顺序
        LinkedList<Object> queue = new LinkedList<>();

        System.out.print(getVertexByIndex(i) + "->");

        isVisited[i] = true;

        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列的头节点下标
            u = (Integer) queue.removeFirst();

            //得到第一个邻接节点的下标
            w = getFistNeighbor(u);
            while (w != -1){
                //判断是否访问过
                if (!isVisited[w]){
                    System.out.print(getVertexByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }

                //以u为前驱点，以w后面的下一个邻接点
                w = getNextNeighbor(u,w);
            }
        }
    }

    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Graph graph = new Graph(n);
        String vertex[] = {"A","B","C","D","E"};
        for (String a : vertex){
            graph.insertVertex(a);
        }

        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);
        graph.showGraph();

        System.out.println();

//        graph.dfs();
        graph.bfs();
    }
}
