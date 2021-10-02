public class Solution {

    //Memoization Array
    private static int mem[][] = new int[202][202];

    public static int solution(int n) {
        return count(1, n) - 1;
    }

    private static int count(int height, int left){

        if (left == 0){
            return 1;
        }

        if(left < height){
            return 0;
        }

        //Checks if solution for sub-problem has allready been calculated or still has to be calculated.
        if(mem[height][left] != 0){
            return mem[height][left];
        }

        int result = count(height+1, left - height) + count(height+1, left);

        mem[height][left] = result;
        return result;


    }
}
