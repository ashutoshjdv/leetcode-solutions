// Last updated: 6/30/2026, 10:14:07 AM
1class Solution {
2    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
3
4        Set<String> wordSet = new HashSet<>();
5
6        for(String word : wordList) {
7            wordSet.add(word);
8        }
9
10        if(!wordSet.contains(endWord)) return 0;
11
12        Deque<String> queue = new ArrayDeque<>();
13
14        queue.offer(beginWord);
15
16        int sequence = 1;
17
18        while(!queue.isEmpty()) {
19
20            int size = queue.size();
21
22            while(size-- > 0) {
23
24                String node = queue.poll();
25
26                for(int i=0; i<node.length(); i++) {
27
28                    for(int j=0; j<26;j++) {
29
30                        char[] arr = node.toCharArray();
31
32                        arr[i] = (char)('a' + j);
33
34                        String str = new String(arr);
35
36                        if(node.equals(str)) continue;
37
38
39                        if(str.equals(endWord)) return sequence+1;
40
41                        if(wordSet.contains(str)) {
42                            queue.offer(str);
43                            wordSet.remove(str);
44                        }
45                        
46
47                    }
48
49                    
50                }
51            }
52
53            sequence++;
54        }
55
56        return 0;
57
58        
59    }
60}