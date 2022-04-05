//Author: Toffolon Mattia 2008818

import java.util.PriorityQueue;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) throws Exception {

        //long start = System.currentTimeMillis();

        if(args.length <= 0){
            System.out.println("Il puzzleID non e' stato inserito");
            return;
        }

        try{
        Scanner sc = new Scanner (new FileReader(args[0]));

        int n = sc.nextInt();

        int m[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                m[i][j] = sc.nextInt();
        }
        sc.close();

        Board my_Board = new Board (m);
        String initial_board = my_Board.toString();

        PriorityQueue<Board> game = new PriorityQueue<Board>();
        game.add(my_Board);

        Board temp;
        String output = "";
        while(my_Board.manhattan != 0){
            my_Board = game.poll();

            if(my_Board.manhattan == 0)
                break;

            temp = my_Board.slide_down();
            if(temp != null && my_Board.prev_move != 'U'){
                game.add(temp);
            }

            temp = my_Board.slide_up();
            if(temp != null && my_Board.prev_move != 'D'){
                game.add(temp);
            }
            
            temp = my_Board.slide_right();
            if(temp != null && my_Board.prev_move != 'L'){
                game.add(temp);
            }

            temp = my_Board.slide_left();
            if(temp != null && my_Board.prev_move != 'R'){
                game.add(temp);
            }
        }

        System.out.println(my_Board.moves);
        do{
            output = my_Board.toString() + "\n" + output;
            my_Board = my_Board.prev;
        }
        while(my_Board.prev != null);
        output = initial_board + "\n" + output;
        System.out.println(output);

        //long finish = System.currentTimeMillis();
        //System.out.println("time: " + (finish-start) + " ms");

        }
        catch(IOException e){
            System.out.println(args[0] + " non e' stato trovato");
        }
    }
}
