class Solution {
    public int compress(char[] chars) {
        int compressedPtr = 0;
        int ptr = 0;
        Character prevChar = null;
        int count = 0;
        while (ptr < chars.length) {
            char c = chars[ptr];
            if (prevChar == null) {
                compressedPtr++;
            } else if (prevChar != c) {
                chars[compressedPtr - 1] = prevChar;
                if (count != 1) {
                    String countStr = String.valueOf(count);
                    for (int i = 0 ; i < countStr.length() ; i++)
                        chars[compressedPtr++] = countStr.charAt(i);
                }
                compressedPtr++;
                count = 0;
            }
            count++;
            prevChar = c;
            ptr++;
        }
        chars[compressedPtr - 1] = prevChar;
        if (count != 1) {
            String countStr = String.valueOf(count);
            for (int i = 0 ; i < countStr.length() ; i++)
                chars[compressedPtr++] = countStr.charAt(i);
        }
        return compressedPtr;
    }
}
