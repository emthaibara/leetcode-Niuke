
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/15
 *         **219. 存在重复元素 II
 *              这一题学习到了挺多东西
 *
 *              我的想法是双指针移动的作法----但很遗憾  1693 ms 的运行时间哈哈哈哈就离谱，主要问题在于数组比较小的时候我顺序遍历没啥问题
 *              但是数组很大（k也很大）的时候我这种作法就效率显而易见了。
 *              官方是如何解决的呢？
 *                      1.首先是用（TreeSet）BST树来优化搜索效率，但是还是不够，还是很慢
 *                          首先优化了什么？
 *                              利用bst的搜索二叉树结构，不重复特性，查找高效率
 *                              我们可以直接优化前k次的搜索
 *                              但是！！！！k和n如果很大的情况下还是没办法很好的优化
 *                      2.散列表优化（HashSet）
 *                          散列表的crud是  o(1)级别的！！！
 */

public class Question_219 {
    //双指针的作法 ---- 简单易懂，只要不满足i指针后移 ， j指针回退到i的后一位，注意临界情况，避免指针越界
    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(nums.length <= 1)return false;
            //翻译一下题目，满足 nums [i] = nums [j]条件下,是否存在一组i ，j的差值小于等于k
            int i = 0 , j = i+1 ;
            int size = nums.length;
            while(i < size){
                if(j >= size || (j - i) > k){
                    i++;
                    j = i+1 ;
                }else if(nums[i] != nums[j]){
                    j++;
                }else{
                    return true;
                }

            }
            return false;
        }


    }
    static class Optimization {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            //维护一个hasSet
            Set<Integer> set = new HashSet<>();
            /*
                算法分析：
                    遍历一边nums，每次先判断set里面是否存在该元素（第一次进入循环肯定是false）
                    如果不存在就添加进去，再判断当前已经添加的元素是否大于k---也就是保证重复出现的间隔要小于等于k
                    超过k了就要删除最旧添加的元素（与我上面的算法回退的操作类似）
                    如果满足<k的情况下出现重复直接返回false

             */
            for (int i = 0; i < nums.length; ++i) {
                if (set.contains(nums[i])) return true;
                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
}
