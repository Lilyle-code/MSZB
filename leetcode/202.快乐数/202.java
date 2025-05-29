class Solution {
    public int getSum(int n){
        int sum = 0;
        while(n != 0){
            sum = sum + (n%10)*(n%10);
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> sumres = new HashSet<>();
        while(1 == 1){
            if(n == 1){
                return true;
            }
            if(sumres.contains(n)){
                return false;
            }else{
                sumres.add(n);
                n = getSum(n);
            }
        }
    }
}