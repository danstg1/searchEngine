import java.util.concurrent.TimeUnit;

public class RunEpuzzleAS {
    public static void main(String[] args) {
        int[][] tar = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int[][] starter = new int[][]{{4, 1, 3}, {7, 2, 5}, {0, 8, 6}};
        //413725086


               
        AEPuzzleSearch searcher = new AEPuzzleSearch (starter, tar);
        SearchState initState = (SearchState) new AEPuzzleState(starter, tar, 0, 0, "H");
        AEPuzzleState initState2 = new AEPuzzleState(starter, tar, 0, 0, "H");
        
        

       //System.out.println(initState2.SearchERM(starter));
       String resb = searcher.runSearch(initState, "AStar");
       System.out.println(resb);


    }
    
}
