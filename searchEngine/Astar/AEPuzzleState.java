import java.lang.reflect.Array;
import java.util.*;

public class AEPuzzleState extends SearchState {

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
    String ERMType;

    public AEPuzzleState(int[][] starting_board, int[][] tar, int rc,int lc, String Type){
        
        target = tar;
        board = starting_board;
        t1 = starting_board[0][0];
        t2 = starting_board[0][1];
        t3 = starting_board[0][2];
        t4 = starting_board[1][0];
        t5 = starting_board[1][1];
        t6 = starting_board[1][2];
        t7 = starting_board[2][0];
        t8 = starting_board[2][1];
        t9 = starting_board[2][2];
        localCost = lc;
        estRemCost = rc;
        ERMType = Type;

    }

    public int[][] getBoard(){
        return board;
    }

    public boolean board_contains(int[] passed_board, int item){
        boolean found = false;
        for (int i=0; i<passed_board.length; i++){
                if (passed_board[i]==item){
                    found = true;
                }

            }

        return found;

    }

    public int find_index(int[] passed_board, int item){
        int num = 0;
        for (int i=0; i<passed_board.length; i++){
                if (passed_board[i]==item){
                    return num;
                }

                else{
                    num ++;
                }

            }

        return num;

    }



    public boolean goalPredicate(Search searcher) {

        AEPuzzleSearch esearcher = (AEPuzzleSearch) searcher;
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




    public int SearchERM(int[][]tboard){

        int cost = 0;

        if (ERMType=="H"){
            int counter = 1;
            for (int[] line: tboard){
                for (int tile : line){
                    
                    if (counter==9){
                        counter = 0;
                    }

                    if (!(tile==counter)){
                        cost ++;
                        


                    }
                    counter ++;
            }

        }
    }

    if (ERMType == "M"){

        for (int i=0; i<tboard.length; i++){
            for (int j=0; j<tboard[i].length; j++){
                
                int[] correct_pos = new int[2];


                for (int k=0; k<target.length; k++){
                    if (board_contains(target[k], board[i][j])){ //Locates the position the tile should be in

                        correct_pos[0] = k;
                        correct_pos[1] = find_index(target[k], board[i][j]); //Collects the index in an array

                    }

                }
                

                if (i>correct_pos[0]){

                    cost = cost + (i-correct_pos[0]);
                }

                else{

                    cost = cost + (correct_pos[0]-i);
                }

                if (j>correct_pos[1]){

                    cost = cost + (j-correct_pos[1]);
                }

                else{

                    cost = cost + (correct_pos[1]-j);
                }

            
            }
        }
    }

        return cost;

    }
    public ArrayList<SearchState> getSuccessors(Search searcher){

        AEPuzzleSearch esearcher = (AEPuzzleSearch) searcher;
        ArrayList<AEPuzzleState> plist = new ArrayList<AEPuzzleState>(); // the list of tile spaces
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
                        int erm = this.SearchERM(temp_board);
                        AEPuzzleState t = new AEPuzzleState(temp_board.clone(), target, erm, localCost, ERMType);
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
                        int erm = this.SearchERM(temp_board);
                        AEPuzzleState t = new AEPuzzleState(temp_board.clone(), target, erm, localCost, ERMType);
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
                        int erm = this.SearchERM(temp_board);
                        AEPuzzleState t = new AEPuzzleState(temp_board.clone(), target, erm, localCost, ERMType);
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
                        int erm = this.SearchERM(temp_board);
                        AEPuzzleState t = new AEPuzzleState(temp_board.clone(), target, erm, localCost, ERMType);
                        plist.add(t);
                        

                    }
                }
                    

            }

        }


        for (AEPuzzleState p : plist){
            slis.add(p);

        }
    
        return slis;

    }

    boolean sameState(SearchState n2){
        AEPuzzleState n1 = (AEPuzzleState)n2;
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
