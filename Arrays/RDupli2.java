class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int k = 1, c = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                if (c < 2) {
                    nums[k++] = nums[i];
                    c++;
            }
    } else {
        nums [k++] = nums [i];
        c = 1;
    }
}
return k;
    }
}
