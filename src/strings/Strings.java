package strings;

import java.util.Arrays;

public class Strings {

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
}
