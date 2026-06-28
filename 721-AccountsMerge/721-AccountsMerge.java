// Last updated: 6/28/2026, 8:26:57 PM
class Solution {

    int[] parent;
    int[] size;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String,Integer> emailToId = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();

        int id = 0;

        for(List<String> account : accounts){

            String name = account.get(0);

            for(int i=1;i<account.size();i++){

                String email = account.get(i);

                if(!emailToId.containsKey(email)){
                    emailToId.put(email,id++);
                    emailToName.put(email,name);
                }
            }
        }

        parent = new int[id];
        size = new int[id];

        for(int i=0;i<id;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(List<String> account : accounts){

            int first = emailToId.get(account.get(1));

            for(int i=2;i<account.size();i++){

                union(first,emailToId.get(account.get(i)));

            }
        }

        Map<Integer,List<String>> groups = new HashMap<>();

        for(String email : emailToId.keySet()){

            int root = find(emailToId.get(email));

            groups.computeIfAbsent(root,k->new ArrayList<>()).add(email);

        }

        List<List<String>> ans = new ArrayList<>();

        for(List<String> emails : groups.values()){

            Collections.sort(emails);

            String name = emailToName.get(emails.get(0));

            emails.add(0,name);

            ans.add(emails);

        }

        return ans;
    }

    int find(int x){

        if(parent[x]==x)
            return x;

        return parent[x]=find(parent[x]);
    }

    void union(int u,int v){

        int ru=find(u);
        int rv=find(v);

        if(ru==rv)
            return;

        if(size[ru]>=size[rv]){

            parent[rv]=ru;
            size[ru]+=size[rv];

        }else{

            parent[ru]=rv;
            size[rv]+=size[ru];

        }
    }
}