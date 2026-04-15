class RomanToInteger 
{
    public int romanToInt(String s)
    {
        int I=1, V=5, X=10, L=50, C=100, D=500, M=1000, sum=0;
        
        for(int i = 0; i < s.length(); i++)
        {
            int currentVal = 0;
            if(s.charAt(i) == 'I') 
                currentVal = I;
            else if(s.charAt(i) == 'V') 
                currentVal = V;
            else if(s.charAt(i) == 'X') 
                currentVal = X;
            else if(s.charAt(i) == 'L') 
                currentVal = L;
            else if(s.charAt(i) == 'C') 
                currentVal = C;
            else if(s.charAt(i) == 'D') 
                currentVal = D;
            else if(s.charAt(i) == 'M') 
                currentVal = M;

            if (i + 1 < s.length()) 
            {
                int nextVal = 0;
                char nextChar = s.charAt(i + 1);
                
                if(nextChar == 'I') 
                    nextVal = I;
                else if(nextChar == 'V') 
                    nextVal = V;
                else if(nextChar == 'X') 
                    nextVal = X;
                else if(nextChar == 'L')
                     nextVal = L;
                else if(nextChar == 'C') 
                    nextVal = C;
                else if(nextChar == 'D') 
                    nextVal = D;
                else if(nextChar == 'M') 
                    nextVal = M;
                
                if (currentVal < nextVal) 
                {
                    sum -= currentVal;
                } 
                else 
                {
                    sum += currentVal;
                }
            } 
            else 
            {
                sum += currentVal;
            }
        }
        return sum;
    }
}
