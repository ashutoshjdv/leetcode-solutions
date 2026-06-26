# Last updated: 6/26/2026, 8:54:26 AM
class Solution:
    def expressiveWords(self, s: str, words: List[str]) -> int:
        def split(s):
            c = ''
            res = []
            for s_i in s:
                if c == '' or s_i == c[-1]:
                    c += s_i
                else:
                    res.append(c)
                    c = s_i
            res.append(c)
            return res
        
        def check(gs, gw):
            if gs[0] != gw[0] or len(gs) - len(gw) < 0:
                return False
            elif len(gs) - len(gw) == 0:
                return True
            else:
                if len(gs) >= 3:
                    return True
            return False
        
        ans = 0
        ss = split(s)
        
        for word in words:
            ws = split(word)
            if len(ws) != len(ss):
                continue
            if all([check(gs, gw) for gs, gw in zip(ss, ws)]):
                ans += 1
        return ans