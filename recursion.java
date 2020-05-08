// package recursion_revision;
import java.util.Arrays;
public class recursion {
    public static void main(String[] args){
        solve();
    }
    
    public static int coinchangePermutaion_INF(int[] arr, int tar, String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int ele=0;ele<arr.length;ele++){
            if(tar-arr[ele]>=0){
                count+= coinchangePermutaion_INF(arr, tar-arr[ele], arr[ele] + " ");
            }
        }
        return count;
    }

    public static int coinchangeCombinations_INF(int[] arr,int lidx, int tar){
        if(tar==0){
            return 1;
        }
        int count = 0;
        
        for(int i = lidx; i<arr.length; i++){
            if(tar-arr[i]>=0){
                count+= coinchangeCombinations_INF(arr, i, tar-arr[i]);
            }
        }
        return count;
    }

    public static int coinchangeCombinations(int[] arr, int lidx, int tar){
        if(tar==0){
            return 1;
        }
        int count = 0;
        
        for(int i = lidx; i<arr.length; i++){
            if(tar-arr[i]>=0){
                count+= coinchangeCombinations(arr, i+1, tar-arr[i]);
            }
        }
        return count;

    }

    public static int coinchangePermutaion(int [] arr, int tar){
        if(tar==0){
            return 1;
        }
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            if(arr[i]>0 && tar-arr[i]>=0){
                arr[i] = -arr[i]; // mark current index
                count+=coinchangePermutaion(arr, tar-temp);
                arr[i] = -arr[i]; // unmark current  index
            }
        }
        return count;
    }

    public static int coinChangePermutation_INF_subseq(int[] arr,int lidx, int tar, String ans){
        if(lidx==arr.length || tar==0){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
    
         int count=0;
         if(tar-arr[lidx]>=0)
             count+=coinChangePermutation_INF_subseq(arr,0,tar-arr[lidx],ans+ arr[lidx]+" ");
         count+=coinChangePermutation_INF_subseq(arr,lidx+1,tar,ans);
         
         return count;
    }

    
    public static int coinChangePermutation_subseq(int[] arr,int lidx, int tar, String ans){
        if(lidx==arr.length || tar==0){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
    
         int count=0;
        if (arr[lidx] > 0 && tar - arr[lidx] >= 0 ){
            int temp = arr[lidx];
            arr[lidx] = -arr[lidx];
            count+=coinChangePermutation_subseq(arr,0,tar-temp,ans + temp+" ");
            arr[lidx] = -arr[lidx];
        }
            count+=coinChangePermutation_subseq(arr,lidx+1,tar,ans);
         
         return count;
    }

    
    public static int coinChangeCombination_INF_subseq(int[] arr, int lidx, int tar, String ans){
    if(lidx==arr.length || tar==0){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        return 0;
    }

     int count=0;
     if(tar-arr[lidx]>=0)
         count+=coinChangeCombination_INF_subseq(arr,lidx,tar-arr[lidx],ans+ arr[lidx]+" ");
     count+=coinChangeCombination_INF_subseq(arr,lidx+1,tar,ans);
     
     return count;
    }


    public static int coinChangeCombination_subseq(int[] arr, int lidx, int tar, String ans){
       if(lidx==arr.length || tar==0){
           if(tar==0){
               System.out.println(ans);
               return 1;
           }
           return 0;
       }

        int count=0;
        if(tar-arr[lidx]>=0)
            count+=coinChangeCombination_subseq(arr,lidx+1,tar-arr[lidx],ans+ arr[lidx]+" ");
        count+=coinChangeCombination_subseq(arr,lidx+1,tar,ans);
        
        return count;
    }


    public static void coinChange(){
        int[] arr = {2,3,5,7};
        int tar = 10;
        String ans = "";
        int res = 0;
        
        // ans = coinchangeCombinations_INF(arr, 0, tar);
        // ans = coinchangeCombinations(arr, 0, tar);
        // res = coinchangePermutaion(arr, tar);
        // System.out.println(coinchangePermutaion_INF(arr, tar, " "));
        // System.out.println(coinChangeCombination_subseq(arr, 0, tar, ans));
 
 
 
 
        // System.out.println(coinChangeCombination_subseq(arr,0,tar," "));
        // System.out.println(coinChangeCombination_INF_subseq(arr, 0, tar," "));
        // System.out.println(coinChangePermutation_INF_subseq(arr, 0, tar," "));
        // System.out.println(coinChangePermutation_subseq(arr, 0, tar," "));

        // int[] coins = {1,1,1,1,1};
        // boolean[] vis = {false,false,false,false,false};
        // System.out.println(queenCombination(vis, 0, 0, 3, " "));
        // System.out.println(queenPermutation(vis, 0, 0, 3, ans));


        // boolean[][] boxes=new boolean[4][4];
        // int tnq = 4;

    }




    public static int queenCombination(boolean[] boxes, int bn, int qpsf, int tnq, String ans){
        if (qpsf == tnq)
        {
            System.out.println(ans);;
            return 1;
        }
        int count = 0;
        for (int i = bn; i < boxes.length; i++)
        {
            count += queenCombination(boxes, i + 1, qpsf + 1, tnq, ans + "b" + i + "q" + qpsf + " ");
        }
        return count;
    }



    public static int queenPermutation(boolean[] boxes, int bn, int qpsf, int tnq, String ans){
        if (qpsf == tnq)
        {
            System.out.println(ans);;
            return 1;
        }
        int count = 0;
        
        for (int i = bn; i < boxes.length; i++)
        {
            if(!boxes[i]){
                boxes[i] = true;
                count += queenPermutation(boxes, 0, qpsf + 1, tnq, ans + "b" + i + "q" + qpsf + " ");

                boxes[i] = false;
            }
        }
        return count;
    }

    public static int queensCombination2D(boolean[][] rooms, int room, int tnq, String ans){ // qpsf: queen place so far.
        if (tnq==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int r = room; r < rooms.length*rooms[0].length; r++){
            int x = r / rooms[0].length;
            int y = r % rooms[0].length;
            count += queensCombination2D(rooms, r + 1,tnq-1, ans + "(" + x + ", " + y + ") ");
        }
        return count;
    }

    public static int queensPermutation2D(boolean[][] boxes,int tnq, String ans) // qpsf: queen place so far.
    {
        if (tnq==0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int r = 0; r < boxes.length; r++){
            int x = r / boxes[0].length;
            int y = r % boxes[0].length;

            if (!boxes[x][y])
            {
                boxes[x][y] = true;
                count += queensPermutation2D(boxes,tnq-1,  ans + "(" + x + ", " + y + ") ");
                boxes[x][y] = false;
            }
        }
        return count;
    }

    // Nqueen


    public static boolean isValid(boolean[][] rooms, int r, int c){

        int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1}};
        for(int d=0;d<dir.length;d++){
            for(int rad=1;rad<rooms.length;rad++){
                int x = r+rad*dir[d][0];
                int y = c+rad*dir[d][1];

                if(x>=0 && y>=0 && x<rooms.length && y<rooms[0].length){
                    if(rooms[x][y]) return false;
                }
                else break;
            }
        }
        return true;

    }
    public static int Nqueen_01(boolean[][] rooms, int lpsf, int tnq, String ans){ // qpsf: queen place so far.
        if (tnq==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int r = lpsf; r < rooms.length*rooms[0].length; r++){
            int x = r / rooms[0].length;
            int y = r % rooms[0].length;
            if(isValid(rooms, x, y)){
                rooms[x][y] = true;
                count += Nqueen_01(rooms, r + 1,tnq-1, ans + "(" + x + ", " + y + ") ");
                rooms[x][y] = false;
            }
            
        }
        return count;
    }

    public static int Nqueen_02(boolean[][] board, int idx, int tnq, String ans) // qpsf: queen place so far.
{
    if (tnq==0 || idx==board.length*board[0].length)
    {
        if(tnq==0){
           System.out.println(ans);
           return 1;
        }
        return 0;
    }

    int count = 0;
    
    int x = idx / board[0].length;
    int y = idx % board[0].length;
    if(isValid(board,x,y)){
        board[x][y]=true;
        count += Nqueen_02(board, idx + 1,tnq-1, ans + "(" + x + ", " + y + ") ");
        board[x][y]=false;
    }
    count += Nqueen_02(board, idx + 1,tnq, ans);
    return count;
}


