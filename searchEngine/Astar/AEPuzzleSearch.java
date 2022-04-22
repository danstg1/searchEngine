import java.util.*;

public class AEPuzzleSearch extends Search{

    private int[][] board;
    private int[][] tar;

    public AEPuzzleSearch(int[][] starting_board, int[][] target){
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
