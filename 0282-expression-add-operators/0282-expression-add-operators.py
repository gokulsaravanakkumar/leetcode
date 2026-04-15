class Solution:
    def addOperators(self, S: str, target: int) -> List[str]:
        q = [S[0]]
        
        for n in S[1:]:
            updated_q = []
            while q:
                node = q.pop()
                for o in {'*','+','-',''}:
                    if node[-1] == '0' and o == '':
                        i = len(node)-1
                        while i >= 0 and node[i] == '0':
                            i -= 1
                        if i < 0 or node[i] in {'*','+','-'}:
                            continue
                            
                    updated_q.append(node + o + n)
            q = updated_q[:]
        
        return [e for e in q if eval(e) == target]       