class Solution {
    public int[] solution(String[] wallpaper) {

        int left = wallpaper[0].length();
        int right = 0;
        int top = wallpaper.length;
        int bottom = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if(isFile(j, wallpaper[i])){
                    if(isLeft(left, j)){
                        left=j;
                    }
                    if(isRight(right, j)){
                        right=j;
                    }
                    if(isBottom(bottom, i)){
                        bottom=i;
                    }
                    if(isTop(top, i)){
                        top=i;
                    }
                }
            }
        }

        return new int[]{top, left, bottom+1, right+1}; // 아이콘의 우하단까지 드래그 해야 한다.
    }

    private static boolean isTop(int top, int i) {
        return i < top;
    }

    private static boolean isBottom(int bottom, int i) {
        return i > bottom;
    }

    private static boolean isRight(int right, int j) {
        return j > right;
    }

    private static boolean isLeft(int left, int j) {
        return j < left;
    }

    private static boolean isFile(int j, String wallpaper) {
        return wallpaper.charAt(j) == '#';
    }
}
