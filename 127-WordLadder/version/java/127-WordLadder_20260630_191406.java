// Last updated: 6/30/2026, 7:14:06 PM
1class Solution {
2
3    //two directional bfs technique
4
5    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
6
7        Set<String> wordSet = new HashSet<>(wordList);
8
9        if (!wordSet.contains(endWord))
10            return 0;
11
12        Set<String> beginSet = new HashSet<>();
13        Set<String> endSet = new HashSet<>();
14
15        beginSet.add(beginWord);
16        endSet.add(endWord);
17
18        // prevent revisiting
19        wordSet.remove(beginWord);
20        wordSet.remove(endWord);
21
22        int sequence = 1;
23
24        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
25
26            // Always expand the smaller frontier
27            if (beginSet.size() > endSet.size()) {
28                Set<String> temp = beginSet;
29                beginSet = endSet;
30                endSet = temp;
31            }
32
33            Set<String> nextLevel = new HashSet<>();
34
35            for (String word : beginSet) {
36
37                char[] arr = word.toCharArray();
38
39                for (int i = 0; i < arr.length; i++) {
40
41                    char original = arr[i];
42
43                    for (char c = 'a'; c <= 'z'; c++) {
44
45                        if (c == original)
46                            continue;
47
48                        arr[i] = c;
49
50                        String neighbor = new String(arr);
51
52                        // Two searches meet
53                        if (endSet.contains(neighbor))
54                            return sequence + 1;
55
56                        if (wordSet.contains(neighbor)) {
57                            nextLevel.add(neighbor);
58                            wordSet.remove(neighbor);
59                        }
60                    }
61
62                    arr[i] = original;
63                }
64            }
65
66            beginSet = nextLevel;
67            sequence++;
68        }
69
70        return 0;
71    }
72
73    //one directional bfs technique
74    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
75
76    //     Set<String> wordSet = new HashSet<>();
77
78    //     for(String word : wordList) {
79    //         wordSet.add(word);
80    //     }
81
82    //     if(!wordSet.contains(endWord)) return 0;
83
84    //     Deque<String> queue = new ArrayDeque<>();
85
86    //     queue.offer(beginWord);
87
88    //     int sequence = 1;
89
90    //     while(!queue.isEmpty()) {
91
92    //         int size = queue.size();
93
94    //         while(size-- > 0) {
95
96    //             String node = queue.poll();
97
98    //             for(int i=0; i<node.length(); i++) {
99
100    //                 for(int j=0; j<26;j++) {
101
102    //                     char[] arr = node.toCharArray();
103
104    //                     arr[i] = (char)('a' + j);
105
106    //                     String str = new String(arr);
107
108    //                     if(node.equals(str)) continue;
109
110
111    //                     if(str.equals(endWord)) return sequence+1;
112
113    //                     if(wordSet.contains(str)) {
114    //                         queue.offer(str);
115    //                         wordSet.remove(str);
116    //                     }
117                        
118
119    //                 }
120
121                    
122    //             }
123    //         }
124
125    //         sequence++;
126    //     }
127
128    //     return 0;
129
130        
131    // }
132}