// Last updated: 6/30/2026, 6:55:59 PM
1class Solution {
2
3    //two directional bfs technique
4    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
5
6        Set<String> wordSet = new HashSet<>();
7
8        for(String str : wordList) {
9            wordSet.add(str);
10        }
11
12        if(!wordSet.contains(endWord)) return 0;
13
14        Set<String> beginSet = new HashSet<>();
15        Set<String> endSet = new HashSet<>();
16
17        beginSet.add(beginWord);
18        endSet.add(endWord);
19
20        int sequence = 0;
21
22        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
23
24            for(String str : beginSet) {
25                if(endSet.contains(str)) return sequence +1;
26            }
27
28            if(beginSet.size() > endSet.size()) {
29                swap(beginSet, endSet);
30            }
31
32            Set<String> temp = new HashSet<>();
33
34            for(String str : beginSet) {
35                temp.add(str);
36            }
37
38            for(String str : temp) {
39
40                for(int i=0; i< str.length(); i++) {
41                    for(int j=0; j<26; j++) {
42                        char[] arr = str.toCharArray();
43
44                        arr[i] = (char)('a' + j);
45
46                        String neighbor = new String(arr);
47
48                        if(str.equals(neighbor)) continue;
49
50                        if(wordSet.contains(neighbor)) {
51                            wordSet.remove(neighbor);
52                            beginSet.add(neighbor);
53                        }
54                    }
55                }
56
57                beginSet.remove(str);
58            } 
59
60
61
62            sequence++;
63        }
64
65        return 0;
66
67    }
68
69    void swap(Set<String> beginSet, Set<String> endSet) {
70        Set<String> temp = beginSet;
71
72        beginSet = endSet;
73
74        endSet = temp;
75    }
76
77    //one directional bfs technique
78    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
79
80    //     Set<String> wordSet = new HashSet<>();
81
82    //     for(String word : wordList) {
83    //         wordSet.add(word);
84    //     }
85
86    //     if(!wordSet.contains(endWord)) return 0;
87
88    //     Deque<String> queue = new ArrayDeque<>();
89
90    //     queue.offer(beginWord);
91
92    //     int sequence = 1;
93
94    //     while(!queue.isEmpty()) {
95
96    //         int size = queue.size();
97
98    //         while(size-- > 0) {
99
100    //             String node = queue.poll();
101
102    //             for(int i=0; i<node.length(); i++) {
103
104    //                 for(int j=0; j<26;j++) {
105
106    //                     char[] arr = node.toCharArray();
107
108    //                     arr[i] = (char)('a' + j);
109
110    //                     String str = new String(arr);
111
112    //                     if(node.equals(str)) continue;
113
114
115    //                     if(str.equals(endWord)) return sequence+1;
116
117    //                     if(wordSet.contains(str)) {
118    //                         queue.offer(str);
119    //                         wordSet.remove(str);
120    //                     }
121                        
122
123    //                 }
124
125                    
126    //             }
127    //         }
128
129    //         sequence++;
130    //     }
131
132    //     return 0;
133
134        
135    // }
136}