/**
 * @Author:SCBC_LiYongJie
 *
 * @time:2022/1/12
 *          1995.统计特殊四元组
 *              我这里就是直接暴力解法了，官方给出的优化方案有两种，我没太追究不是很能看懂
 */
public class Question_1995 {
    static class Solution {
        public int countQuadruplets(int[] nums) {
            //n 个里面挑选4个元素 --- 尝试
            int i,j,k,l;
            int count = 0 ;
            for(i = 0 ; i <= nums.length-4 ; i ++){

                for(j = i+1 ; j <= nums.length-3 ; j++){

                    for(k = j+1 ; k <= nums.length-2 ; k++){

                        for(l = k+1 ; l < nums.length ; l++){

                            if(nums[i]+nums[j]+nums[k] == nums[l]){
                                count++;
                            }
                        }
                    }
                }
            }
            return count;
        }
    }

}
