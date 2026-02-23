class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>(); 
        // This set will store the last k elements (our sliding window)

        for(int i = 0 ; i < nums.length ; i++){
            // Loop through each index of the array

            if(set.contains(nums[i])){
                // If current number already exists in our window
                // That means duplicate found within distance <= k
                return true;
            }

            set.add(nums[i]);
            // Add current number into the window

            if(set.size() > k){
                // If window size becomes bigger than k
                // That means we are storing more than k previous elements

                set.remove(nums[i - k]);
                // Remove the element that is k positions behind
                // Because it is now too far away (distance > k)
            }
        }

        return false;
        // If loop ends without finding duplicates within k distance
        // Then no valid pair exists
    }
}