// nqueen optimized

static boolean[] ROW;
static boolean[] COL;
static boolean[] DIAG;
static boolean[] ADIAG;

public static int Nqueen_05(int n, int m,  int idx, int tnq, String ans){ // qpsf: queen place so far.
    if (tnq==0){
        System.out.println(ans);
        return 1;
    }

    int count = 0;

    for (int r = idx; r < n*m; r++){
        int x = r / m;
        int y = r % m;
        if(!ROW[x] && !COL[y] && !DIAG[x+y] && !ADIAG[x-y+m-1]){
            ROW[x]=true; COL[y]=true; DIAG[x+y]=true; ADIAG[x-y+m-1] = true;
            count += Nqueen_05(n,m,r+1,tnq-1, ans + "(" + x + ", " + y + ") ");
            ROW[x]=false; COL[y]=false; DIAG[x+y]=false; ADIAG[x-y+m-1] = false;
        }
    }
    return count;
}

// nqueen using bits


static int row=0;
static int col=0;
static int diag=0;
static int adiag=0;

public static int Nqueen_06(int n,int m,int idx,int tnq, String ans) // qpsf: queen place so far.
{
    if (tnq==0)
    {
        System.out.println(ans);
        return 1;
    }

    int count = 0;
    for (int r = idx; r < n*m; r++){
        int x = r / m;
        int y = r % m;

        if ((row & (1<<x))==0 && (col & (1<<y))==0 && (diag & (1<<(x+y)))==0 && (adiag & (1<<(x-y + m - 1)))==0)
        {
            row^=(1<<x);
            col^=(1<<y);
            diag^=(1<<(x+y));
            adiag^=(1<<(x-y+m-1));

            count += Nqueen_06(n,m,r+1,tnq-1, ans + "(" + x + ", " + y + ") ");
            
            row^=(1<<x);
            col^=(1<<y);
            diag^=(1<<(x+y));
            adiag^=(1<<(x-y+m-1));
        }
    }
    return count;
}


