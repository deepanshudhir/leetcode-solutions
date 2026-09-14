class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mp = new HashMap<>();
        int l=0;
        int maxi=0;

        for(int r=0;r<fruits.length;r++){
            if(mp.containsKey(fruits[r])){
                mp.put(fruits[r],mp.get(fruits[r])+1);
            }else{
                mp.put(fruits[r],1);
            }

            while(mp.size()>2){
                int fruit = fruits[l];
                mp.put(fruit,mp.get(fruit)-1);

                if(mp.get(fruit)==0){
                    mp.remove(fruit);
                }
                l++;
            }
            maxi = Math.max(maxi,r-l+1);
        }
        return maxi;
    }
}