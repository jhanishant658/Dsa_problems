class Solution{
public int robotSim(int[] commands, int[][] obstacles) {
    // 1. Store obstacles as encoded longs for O(1) lookup
    Set<String> obstacleSet = new HashSet<>();
    for (int[] obs : obstacles) {
        
        obstacleSet.add(obs[0] +"," + obs[1]);
    }

    // 2. Direction vectors: North, East, South, West
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    int x = 0, y = 0, dir = 0;
    int maxDistSq = 0;

    for (int cmd : commands) {
        if (cmd == -1) { // Turn Right
            dir = (dir + 1) % 4;
        } else if (cmd == -2) { // Turn Left
            dir = (dir + 3) % 4;
        } else {
            // Move step-by-step to catch obstacles
            for (int i = 0; i < cmd; i++) {
                int nextX = x + dx[dir];
                int nextY = y + dy[dir];
                
                // Check obstacle
                String code = nextX + "," + nextY ; 
                if (obstacleSet.contains(code)) break;
                
                x = nextX;
                y = nextY;
                maxDistSq = Math.max(maxDistSq, x * x + y * y);
            }
        }
    }
    return maxDistSq;
}
}