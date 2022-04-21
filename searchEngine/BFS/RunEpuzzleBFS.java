public class RunEpuzzleBFS {
    public static void main(String[] args) {
        int[][] tar = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int[][] starer = new int[][]{{4, 1, 3}, {7, 2, 5}, {0, 8, 6}};
        
        EPuzzleSearch searcher = new EPuzzleSearch (starer, tar);
        SearchState initState = (SearchState) new EPuzzleState(starer, tar);

    

        String resb = searcher.runSearch(initState, "breadthFirst");
        System.out.println(resb);


    }
    
}
