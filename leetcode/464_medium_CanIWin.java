// Importance:xx
class Solution {
    Map<Integer, Boolean> cache;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
        cache = new HashMap<>();
        return canWin(new boolean[maxChoosableInteger], -desiredTotal);
    }

    private boolean canWin(boolean[] used, int current) {
        boolean canWin = false;
        int key = format(used);
        if (!cache.containsKey(key)) {
            for (int i =  used.length - 1 ; i >= 0 ; i--) {
                if (!used[i]) {
                    if (current + i + 1 >= 0) canWin = true;
                    break;
                }
            }
            if (!canWin) {
                for (int i =  used.length - 1 ; i >= 0 ; i--) {
                    if (!used[i]) {
                        used[i] = true;
                        canWin |= (!canWin(used, current + i + 1));
                        used[i] = false;
                        if (canWin) break;
                    }
                }
            }
            cache.put(key, canWin);
        }
        return cache.get(key);
    }

    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}
