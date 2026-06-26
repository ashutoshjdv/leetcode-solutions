// Last updated: 6/26/2026, 8:55:14 AM
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(map.containsKey(sorted)){
                List<String> a = map.get(sorted);
                a.add(strs[i]);
                map.put(sorted,a);
            } else{
                List<String> a= new ArrayList<>();
                a.add(strs[i]);
                map.put(sorted,a);
            }
        }
        List<List<String>> list = new ArrayList<>(map.values());
        
        return list;
    }
}