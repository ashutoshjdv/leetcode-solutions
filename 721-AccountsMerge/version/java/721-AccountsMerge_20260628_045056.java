// Last updated: 6/28/2026, 4:50:56 AM
1class Solution {
2
3    int[] parent;
4    int[] size;
5
6    public List<List<String>> accountsMerge(List<List<String>> accounts) {
7
8        Map<String,Integer> emailToId = new HashMap<>();
9        Map<String,String> emailToName = new HashMap<>();
10
11        int id = 0;
12
13        for(List<String> account : accounts){
14
15            String name = account.get(0);
16
17            for(int i=1;i<account.size();i++){
18
19                String email = account.get(i);
20
21                if(!emailToId.containsKey(email)){
22                    emailToId.put(email,id++);
23                    emailToName.put(email,name);
24                }
25            }
26        }
27
28        parent = new int[id];
29        size = new int[id];
30
31        for(int i=0;i<id;i++){
32            parent[i]=i;
33            size[i]=1;
34        }
35
36        for(List<String> account : accounts){
37
38            int first = emailToId.get(account.get(1));
39
40            for(int i=2;i<account.size();i++){
41
42                union(first,emailToId.get(account.get(i)));
43
44            }
45        }
46
47        Map<Integer,List<String>> groups = new HashMap<>();
48
49        for(String email : emailToId.keySet()){
50
51            int root = find(emailToId.get(email));
52
53            groups.computeIfAbsent(root,k->new ArrayList<>()).add(email);
54
55        }
56
57        List<List<String>> ans = new ArrayList<>();
58
59        for(List<String> emails : groups.values()){
60
61            Collections.sort(emails);
62
63            String name = emailToName.get(emails.get(0));
64
65            emails.add(0,name);
66
67            ans.add(emails);
68
69        }
70
71        return ans;
72    }
73
74    int find(int x){
75
76        if(parent[x]==x)
77            return x;
78
79        return parent[x]=find(parent[x]);
80    }
81
82    void union(int u,int v){
83
84        int ru=find(u);
85        int rv=find(v);
86
87        if(ru==rv)
88            return;
89
90        if(size[ru]>=size[rv]){
91
92            parent[rv]=ru;
93            size[ru]+=size[rv];
94
95        }else{
96
97            parent[ru]=rv;
98            size[rv]+=size[ru];
99
100        }
101    }
102}