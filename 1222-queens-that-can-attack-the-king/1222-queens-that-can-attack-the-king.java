class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] seen = new boolean[8][8];
        for(int[] queen: queens){
            seen[queen[0]][queen[1]] = true;
        }
        
        int[] directions = {-1,0,1};
        for(int dx: directions){
            for(int dy: directions){
                if(dx == 0 && dy == 0) continue;
                
                int x = king[0];
                int y = king[1];
                
                while(x+dx >= 0 && x+dx < 8 && y+dy >=0 && y+dy < 8){
                    x+=dx;
                    y+=dy;
                   
                    if(seen[x][y]){
                        ans.add(Arrays.asList(x,y));
                        break;
                    }
                }
            }
        }
        return ans;
    }
}