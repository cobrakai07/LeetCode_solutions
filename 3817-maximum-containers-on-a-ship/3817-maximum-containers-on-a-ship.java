class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int canBePlaced= maxWeight/w;
        int totalPlace=n*n;
        return totalPlace>canBePlaced?canBePlaced: totalPlace;
    }
}