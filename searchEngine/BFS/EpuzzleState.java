import java.lang.reflect.Array;
import java.util.*;

public class EPuzzleState extends SearchState {

    private int[][] board;
    private int t1;
    private int t2;
    private int t3;
    private int t4;
    private int t5;
    private int t6;
    private int t7;
    private int t8;
    private int t9;
    private int[][] target;

    public EPuzzleState(int[][] starting_board, int[][] tar){
        
        target = tar;
        board = starting_board;
        t1 = starting_board[0][0];
        t2 = starting_board[0][1];;
        t3 = starting_board[0][2];;
        t4 = starting_board[1][0];;
        t5 = starting_board[1][1];;
        t6 = starting_board[1][2];;
        t7 = starting_board[2][0];;
        t8 = starting_board[2][1];;
        t9 = starting_board[2][2];;

    }

    public int[][] getBoard(){
        return board;
    }



    public boolean goalPredicate(Search searcher) {

        EPuzzleSearch esearcher = (EPuzzleSearch) searcher;
        int[][] tar = esearcher.getTarget(); // get target board

        boolean matching = true;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++){
                if (!(board[i][j]==tar[i][j])){
                    matching = false;
                }
            }
        }
        
        return (matching);

      }


    public ArrayList<SearchState> getSuccessors(Search searcher){

        EPuzzleSearch esearcher = (EPuzzleSearch) searcher;
        ArrayList<EPuzzleState> plist = new ArrayList<EPuzzleState>(); // the list of tile spaces
        ArrayList<SearchState> slis = new ArrayList<SearchState>();
        
        for (int i=0; i<board.length; i++) {


            for (int j=0; j<board[i].length; j++){


                if ((i-1)>=0){ //Checks Up
                    
                    if (board[i-1][j] == 0){

                        int[][] temp_board = new int[board.length][board[0].length];
                        for (int k=0; k < board.length; k++){
                            for (int l=0; l<board[i].length; l++){
                                temp_board[k][l] = board[k][l];
                            }
                        }
                        temp_board[i-1][j] = board[i][j];
                        temp_board[i][j] = 0;
                        EPuzzleState t = new EPuzzleState(temp_board.clone(), target);
                        plist.add(t);


                    }
                    
                    
                }


                if ((i+1)<=2){ //Checks Down
                    
                    if (board[i+1][j] == 0){ 
                        
                        int[][] temp_board = new int[board.length][board[0].length];
                        for (int k=0; k < board.length; k++){
                            for (int l=0; l<board[i].length; l++){
                                temp_board[k][l] = board[k][l];
                            }
                        }
                        temp_board[i+1][j] = board[i][j];
                        temp_board[i][j] = 0;
                        EPuzzleState t = new EPuzzleState(temp_board.clone(), target);
                        plist.add(t);
                        

                    }
                    
                }

                if ((j-1)>=0){ //Checks Left
                    
                    if (board[i][j-1] == 0){ 

                        int[][] temp_board = new int[board.length][board[0].length];
                        for (int k=0; k < board.length; k++){
                            for (int l=0; l<board[i].length; l++){
                                temp_board[k][l] = board[k][l];
                            }
                        }

                        temp_board[i][j-1] = board[i][j];
                        temp_board[i][j] = 0;
                        EPuzzleState t = new EPuzzleState(temp_board.clone(), target);
                        plist.add(t);
                        

                    }
                    
                }


                
                if ((j+1)<=2){ //Checks Right
                    
                    if (board[i][j+1] == 0){

                        int[][] temp_board = new int[board.length][board[0].length];
                        for (int k=0; k < board.length; k++){
                            for (int l=0; l<board[i].length; l++){
                                temp_board[k][l] = board[k][l];
                            }
                        }

                        temp_board[i][j+1] = board[i][j];
                        temp_board[i][j] = 0;
                        EPuzzleState t = new EPuzzleState(temp_board.clone(), target);
                        plist.add(t);
                        

                    }
                }
                    

            }

        }


        for (EPuzzleState p : plist){
            slis.add(p);

        }
    
        return slis;

    }

    boolean sameState(SearchState n2){
        EPuzzleState n1 = (EPuzzleState)n2;
        return (target == n1.getBoard());

    }

    public String toString(){
        String s1 = "";
        for (int[] line: this.board){
            for (int t: line){
                s1 = s1+ String.valueOf(t);
            }
            
            s1 = s1 + "\n";
            
        }
        return s1;
    }


}
