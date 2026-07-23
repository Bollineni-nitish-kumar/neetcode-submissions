class Triplet{
    int num1;
    int num2;
    int num3;

    public Triplet(int num1,int num2,int num3){
        this.num1=num1;
        this.num2=num2;
        this.num3=num3;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Triplet other = (Triplet) o;

        if(this.num1 == other.num1 && this.num2 == other.num2 && this.num3 == other.num3){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        // Pass the exact same fields used in equals()
        return Objects.hash(num1, num2,num3);
    }
}



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        Set<Triplet> triplets  = new HashSet<>();

        for (int i=0; i< nums.length-1;i++){

            int j = i+1;
            int k = nums.length-1;

            while(j < k){
                if(nums[i]+nums[j]+nums[k] == 0){
                    triplets.add(new Triplet(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    continue;
                }

                if((nums[i]+nums[j]+nums[k]) > 0){
                    k--;
                    continue;
                }

                if((nums[i]+nums[j]+nums[k]) < 0){
                    j++;
                    continue;
                }

            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(Triplet triplet : triplets){
            List<Integer> comb = new ArrayList<>();
            comb.add(triplet.num1);
            comb.add(triplet.num2);
            comb.add(triplet.num3);
            ans.add(comb);

        }

        return ans;

        
    }
}
