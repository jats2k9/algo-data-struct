package strings;

import java.util.Arrays;

public class Strings {
    int start = 0;
    int end = 0;

    /**
     * https://leetcode.com/problems/valid-anagram/
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] count = new int[128];

        for (char sChar : sChars) {
            count[sChar]++;
        }
        for (char tChar : tChars) {
            count[tChar]--;
        }
        return Arrays.stream(count).filter(value -> value != 0).findFirst().isEmpty();
    }

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        for (int i = 0; i < s.length(); i++) {
            palindromeSize(s, i, i);
            palindromeSize(s, i, i + 1);
        }
        return s.substring(start + 1, end);
    }

    private void palindromeSize(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (r - l > 0 && r - l > end - start) {
            start = l;
            end = r;
        }
    }
}