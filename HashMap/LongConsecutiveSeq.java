class Solution {
    public int longestConsecutive(int[] nums) {
        int maxi=0;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
       
        for(int num:set){
            int curr=num;
            int streak=1;
            if(!set.contains(num-1)){
                while(set.contains(curr+1)){
                    streak++;
                    curr++;
                }
            maxi=Math.max(maxi,streak);
            }

        }
        return maxi;
    }
}