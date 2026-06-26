// Last updated: 6/26/2026, 8:54:24 AM
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) return false;

        Arrays.sort(hand);

        Map<Integer, Integer> map = new TreeMap<>();

        for(int i=0; i<n; i++) {
            map.compute(hand[i], (k, v) -> (v == null) ? 1 : v + 1);
        }

        for(int key : map.keySet()) {

            int count = map.get(key);

            if(count == 0) continue;

            for(int i=0; i< groupSize; i++) {

                if(!map.containsKey(key+i)) return false;

                if(map.get(key+i) < count ) return false;

                map.put(key+i, map.get(key+i) - count);
            }
        }

        for(int key : map.keySet()) {
            if(map.get(key) != 0) return false;
        }

        return true;


    }
}