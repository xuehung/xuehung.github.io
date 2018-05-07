class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == newColor) {
            return image;
        }
        _helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void _helper(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == newColor || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        _helper(image, sr - 1, sc, oldColor, newColor);
        _helper(image, sr, sc + 1, oldColor, newColor);
        _helper(image, sr + 1, sc, oldColor, newColor);
        _helper(image, sr, sc - 1, oldColor, newColor);
    }
}
