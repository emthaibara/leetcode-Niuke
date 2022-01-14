import java.util.HashSet;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/14
 *          217. 存在重复元素
 *          简单的起飞，一个set直接秒杀了
 *          没啥好说的
 */

public class Question_217 {
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for(int k : nums){
                if(set.contains(k))
                    return true;
                set.add(k);
            }
            return false;
        }
    }
}
