package main.java.Test;

/**
 * @Desc:
 * @Date: 2019/2/7 12:50  better late than never. 认真思考，不要直接就动手写
 */
public class hasPath_ {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length != rows * cols || str == null || str.length == 0 || str.length > matrix.length)
            return false;
        boolean visited[] = new boolean[matrix.length];
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                if (dfs(matrix, rows, cols, str, i, j, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[] matrix, int rows, int cols, char[] str, int i, int j, int k, boolean[] visited) {
        if (i < 0 || i >= cols || j < 0 || j >= rows || visited[i + j * cols] || matrix[i + j * cols] != str[k])
            return false;
        if (k == str.length - 1) return true;
        visited[i + j * cols] = true;
        if (dfs(matrix, rows, cols, str, i, j - 1, k + 1, visited)
                || dfs(matrix, rows, cols, str, i + 1, j, k + 1, visited)
                || dfs(matrix, rows, cols, str, i, j + 1, k + 1, visited)
                || dfs(matrix, rows, cols, str, i - 1, j, k + 1, visited))
            return true;
        visited[i + j * cols] = false;
        return false;
    }
}

/*
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length != rows * cols
                || str == null || str.length == 0
                || str.length > matrix.length) return false;
        boolean[] visited = new boolean[matrix.length];
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {//每个节点都有可能是起点
                if (dfs(matrix, rows, cols, str, i, j, 0, visited)) return true;
            }//这里多了个k=0来充当str的索引
        }
        return false;

    }

    //递归开始，真是短啊
    private boolean dfs(char[] matrix, int rows, int cols, char[] str, int i, int j, int k,
                        boolean[] visited) {
        if (i < 0 || i >= cols || j < 0 || j >= rows
                || visited[i + j * cols] || matrix[i + j * cols] != str[k])
            return false;
        if (k == str.length - 1) return true;//出口
        visited[i + j * cols] = true;//递
        if (dfs(matrix, rows, cols, str, i, j - 1, k + 1, visited)
                || dfs(matrix, rows, cols, str, i + 1, j, k + 1, visited)
                || dfs(matrix, rows, cols, str, i, j + 1, k + 1, visited)
                || dfs(matrix, rows, cols, str, i - 1, j, k + 1, visited))
            return true;
        visited[i + j * cols] = false;//归
        return false;
    }

*/
