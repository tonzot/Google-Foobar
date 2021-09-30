import java.util.ArrayList;

public class Solution {

    public static int solution(int total_lambs) {
        //Your code here
        int stingyPayout = stingyPayout(total_lambs);
        int generousPayout = generousPayout(total_lambs);

        return stingyPayout - generousPayout;
    }

    private static int stingyPayout(int total_lambs){
        ArrayList<Integer> henchmanPayouts = new ArrayList<Integer>();
        int counter = 0;
        boolean finished = false;

        while(total_lambs > 0 && !finished){
            if(henchmanPayouts.size() < 2) {
                counter++;
                henchmanPayouts.add(1);
                total_lambs--;
            } else {
                int temp = henchmanPayouts.get(henchmanPayouts.size()-2) + henchmanPayouts.get(henchmanPayouts.size()-1);
                if(temp <= total_lambs) {
                    henchmanPayouts.add(temp);
                    counter++;
                    total_lambs -= temp;
                } else {
                    finished = true;
                }
            }
        }
        return counter;
    }

    private static int generousPayout(int total_lambs){
        ArrayList<Integer> henchmanPayouts = new ArrayList<Integer>();
        int counter = 0;
        boolean finished = false;

        while(total_lambs > 0 && !finished){
            if(henchmanPayouts.size() == 0){
                henchmanPayouts.add(1);
                counter++;
                total_lambs--;
            } else {
                int temp = 2 * henchmanPayouts.get(henchmanPayouts.size()-1);
                if (temp <= total_lambs){
                    henchmanPayouts.add(temp);
                    counter++;
                    total_lambs -= temp;
                } else {
                    finished = true;
                }
            }
        }
        return counter;
    }

}
