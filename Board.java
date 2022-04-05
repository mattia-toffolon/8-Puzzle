//Author: Toffolon Mattia 2008818

public class Board implements Comparable<Board>{

    public int moves;
    public int[][] b;
    public int zero_x;
    public int zero_y;
    public Board prev;
    public char prev_move;
    public int manhattan;

    public Board(int[][] tiles){
        moves=0;
        prev = null;
        b = tiles;
        for(int i=0; i<tiles.length; i++){
            for(int j=0; j<tiles.length; j++){
                if(b[i][j] == 0){
                    zero_x = i;
                    zero_y = j;
                }
            }
        }
        manhattan = manhattan();
    }

    public Board(int[][] arg, int arg_moves, int arg_zero_x, int arg_zero_y, Board prev_b, char latest_move){
        moves=arg_moves;
        prev = prev_b;
        prev_move = latest_move;
        zero_x = arg_zero_x;
        zero_y = arg_zero_y;
        b = arg;
        manhattan = manhattan();
    }

    public String toString(){
        String ret = "";
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b.length; j++){
                ret += (b[i][j] + " ");
            }
        }
        return ret;
    }

    public int manhattan(){
        int ret=0;
        int x_diff=0;
        int y_diff=0;
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b.length; j++){
                if(b[i][j]==0)
                    continue;

                x_diff = j - (b[i][j]-1)%b.length;
                if(x_diff<0)
                    x_diff = -x_diff;
                
                y_diff = i - (b[i][j]-1)/b.length;
                if(y_diff<0)
                    y_diff = -y_diff;

                ret += (x_diff + y_diff);
                x_diff=0;
                y_diff=0;
            }
        }
        return ret;
    }

    public int compareTo (Board arg){
        if((moves+manhattan) > arg.moves+arg.manhattan)
            return 1;
        else if(moves+manhattan < arg.moves+arg.manhattan)
            return -1;
        else
            return 0;
    }
    
    public Board slide_down(){
        if(zero_x == 0)
            return null;
        int[][] matrix = new int[b.length][b.length];
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b.length; j++)
                matrix[i][j] = b[i][j];
        }
        matrix[zero_x][zero_y] = matrix[zero_x-1][zero_y];
        matrix[zero_x-1][zero_y] = 0;

        return new Board(matrix, moves+1, zero_x-1, zero_y, this, 'D');
    }

    public Board slide_up(){
        if(zero_x == b.length-1)
            return null;
        int[][] matrix = new int[b.length][b.length];
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b.length; j++)
                matrix[i][j] = b[i][j];
        }
        matrix[zero_x][zero_y] = matrix[zero_x+1][zero_y];
        matrix[zero_x+1][zero_y] = 0;

        return new Board(matrix, moves+1, zero_x+1, zero_y, this, 'U');
    }

    public Board slide_left(){
        if(zero_y == b.length-1)
            return null;
        int[][] matrix = new int[b.length][b.length];
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b.length; j++)
                matrix[i][j] = b[i][j];
        }
        matrix[zero_x][zero_y] = matrix[zero_x][zero_y+1];
        matrix[zero_x][zero_y+1] = 0;

        return new Board(matrix, moves+1, zero_x, zero_y+1, this, 'L');
    }

    public Board slide_right(){
        if(zero_y == 0)
            return null;
        int[][] matrix = new int[b.length][b.length];
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b.length; j++)
                matrix[i][j] = b[i][j];
        }
        matrix[zero_x][zero_y] = matrix[zero_x][zero_y-1];
        matrix[zero_x][zero_y-1] = 0;

        return new Board(matrix, moves+1, zero_x, zero_y-1, this, 'R');
    }
}
