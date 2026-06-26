// Last updated: 6/26/2026, 8:55:20 AM
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
         set<char> hset;
        int ans=0;
        if(s.length()==0)return 0;
        int len=s.length();
        int l=0,r=0;
        while(r<len){
            if(hset.find(s[r])!=hset.end()){
                while(hset.find(s[r])!=hset.end()){
                    hset.erase(s[l]);
                    l++;
                }
            }
                hset.insert(s[r]);
                int s=hset.size();
                ans=max(ans,s);
            r++;
        }
        return ans;
    }
};