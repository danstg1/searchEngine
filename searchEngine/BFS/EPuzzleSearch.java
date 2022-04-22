import java.util.*;

public class EPuzzleSearch extends Search{

    private int[][] board;
    private int[][] tar;

    public EPuzzleSearch(int[][] starting_board, int[][] target){
        board = starting_board;
        tar = target;
    }

    public int[][] getBoard(){
        return board;
    }

    public int[][] getTarget(){
        return tar;
    }
    
}
