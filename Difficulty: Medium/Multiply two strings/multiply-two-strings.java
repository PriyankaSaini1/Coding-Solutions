class Solution {
    public String multiplyStrings(String s1, String s2) {
        // code here.
        
          // ----- 1. Handle sign -----
        boolean negative = false;
        if (s1.startsWith("-")) { negative = !negative; s1 = s1.substring(1); }
        if (s2.startsWith("-")) { negative = !negative; s2 = s2.substring(1); }

        // ----- 2. Trim leading zeros -----
        s1 = stripLeadingZeros(s1);
        s2 = stripLeadingZeros(s2);

        // ----- 3. Shortcut if any operand is 0 -----
        if (s1.equals("0") || s2.equals("0")) return "0";

        int n = s1.length(), m = s2.length();
        int[] a = new int[n];
        int[] b = new int[m];

        // least–significant digit first
        for (int i = 0; i < n; i++) a[i] = s1.charAt(n - 1 - i) - '0';
        for (int j = 0; j < m; j++) b[j] = s2.charAt(m - 1 - j) - '0';

        int[] prod = new int[n + m];      // max possible length

        // ----- 4. Core multiplication -----
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prod[i + j] += a[i] * b[j];
            }
        }

        // ----- 5. Carry pass -----
        for (int k = 0; k < prod.length - 1; k++) {
            int carry = prod[k] / 10;
            prod[k] %= 10;
            prod[k + 1] += carry;
        }

        // ----- 6. Build result string (skip leading zeros) -----
        StringBuilder sb = new StringBuilder();
        int idx = prod.length - 1;
        while (idx > 0 && prod[idx] == 0) idx--;   // skip extra leading zeros
        for (; idx >= 0; idx--) sb.append((char) (prod[idx] + '0'));

        if (negative) sb.insert(0, '-');
        return sb.toString();
        }
    
        // Helper to remove leading zeros; leaves exactly one '0' if all digits are zero
        private static String stripLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') i++;
        return s.substring(i);
        }
        
    
}