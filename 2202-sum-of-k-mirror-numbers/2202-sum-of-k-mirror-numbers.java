public class Solution {

    public boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public String toBaseK(long num, int k) {
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            res.append(num % k);
            num /= k;
        }
        return res.reverse().toString();
    }

    public long kMirror(int k, int n) {
        long sum = 0;
        int len = 1;

        while (n > 0) {
            int start = (int)Math.pow(10, (len - 1) / 2);
            int end = (int)Math.pow(10, (len + 1) / 2);

            for (int half = start; half < end && n > 0; ++half) {
                String h = Integer.toString(half);
                String r = new StringBuilder(h).reverse().toString();
                String full = len % 2 == 1 ? h + r.substring(1) : h + r;
                long num = Long.parseLong(full);
                if (isPalindrome(toBaseK(num, k))) {
                    sum += num;
                    n--;
                }
            }
            len++;
        }

        return sum;
    }
}
