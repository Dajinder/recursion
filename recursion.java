// package recursion_revision;

public class recursion {
    public static void main(String[] args){
        solve();
    }
    public static void solve(){
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


        boolean[][] boxes=new boolean[4][4];
        int tnq = 4;

        System.out.println(queensPermutation2D(boxes, tnq, " "));

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
}