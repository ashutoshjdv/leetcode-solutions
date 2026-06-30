// Last updated: 6/30/2026, 9:20:36 AM
1class Solution {
2    public int openLock(String[] deadends, String target) {
3
4        Set<String> dSet = new HashSet<>();
5        
6        for(int i=0; i< deadends.length; i++) {
7            if(deadends[i].equals("0000")) return -1;
8            dSet.add(deadends[i]);
9        }
10
11        Deque<String> queue = new ArrayDeque<>();
12
13        Set<String> visited = new HashSet<>();
14
15        queue.offer("0000");
16        visited.add("0000");
17
18        int turns = 0;
19
20        while(!queue.isEmpty()) {
21
22            int size = queue.size();
23
24            while(size-- > 0) {
25
26                String node = queue.poll();
27
28                if(node.equals(target)) return turns;
29
30                for(int i =0; i < 4; i++) {
31                    //increment
32                    char[] arrI = node.toCharArray();
33
34                    arrI[i] = arrI[i] == '9' ? '0' : (char)(arrI[i]+1);
35
36                    String strI = new String(arrI);
37
38                    if(!dSet.contains(strI) && !visited.contains(strI)) {
39                        queue.offer(strI);
40                        visited.add(strI);
41                    } 
42
43                    //decrement
44                    char[] arrD = node.toCharArray();
45
46                    arrD[i] = arrD[i] == '0' ? '9' : (char)(arrD[i]-1);
47
48                    String strD = new String(arrD);
49
50                    if(!dSet.contains(strD) && !visited.contains(strD)) {
51                        queue.offer(strD);
52                        visited.add(strD);
53                    } 
54
55
56
57                }
58
59            }
60
61            turns++;
62
63        }
64
65        return -1;
66    }
67}