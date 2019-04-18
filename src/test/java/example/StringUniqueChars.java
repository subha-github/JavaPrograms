package example;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * StringUniqueChars - provides an algorithm to find out if a string has all unique chars
 *
 * @author Subhashis
 * @version 1.0
 */
public class StringUniqueChars {

    private boolean isUniqueCharsInString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isUniqueCharsInStringAlternate(String str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                return false;
            }
            set.add(str.charAt(i));
        }
        return true;
    }

    @Test
    public void testUnique() {
        assertTrue(isUniqueCharsInString("abcd"));
        assertTrue(isUniqueCharsInStringAlternate("abcd"));
    }

    @Test
    public void testNonUnique() {
        assertFalse(isUniqueCharsInString("sfcvfd"));
        assertFalse(isUniqueCharsInStringAlternate("sfcvfd"));
    }

}
