// Google
public class Codec {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append(',').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int begin = 0;
        int idx = s.indexOf(",", begin);
        while (idx >= 0) {
            int len = Integer.parseInt(s.substring(begin, idx));
            result.add(s.substring(idx + 1, idx + 1 + len));
            begin = idx + 1 + len;
            idx = s.indexOf(",", begin);
        }
        return result;
    }
}
