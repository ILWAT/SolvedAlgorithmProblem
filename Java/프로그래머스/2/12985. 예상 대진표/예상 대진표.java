class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        int aCopy = a;
        int bCopy = b;
        
        for (; aCopy != bCopy; answer++) {
            aCopy = (aCopy + 1) / 2;
            bCopy = (bCopy + 1) / 2;
        }

        return answer;
    }
}