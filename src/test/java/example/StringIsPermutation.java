package example;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * StringIsPermutation - given two strings ,it finds out if one is permutation of other
 *
 * @author Subhashis
 * @version 1.0
 */
public class StringIsPermutation {
    private boolean isPermutation(String a, String b) {
        char[] aArr = a.toCharArray();
        Arrays.sort(aArr);
        char[] bArr = b.toCharArray();
        Arrays.sort(bArr);
        return Arrays.equals(aArr, bArr);
    }

    private boolean isPermutationAlt(String a, String b) {
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            Integer occurrence = map.get(a.charAt(i));
            if (null != occurrence && occurrence > 0) {
                occurrence++;
            } else {
                occurrence = 1;
            }
            map.put(a.charAt(i), occurrence);
        }

        for (int i = 0; i < b.length(); i++) {
            Integer occurrence = map.get(b.charAt(i));
            if (null == occurrence || occurrence < 1) {
                return false;
            } else {
                map.put(b.charAt(i), --occurrence);
            }
        }
        return map.values().stream().noneMatch(integer -> integer > 0);
    }

    @Test
    public void testEqual() {
        assertTrue(isPermutation("abcd", "bcda"));
        assertTrue(isPermutationAlt("abcd", "bcda"));
        assertTrue(isPermutationAlt("abcd", "cabd"));
    }

    @Test
    public void testNotEqual() {
        assertFalse(isPermutation("abcd", "bbda"));
        assertFalse(isPermutationAlt("abcd", "bbda"));
        assertFalse(isPermutationAlt("abcd", ""));
        assertFalse(isPermutationAlt("abcd", "aaabbbcccd"));
        assertFalse(isPermutationAlt("aaabbbcccd", "abcd"));
    }
}
