// Last updated: 6/26/2026, 8:54:44 AM
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] frequency = new int[26];

        for(char key : s.toCharArray()) {
            frequency[key - 'a']++;
        }
        for(char key : t.toCharArray()) {
            frequency[key - 'a']--;
        }

        for(int num : frequency) {
            if(num != 0) return false;
        }

        return true;
    }
}