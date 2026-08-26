class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int n = s.length();
        int smallest = n;
        String ans = s;
        boolean flag = false;

        while (p2 < n) {
            if (s.charAt(p2) == '1') 
                count++;
            
            if (count == k) {
                flag = true;
                while (p1 <= p2 && s.charAt(p1) != '1')
                    p1++;

                if (smallest > p2 - p1 + 1) {
                    smallest = p2 - p1 + 1;
                    ans = s.substring(p1, p2 + 1);
                }
                if (smallest == p2 - p1 + 1) {
                    if (ans.compareTo(s.substring(p1, p2 + 1)) > 0)
                        ans = s.substring(p1, p2 + 1);
                }
                while (count == k) {
                    if (s.charAt(p1) == '1')
                        count--;
                    p1++;
                }
                while (p1 <= p2 && s.charAt(p1) != '1')
                    p1++;
            }
            p2++;
        }

        return flag ? ans : "";
    }
}