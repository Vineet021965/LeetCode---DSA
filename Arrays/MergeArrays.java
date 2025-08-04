class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int [] temp = new int [m];

        for (int x = 0; x < m; x++) {
            temp[x] = nums1[x];
        }
        while (i < m && j < n) {
            if (temp[i] <= nums2[j]) {
                nums1[k++] = temp[i++];
            }
            else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = temp[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }
}