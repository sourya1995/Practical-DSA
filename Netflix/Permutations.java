/*
 * Feature 11 - generate permutations of movies for marathons - PROBLEM - generate permutations of an array
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }

    public void permuteStringRec(int[] nums, int currentIndex, List<List<Integer>> results){
        if(currentIndex == nums.length - 1){
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums){
                permutation.add(num);
            }
            results.add(permutation);
            return;
        }

        for(int index = currentIndex; index < nums.length; index++){
            swap(nums, currentIndex, index);
            permuteStringRec(nums, currentIndex + 1, results);
            swap(nums, currentIndex, index);
        }
    }

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        permuteStringRec(nums, 0, results);
        return results;
    }


}
