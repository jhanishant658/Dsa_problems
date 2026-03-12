import java.util.*;

class Solution {
    class DSU {
        int[] parent;
        int count;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            count = n;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false;
            parent[px] = py;
            count--;
            return true;
        }

        boolean connected() {
            return count == 1;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int low = 1, high = 200_000, ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int minStrength) {
        DSU dsu = new DSU(n);
        int usedUpgrades = 0;

        // Step 1: Add all must edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 1) {
                if (s < minStrength) return false;  // can't satisfy required strength
                if (!dsu.union(u, v)) return false; // cycle in must-include edges
            }
        }

        // Step 2: Optional edges
        List<int[]> candidates = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 0) {
                int withoutUpgrade = s;
                int withUpgrade = s * 2;

                boolean validWithout = withoutUpgrade >= minStrength;
                boolean validWith = withUpgrade >= minStrength;

                if (validWithout || validWith) {
                    candidates.add(new int[]{u, v, validWithout ? 0 : 1});  // 0 = no upgrade, 1 = needs upgrade
                }
            }
        }

        // Sort to use non-upgraded edges first
        candidates.sort(Comparator.comparingInt(a -> a[2]));

        for (int[] e : candidates) {
            int u = e[0], v = e[1], needsUpgrade = e[2];

            if (needsUpgrade == 1 && usedUpgrades >= k) continue;

            if (dsu.union(u, v)) {
                if (needsUpgrade == 1) usedUpgrades++;
            }
        }

        return dsu.connected();
    }
}