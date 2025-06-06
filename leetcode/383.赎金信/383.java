class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            cnt[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            cnt[ransomNote.charAt(i) - 'a']--;
        }
        for(int c:cnt){
            if(c < 0)
                return false;
        }
        return true;
    }
}