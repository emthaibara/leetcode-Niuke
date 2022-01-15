/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/15
 *      231. 2 的幂
 *      没啥难度，这里用位运算加快计算速度
 *      官方的神仙解法，简直不可能想到，直接O（1）
 *      这是给出的解法2：把问题转换成n是否为最大2的幂的约数
 *      这个很简单理解，但是我是真想到哈哈哈你，大家都是2乘上来的肯定就能除尽，也就是余数为0
 *      class Solution {
 *     static final int BIG = 1 << 30;
 *
 *     public boolean isPowerOfTwo(int n) {
 *         return n > 0 && BIG % n == 0;
 *     }
 * }
 */


public class Question_231 {
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            int k = 0;
            if(n == 0)return false;
            if(n == 1)return true;
            int x = 1 ;
            while(true){
                k = 1 << x;
                System.out.println(k);
                if(k == n)
                    return true;
                //这里要注意溢出情况！
                if(k > n || k < 0)
                    return false;
                x++;
            }
        }
    }
}
