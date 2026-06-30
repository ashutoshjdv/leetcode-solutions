// Last updated: 6/30/2026, 7:14:50 PM
class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dSet = new HashSet<>();
        
        for(int i=0; i< deadends.length; i++) {
            if(deadends[i].equals("0000")) return -1;
            dSet.add(deadends[i]);
        }

        Deque<String> queue = new ArrayDeque<>();

        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int turns = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();

            while(size-- > 0) {

                String node = queue.poll();

                if(node.equals(target)) return turns;

                for(int i =0; i < 4; i++) {
                    //increment
                    char[] arrI = node.toCharArray();

                    arrI[i] = arrI[i] == '9' ? '0' : (char)(arrI[i]+1);

                    String strI = new String(arrI);

                    if(!dSet.contains(strI) && !visited.contains(strI)) {
                        queue.offer(strI);
                        visited.add(strI);
                    } 

                    //decrement
                    char[] arrD = node.toCharArray();

                    arrD[i] = arrD[i] == '0' ? '9' : (char)(arrD[i]-1);

                    String strD = new String(arrD);

                    if(!dSet.contains(strD) && !visited.contains(strD)) {
                        queue.offer(strD);
                        visited.add(strD);
                    } 



                }

            }

            turns++;

        }

        return -1;
    }
}