package Graphs;


import java.util.LinkedList;
import java.util.Queue;

class connectedIslands {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int cnt = 0;


        for(int i=0;i<n;i++){
            for(int j= 0 ;j<m;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    cnt++;
                    bfs(i, j, visited, grid);
                }
            }
        }

        return cnt;




    }

    private void bfs(int i, int j, boolean[][] vis,
                     char[][] grid) {

        vis[i][j] = true;

        Queue<int[]> q =  new LinkedList<>();

        q.add(new int[]{i,j});


        while(!q.isEmpty()){

            int[] current = q.poll();

            int row = current[0];
            int column = current[1];

            int n = grid.length;
            int m = grid[0].length;

            for(int delRow = -1 ; delRow <=1; delRow++){
                for(int delCol = -1 ; delCol <=1; delCol++){

                    int newRow =  row+delRow;
                    int newColumn =  column+delCol;

                    if(newRow>= 0 && newRow<n && newColumn>= 0 && newColumn<m && !vis[newRow][newColumn] && grid[newRow][newColumn] == '1' ){

                        vis[newRow][newColumn] = true;
                        q.add(new int[]{newRow,newColumn});
                    }




                }
            }

        }

    }

    private void dfs(int i, int j, boolean[][] vis,char[][] grid) {

        vis[i][j] = true;

        int n = grid.length;
        int m = grid[0].length;

        for(int delRow = -1 ; delRow <=1; delRow++){
            for(int delCol = -1 ; delCol <=1; delCol++){

                int newRow =  i+delRow;
                int newColumn =  j+delCol;

                if(newRow>= 0 && newRow<n && newColumn>= 0 && newColumn<m && !vis[newRow][newColumn] && grid[newRow][newColumn] == '1' ){

                    vis[newRow][newColumn] = true;
                    dfs(newRow,newColumn,vis,grid);
                }

            }
        }

    }





}


