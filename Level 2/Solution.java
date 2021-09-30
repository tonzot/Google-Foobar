import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

        public static int solution(String n, int b) {

            int k = n.length();
            ArrayList<String> minionIDs = new ArrayList<String>();
            while(!minionIDs.contains(n)) {
                int[] sortedIntArray = charArrayToSortedIntArray(n.toCharArray());
                String y = "";
                for (int i = 0; i < sortedIntArray.length; i++) {
                    y += sortedIntArray[i];
                }

                String x = "";

                for (int i = sortedIntArray.length - 1; i >= 0; i--) {
                    x += sortedIntArray[i];
                }



                int zCalc = convertFromBaseBToN(x, b, 10) - convertFromBaseBToN(y, b, 10);
                String z = String.valueOf(convertFromBaseBToN(String.valueOf(zCalc), 10, b));

                while (z.length() < k) {
                    z = "0" + z;
                }
                minionIDs.add(n);
                n = z;
            }

            return minionIDs.size() -  minionIDs.indexOf(n);
        }

        private static int[] charArrayToSortedIntArray(char[] chars){
            int[] intArray = new int[chars.length];
            for(int i = 0; i < intArray.length; i++){
                intArray[i] = Character.getNumericValue(chars[i]);
            }
            Arrays.sort(intArray);
            return intArray;
        }

        private static int convertFromBaseBToN(String number,int b, int n){
            int convertedNumberDecimal = 0;
            if(b != 10){
                int counter = 0;
                for(int i = number.length()-1; i >= 0; i--){
                    convertedNumberDecimal += Character.getNumericValue(number.charAt(i)) * Math.pow(b, counter);
                    counter++;
                }
            } else {
                try {
                    convertedNumberDecimal = Integer.parseInt(number);
                } catch (NumberFormatException nfe){
                    if(number == ""){

                    }
                }
            }
            if(n == 10){
                return convertedNumberDecimal;
            }
            String result = "";
            boolean finishedConverting = false;
            while(!finishedConverting){
                result = convertedNumberDecimal % n + result;
                convertedNumberDecimal /= n;
                if(convertedNumberDecimal == 0){
                    finishedConverting = true;
                }
            }
            return Integer.parseInt(result);
        }
    }
