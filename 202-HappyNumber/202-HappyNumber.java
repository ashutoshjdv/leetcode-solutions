// Last updated: 6/26/2026, 8:54:57 AM
class Solution {
    public int operation(int n) {
        int result = 0;
        while(n > 0) {
            int digit = n % 10;
            result += digit * digit;
            n /= 10;
        }
        return result;
    }

    public boolean recursion(int n, HashSet<Integer> set) {
        if(n == 1) return true;
        if(set.contains(n)) return false;
        set.add(n);
        return recursion(operation(n),set);
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        return recursion(n, set);
    }
}