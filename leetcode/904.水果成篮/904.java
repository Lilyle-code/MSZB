class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int substring = 0;
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int j = 0; j < fruits.length; j++){
            cnt.merge(fruits[j], 1, Integer::sum);
            while(cnt.size() > 2){
                cnt.merge(fruits[i], -1, Integer::sum);
                if(cnt.get(fruits[i]) == 0){
                    cnt.remove(fruits[i]);
                }
                i++;
            }
            substring = j-i+1;
            res = res <substring ? substring: res;
        }
        return res;
    }
}