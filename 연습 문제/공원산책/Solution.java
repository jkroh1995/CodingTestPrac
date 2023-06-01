class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        String[][] map = new String[park.length][park[0].length()];
        int row = 0;
        int col = 0;

        for (int i = 0; i < park.length; i++) {
            String[] arr = park[i].split("");
            for (int j = 0; j < arr.length; j++) {
                map[i][j] = arr[j];
                if(map[i][j].equals("S")){
                    row = i;
                    col = j;
                }
            }
        }

        for (String route : routes) {
            String[] arr = route.split(" ");
            String direction = arr[0];
            int move = Integer.parseInt(arr[1]);

            boolean isBlock = false;

            if (direction.equals("E")) {
                if (col + move < map[0].length) {
                    for (int i = col; i <= col+move; i++) {
                        if(map[row][i].equals("X")){
                            isBlock = true;
                            break;
                        }
                    }

                    if(!isBlock){
                        col += move;
                    }
                }
                continue;
            }

            if (direction.equals("W")) {
                if (col - move >= 0) {
                    for (int i = col; i >= col-move; i--) {
                        if(map[row][i].equals("X")){
                            isBlock = true;
                            break;
                        }
                    }

                    if(!isBlock){
                        col -= move;
                    }
                }
                continue;
            }
            if (direction.equals("S")) {
                if (row + move < map.length) {
                    for (int i = row; i <= row+move; i++) {
                        if(map[i][col].equals("X")){
                            isBlock = true;
                            break;
                        }
                    }

                    if(!isBlock){
                        row += move;
                    }
                }
                continue;
            }
            if (row - move >= 0) {
                for (int i = row; i >= row-move; i--) {
                    if(map[i][col].equals("X")){
                        isBlock = true;
                        break;
                    }
                }

                if(!isBlock){
                    row -= Integer.parseInt(arr[1]);
                }
            }
        }

        answer[0] = row;
        answer[1] = col;
        return answer;
    }
}