public static void Nqueen(){
    // boolean[][] boxes=new boolean[4][4];
    // int tnq = 4;
    // String ans = " ";
    
    // System.out.println(Nqueen_02(boxes,0, tnq, ans));

    // int n = 4;
    // ROW = new boolean[n];
    // COL = new boolean[n]; 
    // DIAG = new boolean[n+n-1];
    // ADIAG = new boolean[n+n-1];

    int n = 4;
    
    
    // System.out.println(Nqueen_05(n, n, 0,  n, " "));
    System.out.println(Nqueen_06(n, n, 0,  n, " "));

}

    public static boolean isValid_KT(boolean[][] board, int r, int c){
        // int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1}};
        int[][] dirA={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
        for(int d=0;d<8;d++){
            
                int x = r+xMove[d];
                int y = c+yMove[d];

                if(x>=0 && y>=0 && x<board.length && y<board[0].length){
                    if(board[x][y]) return false;
                }
                else break;
            
        }
        return true;
    }
    
     

    public static boolean knightTour_01(int[][] board, int r,int c, int move){
        board[r][c] = move;
        if(move == 63){
            for(int[] b : board){
                for(int ele:b) System.out.print(ele+" ");
                System.out.println();
            }
            return true;
        }
        boolean res = false;
    
        for(int d=0;d<8;d++){
            
            final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2}; 
            final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

            int x = r+xMove[d];
            int y = c+yMove[d];
            
            if(x>=0 && y>=0 && x<8 && y<8 && board[x][y] == -1){
                
                res = res || knightTour_01(board, x, y, move+1);
                
            }
            

        }
        board[r][c] = -1;
        return res;
        
    }       

    public static void knightTour(){
        int [][] board = new int[8][8];
        for(int i=0;i<board.length;i++){
            Arrays.fill(board[i], -1);
        }
        System.out.println(knightTour_01(board, 0, 0, 0)); 
    }


    
    
    public static void solve(){
        // coinChange();
        Nqueen();
        // knightTour();

    }
    
}