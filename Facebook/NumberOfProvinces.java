package Facebook;

/*
 * Feature 2 - Find Friend Circles - PROBLEM - Number of Provinces
 */

public class NumberOfProvinces {
      public int findCircleNumber(int[][] isConnected){ 
        int n = isConnected.length;
        int nums = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                nums++;
            }
        }

        return nums;
    }
    
    
    private void dfs(int[][] isConnected, boolean[] visited, int i){
        int n = isConnected.length;
        visited[i] = true;
        for (int j = 0; j < n; j++){
            if(!visited[j] && isConnected[i][j] == 1){
                dfs(isConnected, visited, j);
            }
        }
    }

  
}
