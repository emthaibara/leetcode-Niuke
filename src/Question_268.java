/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/16
 *      268. 丢失的数字
 *      题目要求的是时间o(n) 空间o(1)
 *      前面很好做到，重点是o（1）空间
 *      这个我是真想不到了
 *      一看官方解答，位运算秒杀----？？？？？？？我直接懵逼
 */

public class Question_268 {
    //这种数组的索引-值映射反转挺常用的，我挺喜欢用的，这里因为值都是小于等于n的正整数所以很好用---时间直接0ms
    static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int[] k = new int[n+1];
            for(int i : nums){
                k[i]++;
            }
            for(int i = 0 ; i <= n ; i++){
                if(k[i] == 0 )
                    return i;
            }
            return -1;
        }
    }
    //记录一下这种解法吧，暂时不太懂，这个异或运算符号的意思：对于二进制位的数来说，操作数相同为0，不同则1，按照这种操作得到一个新的二进制数
    static class optimization {
        public int missingNumber(int[] nums) {
            int xor = 0;
            int n = nums.length;
            for (int num : nums) {
                xor ^= num;
            }
            for (int i = 0; i <= n; i++) {
                xor ^= i;
            }
            return xor;
        }
    }

}
