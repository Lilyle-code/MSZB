class Solution {
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    public boolean check(){
        Iterator iter = ori.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry =  (Map.Entry) iter.next();
            Integer val = (Integer)entry.getValue();
            Character key = (Character)entry.getKey();
            if(cnt.getOrDefault(key, 0) < val){
                return false;
            }
        } 
        return true;
    }

    public String minWindow(String s, String t) {
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int i = 0, sub = 0;
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < s.length(); j++){
            cnt.put(s.charAt(j), cnt.getOrDefault(s.charAt(j), 0) + 1);
            while(check()){
                sub = j - i + 1;
                if(sub < res){
                    left = i;
                    right = j;
                    res = sub;
                }
                if(cnt.containsKey(s.charAt(i))){
                    cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) - 1);
                }
                i++;
            }
        }
        return res == Integer.MAX_VALUE ? "": s.substring(left, right + 1);
    }
}