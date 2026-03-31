class Palindrome {
    public boolean isPalindrome(int x)
    {
        int sum=0;
        int rem=0;
        int num1=x;
        while(x>0)
        {
            rem=x%10;
            sum=(sum*10)+rem;
            x=x/10;
        }          
        if(num1==sum)
           return true;
        else
           return false;
    }
}
