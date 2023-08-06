/*
 * Feature 7 - Distribute work to process posts - PROBLEM - Divide Chocolate
 */

package Facebook;

import java.util.Arrays;

public class DivideChocolate {
    public static int divideChocolate(int[] sweetness, int k){
        int left = 1, right = Arrays.stream(sweetness).sum() / k;

        while(left < right){
            int mid = (left + right + 1) / 2;
            int target = 0;
            int divisions = 0;
            for(int sweet: sweetness ){
                target += sweet;
                if(target >= mid){
                    divisions++;
                    target = 0;
                }
            }
            if(divisions >= k)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
}
