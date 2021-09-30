import java.util.Arrays;

public class Solution {

    public static String solution(int i) {
        // Your code here
       String minionID = "";
       String primeWord = sieveOfEraosthenes(20231);
       for(int j = i; j < i+5; j++){
           minionID += primeWord.charAt(j);
       }

        return minionID;
    }

    private static String sieveOfEraosthenes(int n){
        String answer = "";
        //n+1 since 2 is on array position 2
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        for(int p = 2; p*p <= n; p++){
            if(prime[p]){
                for(int i = 2*p; i <= n; i += p){
                    prime[i] = false;
                }
            }
        }

        for(int i = 2; i <= n; i++){
            if(prime[i]){
                answer += Integer.toString(i);
            }
        }
        return answer;
    }

    /*private static String primeString(){
        //int limit = 10005;
        String answer = "";
        int amountOfPrimes = 0;
        for(int i = 2; answer.length() < 10005; i++){
            if( isPrimeNumber(i) ){
                answer += Integer.toString(i);
                amountOfPrimes++;
                System.out.println(i);
            }
        }
        System.out.println(amountOfPrimes);
        return answer;
    }

    private static boolean isPrimeNumber(int num){
        for (int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }*/
}
