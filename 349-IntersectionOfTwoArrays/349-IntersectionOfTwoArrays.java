// Last updated: 6/26/2026, 8:54:38 AM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }
        for(int num : nums2) {
            set2.add(num);
        }

        for(int num : set1) {
            if(set2.contains(num)) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for(int num : result){
            res[i] = num;
            i++;
        }

        return res;

    }
}