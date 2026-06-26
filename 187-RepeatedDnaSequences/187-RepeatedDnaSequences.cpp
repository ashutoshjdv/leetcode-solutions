// Last updated: 6/26/2026, 8:55:00 AM
class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> ans;
        map<string,int> m;
        int l=0,r=10;
        string s1= s.substr(l,r);
        m[s1]++;
        
    while(r<=s.size()){
        s1=s1.substr(1)+s[r];
        m[s1]++;
        if(m[s1]==2)
            ans.push_back(s1);
        r++;
        
        }
        return ans;
    }
};