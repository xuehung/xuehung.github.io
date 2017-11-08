public class Codec {
    Map<String, String> cache = new HashMap<>();
    public String encode(String longUrl) {
        int v = longUrl.hashCode();
        cache.put(String.valueOf(v), longUrl);
        return "http://tinyurl.com/" + v;
    }

    public String decode(String shortUrl) {
        String v = shortUrl.replace("http://tinyurl.com/", "");
        return cache.get(v);
    }
}
