class Fancy {
  List<Integer> list ;
  long mod = 1_000_000_007;
  long mul = 1 , add = 0 ; 
    public Fancy() {
        list = new ArrayList<>();
    }
    long modPow(long a, long b) {
    long res = 1;
    a %= mod;

    while (b > 0) {
        if ((b & 1) == 1)
            res = (res * a) % mod;

        a = (a * a) % mod;
        b >>= 1;
    }

    return res;
}
    long inverse(long x){
    return modPow(x, mod-2);
}
    public void append(int val) {
       long stored = ((val - add + mod) % mod * inverse(mul) % mod) % mod;
        list.add((int)stored);
    }
    
    public void addAll(int inc) {
       add = (add + inc) % mod ;
    }
    
    public void multAll(int m) {
      add = (add * m) % mod ; 
       mul = (mul * m) % mod ; 
    }
    
    public int getIndex(int idx) {
        if(idx>=list.size())return -1 ;
        long val = list.get(idx);
        val = ((val * mul) % mod + add) % mod;
       return (int)val ; 
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */